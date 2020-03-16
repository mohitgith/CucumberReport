package TestRunner;

import org.testng.annotations.BeforeClass;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features = "src/main/java/Feature", 
					glue = { "StepDefinition" }, 
					tags = { "not @Ignore" }, 
					plugin= { "rerun:target/rerun.txt", "html:target/cucumber-reports/cucumber-pretty"})

public class Runner {

	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

//	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
//	public void feature(CucumberFeatureWrapper cucumberFeature) {
//		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
//	}
	
    @Test(dataProvider = "features")    
    public void feature(PickleEventWrapper eventwrapper,CucumberFeatureWrapper cucumberFeature) throws Throwable {
    	testNGCucumberRunner.runScenario(eventwrapper.getPickleEvent());
    }

//	@DataProvider
//	public Object[][] features() {
//		return testNGCucumberRunner.provideFeatures();
//	}
	
    @DataProvider(parallel=true)
    public Object[][] features() {  	
    	 return testNGCucumberRunner.provideScenarios();
    }

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		testNGCucumberRunner.finish();
	}
	
    @AfterMethod
    public void appendFinalHTMLReport(ITestResult result) throws Exception{
        if(result.getStatus() == ITestResult.FAILURE)
        {
        	
        }
     }
}
