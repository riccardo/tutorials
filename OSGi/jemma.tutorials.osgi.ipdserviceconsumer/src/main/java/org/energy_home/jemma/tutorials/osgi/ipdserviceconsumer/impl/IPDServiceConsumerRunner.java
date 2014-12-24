package org.energy_home.jemma.tutorials.osgi.ipdserviceconsumer.impl;

import org.energy_home.jemma.tutorials.osgi.ipdservice.api.IPDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
			double ret = this.ipdservice.getEnergyConsumption();
			LOG.trace("IPDServiceConsumerRunner getEnergyConsumption = " + ret);
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
