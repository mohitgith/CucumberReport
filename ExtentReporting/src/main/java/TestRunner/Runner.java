package TestRunner;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(features = "src/main/java/Feature", 
					glue = { "StepDefinition" }, 
					tags = { "not @Ignore" }, 
					plugin= { "rerun:target/rerun.txt"})

public class Runner{

	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	
    @Test(dataProvider = "features")    
    public void feature(PickleEventWrapper eventwrapper,CucumberFeatureWrapper cucumberFeature) throws Throwable {
    	testNGCucumberRunner.runScenario(eventwrapper.getPickleEvent());
    }
	
    @DataProvider(parallel=true)
    public Object[][] features() {  	
    	 return testNGCucumberRunner.provideScenarios();
    }

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		testNGCucumberRunner.finish();
	}
}
