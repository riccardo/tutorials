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

import org.energy_home.jemma.tutorials.osgi.ipdservice.api.IPDService;
import org.energy_home.jemma.tutorials.osgi.ipdservice.impl.IPDServiceImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
* This is a simple test case to check the IDPService
* 
* @author https://github.com/riccardo
* */
public class TestActivator {
	
	
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

	private IPDService ipdservice;

	/**
	 * this fuction is called once before each test
	 */
	@Before
	public void setUp() throws Exception {
		this.ipdservice = new IPDServiceImpl();
	}

	/**
	 * this fuction is called once after each test
	 */
	@After
	public void tearDown() throws Exception {
		this.ipdservice = null;
	}

	/**
	 * A simple test case
	 */
	@Test
	public void test() {
		//TODO put some simple test here
		assertEquals(10.0,10.01,0.1);
	}
	

	/**
	 * Another test case
	 */
	@Test
	public void test2() {
		//TODO put some simple test here
	}

}
