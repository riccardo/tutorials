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

package test.org.energy_home.jemma.tutorials.osgi.ipdservice.impl;

import static org.junit.Assert.assertEquals;

import org.energy_home.jemma.tutorials.osgi.ipdservice.impl.IPDServiceImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* Simple Test Suite
* 
* @author https://github.com/riccardo
* */
public class TestIPDServiceImpl {
	
	private static final Logger LOG = LoggerFactory.getLogger( TestIPDServiceImpl.class );

	/**
	 * this fuction is called once before all tests
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LOG.trace("setUpBeforeClass");
	}

	/**
	 * this fuction is called once after all tests
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		LOG.trace("tearDownAfterClass");
	}

	private IPDServiceImpl ipdserviceimpl;

	/**
	 * this fuction is called once before each test
	 */
	@Before
	public void setUp() throws Exception {
		LOG.trace("setUp");
		this.ipdserviceimpl = new IPDServiceImpl();
	}

	/**
	 * this fuction is called once after each test
	 */
	@After
	public void tearDown() throws Exception {
		LOG.trace("tearDown");
		this.ipdserviceimpl=null;
	}

	//checks that the service returns the default value
	@Test
	public void testGetEnergyConsumption() {
		assertEquals("IPDService",this.ipdserviceimpl.getTextMessage());
	}
}
