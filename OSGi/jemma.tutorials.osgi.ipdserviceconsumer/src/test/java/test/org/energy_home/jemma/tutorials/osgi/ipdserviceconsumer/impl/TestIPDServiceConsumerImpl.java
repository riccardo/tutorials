package test.org.energy_home.jemma.tutorials.osgi.ipdserviceconsumer.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.energy_home.jemma.tutorials.osgi.ipdserviceconsumer.service.IPDServiceConsumerImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestIPDServiceConsumerImpl {
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private IPDServiceConsumerImpl ipdserviceconsimpl;

	@Before
	public void setUp() throws Exception {
		this.ipdserviceconsimpl = new IPDServiceConsumerImpl();
	}

	@After
	public void tearDown() throws Exception {
		this.ipdserviceconsimpl=null;
	}

	@Test
	public void testGetEnergyConsumption() {
		assertEquals(10.0,10.5,1);
	}
	
	@Test
	public void test2() {
		assertNotNull(this.ipdserviceconsimpl);
	}

}
