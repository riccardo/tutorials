package com.rictomasi.home_hacks.tutorial.osgi.demoserviceconsumer.impl;

import com.rictomasi.home_hacks.tutorial.osgi.demoservice.api.IPDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IPDServiceConsumerRunner implements Runnable{

	private long periodicity_ms;
	private boolean active;
	private IPDService demoservice;
	private static final Logger LOG = LoggerFactory.getLogger( IPDServiceConsumerRunner.class );

	public IPDServiceConsumerRunner(long periodicity_ms,
			IPDService demoservice) {
		LOG.debug("DemoServiceConsumerRunner constructor");
		this.periodicity_ms=periodicity_ms;
		this.active=true;
		this.demoservice=demoservice;
	}

	@Override
	public void run() {
		LOG.debug("DemoServiceConsumerRunner run startingS [periodicity_ms="+this.periodicity_ms+"]");
		
		while(this.active) {
			
			this.action();
			
			LOG.trace("DemoServiceConsumerRunner going to sleep for [periodicity_ms="+this.periodicity_ms+"]");
			
			try {
				Thread.sleep(this.periodicity_ms);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		LOG.debug("DemoServiceConsumerRunner greceful ending");
		
	}

	private void action() {
		LOG.trace("*** DemoServiceConsumerRunner action! *** ");
		if(this.demoservice!=null) {
			double ret = this.demoservice.getEnergyConsumption();
			LOG.trace("DemoServiceConsumerRunner getEnergyConsumption = " + ret);
		} else {
			LOG.warn("DemoServiceConsumerRunner null! ");
			
		}
		
	}

	public void stop() {
		LOG.debug("DemoServiceConsumerRunner greceful stop");
		this.active=false;
		
	}

	public void setPeriodicity(long periodicity_ms) {
		this.periodicity_ms=periodicity_ms;
		
	}

}
