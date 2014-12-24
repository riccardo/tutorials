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

package org.energy_home.jemma.tutorials.osgi.ipdserviceconsumer.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* Simple Activator
* 
* @author https://github.com/riccardo
* */
public class Activator implements BundleActivator{
	
	private static final Logger LOG = LoggerFactory.getLogger( Activator.class );
	
	@Override
	public void start(BundleContext arg0) throws Exception {
		LOG.debug("starting " + arg0.getBundle().getSymbolicName());
		
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		LOG.debug("stopping " + arg0.getBundle().getSymbolicName());
		
	}

}
