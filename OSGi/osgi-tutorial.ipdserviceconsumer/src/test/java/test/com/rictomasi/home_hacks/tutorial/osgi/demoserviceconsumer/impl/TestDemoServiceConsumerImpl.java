package test.com.rictomasi.home_hacks.tutorial.osgi.demoserviceconsumer.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.rictomasi.home_hacks.tutorial.osgi.demoserviceconsumer.service.IPDServiceConsumerImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestDemoServiceConsumerImpl {
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private IPDServiceConsumerImpl demoserviceconsimpl;

	@Before
	public void setUp() throws Exception {
		this.demoserviceconsimpl = new IPDServiceConsumerImpl();
	}

	@After
	public void tearDown() throws Exception {
		this.demoserviceconsimpl=null;
	}

	@Test
	public void testGetEnergyConsumption() {
		assertEquals(10.0,10.5,1);
	}
	
	@Test
	public void test2() {
		assertNotNull(this.demoserviceconsimpl);
	}

}
