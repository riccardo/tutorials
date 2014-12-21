package test.com.rictomasi.home_hacks.tutorial.osgi.demoservice.impl;

import static org.junit.Assert.*;

import com.rictomasi.home_hacks.tutorial.osgi.demoservice.impl.IPDServiceImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDemoServiceImpl {
	
	private static final Logger LOG = LoggerFactory.getLogger( TestDemoServiceImpl.class );

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LOG.trace("setUpBeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		LOG.trace("tearDownAfterClass");
	}

	private IPDServiceImpl demoserviceimpl;

	@Before
	public void setUp() throws Exception {
		LOG.trace("setUp");
		this.demoserviceimpl = new IPDServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
		LOG.trace("tearDown");
		this.demoserviceimpl=null;
	}

	@Test
	public void testGetEnergyConsumption() {
		assertEquals(10.0,this.demoserviceimpl.getEnergyConsumption(),0.1);
	}
	
	@Test
	public void test2() {
		assertNotNull(this.demoserviceimpl);
	}

}
