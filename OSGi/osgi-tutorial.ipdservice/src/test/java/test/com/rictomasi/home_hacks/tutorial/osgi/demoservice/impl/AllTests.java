package test.com.rictomasi.home_hacks.tutorial.osgi.demoservice.impl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestDemoServiceImpl.class,TestActivator.class })
public class AllTests {

}
