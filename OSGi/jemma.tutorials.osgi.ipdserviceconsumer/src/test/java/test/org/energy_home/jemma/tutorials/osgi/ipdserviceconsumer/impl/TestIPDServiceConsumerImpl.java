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

package test.org.energy_home.jemma.tutorials.osgi.ipdserviceconsumer.impl;

import org.energy_home.jemma.tutorials.osgi.ipdserviceconsumer.service.IPDServiceConsumerImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
* Simple Test Suite
* 
* @author https://github.com/riccardo
* */
public class TestIPDServiceConsumerImpl {
	

	/**
	 * this fuction is called once before all tests
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * this fuction is called once after all tests
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private IPDServiceConsumerImpl ipdserviceconsimpl;

	/**
	 * this fuction is called once before each test
	 */
	@Before
	public void setUp() throws Exception {
		this.ipdserviceconsimpl = new IPDServiceConsumerImpl();
	}

	/**
	 * this fuction is called once after each test
	 */
	@After
	public void tearDown() throws Exception {
		this.ipdserviceconsimpl=null;
	}

	@Test
	public void testGetEnergyConsumption() {
		//FIXME write some text here
	}
	
	@Test
	public void test2() {
		//FIXME write some text here
	}

}
