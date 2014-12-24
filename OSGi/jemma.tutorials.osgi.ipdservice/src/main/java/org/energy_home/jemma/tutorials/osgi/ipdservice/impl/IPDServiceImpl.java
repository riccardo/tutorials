/**
 * This file is part of JEMMA - http://jemma.energy-home.org
 * (C) Copyright 2014 Istituto Superiore Mario Boella (http://www.ismb.it)
 *
 * JEMMA is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License (LGPL) version 3
 * or later as published by the Free Software Foundation, which accompanies
 * this distribution and is available at http://www.gnu.org/licenses/lgpl.html
 *
 * JEMMA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License (LGPL) for more details.
 *
 */

package org.energy_home.jemma.tutorials.osgi.ipdservice.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import org.energy_home.jemma.tutorials.osgi.ipdservice.api.IPDService;
import org.energy_home.jemma.tutorials.osgi.ipdservice.api.NoMessageAvailableExeption;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* Simple IPDService implementation
* 
* @author https://github.com/riccardo
* */
public class IPDServiceImpl implements IPDService, ManagedService{
	
	private static final Logger LOG = LoggerFactory.getLogger( IPDServiceImpl.class );
	public static final String DEFAULT_MESSAGE = "IPDService";
	private List<String> stack = new ArrayList<String>();
	private String currentmessage = DEFAULT_MESSAGE;
	
	protected void activate() {
		LOG.debug("Activating IPDService");
	}
	
	protected void deactivate() {
		LOG.debug("Deactivating IPDService");
	}

	@Override
	public void updated(Dictionary<String, ?> props)
			throws ConfigurationException {
	
        if (props == null) {
            // no configuration from configuration admin
            // or old configuration has been deleted
        	LOG.debug("Configuration not available: creating default configuration");
        	this.createDefaultConfiguration();

        } else {
            // apply configuration from config admin
        	LOG.debug("Configuration changed or made available by ConfigAdmin: loading");
        	String tmp_currentmessage =  (String) props.get("currentmessage");
        	this.currentmessage =tmp_currentmessage;
        	LOG.trace("this.currentmessage  set to:",this.currentmessage);
        }
		
	}

	private void createDefaultConfiguration() {
		//from http://felix.apache.org/documentation/subprojects/apache-felix-config-admin.html
		//thanks http://stackoverflow.com/questions/6527306/best-technique-for-getting-the-osgi-bundle-context
		BundleContext mycontext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		ServiceReference configurationAdminReference = mycontext.getServiceReference(ConfigurationAdmin.class.getName());
		
        if (configurationAdminReference != null) 
        {  
            ConfigurationAdmin confAdmin = (ConfigurationAdmin) mycontext.getService(configurationAdminReference);
            //FIXME maybe the PID can be taken from the DS properties ?
            Configuration config = null;
			try {
				config = confAdmin.getConfiguration("org.energy_home.jemma.tutorials.osgi.IPDService");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            	Dictionary props = config.getProperties();

            	// if null, the configuration is new
            	if (props == null) {
            	    props = new Hashtable();
            	}

            	// set some properties
            	LOG.trace("setting this.currentmessage  set to default:",IPDServiceImpl.DEFAULT_MESSAGE);
            	props.put("currentmessage", this.DEFAULT_MESSAGE+"");
            	this.currentmessage=IPDServiceImpl.DEFAULT_MESSAGE;

            	// update the configuration
            	try {
					config.update(props);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }  
		
	}
	


	@Override
	public void pushNewTextMessage(String textmessage) {
		this.stack.add(textmessage);
		this.update();
	}

	//this method is called every time a message is added or removed.
	private void update() {
		if(this.stack.size()==0) {
			this.currentmessage = DEFAULT_MESSAGE;
		} else {
			this.currentmessage = this.stack.get(this.stack.size()-1);
		}
	}

	@Override
	public String popOlderTextMessage() throws NoMessageAvailableExeption {
		if(this.stack.isEmpty()) {
			throw new NoMessageAvailableExeption();
		}
		
		String ret = this.stack.get(0);
		this.stack.remove(0);
		this.update();
		
		return ret;
	}

	@Override
	public String getCurrentlyDisplayedTextMessage() {
		return this.currentmessage;
	}

	@Override
	public int countStackedTextMessages() {
		return this.stack.size();
	}



}
