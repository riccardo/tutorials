package test.org.energy_home.jemma.tutorials.osgi.ipdservice.impl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.org.energy_home.jemma.tutorials.osgi.ipdservice.impl.TestIPDServiceImpl;

@RunWith(Suite.class)
@SuiteClasses({ TestIPDServiceImpl.class,TestActivator.class })
public class AllTests {

}
