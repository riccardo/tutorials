package test.org.energy_home.jemma.tutorials.osgi.ipdservice.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.energy_home.jemma.tutorials.osgi.ipdservice.impl.IPDServiceImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestIPDServiceImpl {
	
	private static final Logger LOG = LoggerFactory.getLogger( TestIPDServiceImpl.class );

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LOG.trace("setUpBeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		LOG.trace("tearDownAfterClass");
	}

	private IPDServiceImpl ipdserviceimpl;

	@Before
	public void setUp() throws Exception {
		LOG.trace("setUp");
		this.ipdserviceimpl = new IPDServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
		LOG.trace("tearDown");
		this.ipdserviceimpl=null;
	}

	@Test
	public void testGetEnergyConsumption() {
		assertEquals(10.0,this.ipdserviceimpl.getEnergyConsumption(),0.1);
	}
	
	@Test
	public void test2() {
		assertNotNull(this.ipdserviceimpl);
	}

}
