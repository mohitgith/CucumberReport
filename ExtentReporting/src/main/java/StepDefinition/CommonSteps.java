package StepDefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CommonSteps {
	public WebDriver driver = null;
	Scenario scenario;
	
	@Before
	public void testSetup(Scenario scenario) {
		this.scenario = scenario;
		System.out.println("Test Environment Setup");
		System.out.println("======================");
		System.out.println("Executing Scenario : " + scenario.getName());
	}
	
	@After
	public void tearDown(Scenario scenario) {
		scenario.write("Finished Scenario");
		
		if(scenario.isFailed()) {
			scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
		}
		System.out.println("Test Environment Shut-Down");
		System.out.println("==========================");
	}
	
	@Given("Open the browser")
	public void open_the_browser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Then("Open Youtube and verify the title")
	public void open_Youtube_and_verify_the_title() {
		driver.get("https://www.youtube.com/");
		String title = driver.getTitle();
		Assert.assertEquals(title, "YouTube");
	}

	@Then("Close the browser")
	public void close_the_browser() {
		driver.close();
	}
}
