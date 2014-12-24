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

package org.energy_home.jemma.tutorials.osgi.ipdserviceconsumer.impl;

import org.energy_home.jemma.tutorials.osgi.ipdservice.api.IPDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* Simple Thread that periodically calls the IPDService
* 
* @author https://github.com/riccardo
* */
public class IPDServiceConsumerRunner implements Runnable{

	private long periodicity_ms;
	private boolean active;
	private IPDService ipdservice;
	private static final Logger LOG = LoggerFactory.getLogger( IPDServiceConsumerRunner.class );

	public IPDServiceConsumerRunner(long periodicity_ms,
			IPDService ipdservice) {
		LOG.debug("IPDServiceConsumerRunner constructor");
		this.periodicity_ms=periodicity_ms;
		this.active=true;
		this.ipdservice=ipdservice;
	}

	@Override
	public void run() {
		LOG.debug("IPDServiceConsumerRunner run startingS [periodicity_ms="+this.periodicity_ms+"]");
		
		while(this.active) {
			
			this.action();
			
			LOG.trace("IPDServiceConsumerRunner going to sleep for [periodicity_ms="+this.periodicity_ms+"]");
			
			try {
				Thread.sleep(this.periodicity_ms);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		LOG.debug("IPDServiceConsumerRunner greceful ending");
		
	}

	private void action() {
		LOG.trace("*** IPDServiceConsumerRunner action! *** ");
		if(this.ipdservice!=null) {
			String ret = this.ipdservice.getCurrentlyDisplayedTextMessage();
			LOG.trace("IPDServiceConsumerRunner getCurrentlyDisplayedTextMessage = " + ret);
		} else {
			LOG.warn("IPDServiceConsumerRunner null! ");
			
		}
		
	}

	public void stop() {
		LOG.debug("IPDServiceConsumerRunner greceful stop");
		this.active=false;
		
	}

	public void setPeriodicity(long periodicity_ms) {
		this.periodicity_ms=periodicity_ms;
		
	}

}
