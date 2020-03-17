package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.GherkinKeyword;
import ExtentConfig.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static ExtentConfig.ExtentReportUtil.steps;
import static ExtentConfig.ExtentReportUtil.scenarios;

public class CommonSteps extends Driver {
	
	public WebDriver driver;
	
	@Given("Open Youtube")
	public void open_Youtube() throws InterruptedException, ClassNotFoundException {
		steps = scenarios.createNode(new GherkinKeyword("Given"), "Open Youtube");
		driver = driverInitialization("chrome");
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
	}

	@Then("Verify the title")
	public void verify_the_title() throws ClassNotFoundException {
		steps = scenarios.createNode(new GherkinKeyword("Then"), "Verify the title");
		driver.findElement(By.xpath("//*[contains(@href,'/feed/trending') and contains(@aria-label,'Trending')]")).click();
		driver.quit();
	}
}
