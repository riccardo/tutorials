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
import java.util.Dictionary;
import java.util.Hashtable;

import org.energy_home.jemma.tutorials.osgi.ipdservice.api.IPDService;
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

	public static final double DEFAULT_ENERGY_CONSUMPTION = 10;
	
	private double energy_consumption=DEFAULT_ENERGY_CONSUMPTION;

	protected void activate() {
		LOG.debug("Activating IPDService");
	}
	
	protected void deactivate() {
		LOG.debug("Deactivating IPDService");
	}

	@Override
	public double getEnergyConsumption() {
		LOG.info("getEnergyConsumption called, returning: " + this.energy_consumption);
		return this.energy_consumption;
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
        	String tmp_energy_consumption =  (String) props.get("energy_consumption");
        	this.energy_consumption=Double.parseDouble(tmp_energy_consumption);
        	LOG.trace("this.energy_consumption set to:",this.energy_consumption);
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
            	LOG.trace("setting this.energy_consumption set to default:",IPDServiceImpl.DEFAULT_ENERGY_CONSUMPTION);
            	props.put("energy_consumption", this.DEFAULT_ENERGY_CONSUMPTION+"");
            	this.energy_consumption=IPDServiceImpl.DEFAULT_ENERGY_CONSUMPTION;

            	// update the configuration
            	try {
					config.update(props);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }  
		
	}



}
