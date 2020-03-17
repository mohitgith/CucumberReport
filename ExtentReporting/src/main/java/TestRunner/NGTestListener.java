package TestRunner;

import ExtentConfig.Driver;
import ExtentConfig.ExtentReportUtil;
import io.cucumber.core.api.Scenario;
import com.aventstack.extentreports.GherkinKeyword;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import static ExtentConfig.ExtentReportUtil.features;
import static ExtentConfig.ExtentReportUtil.scenarios;

public class NGTestListener implements ITestListener {

    ExtentReportUtil extentReportUtil = new ExtentReportUtil();
    Driver driver = new Driver();

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("On Test Start");
        extentReportUtil.extentReport();
        try {
			features = extentReportUtil.extent.createTest(new GherkinKeyword("Feature"), "Verify Title Feature");
			scenarios = features.createNode(new GherkinKeyword("Scenario"), "Scenario Test");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
    	
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("On Start");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("On Finish");
        extentReportUtil.flushReport();
    }
}
