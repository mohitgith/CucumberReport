package ExtentConfig;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtil {
	
    public ExtentReports extent;
    public static ExtentTest features;
    public static ExtentTest scenarios;
    public static ExtentTest steps;

	Date date = new Date();
	String reportName = "Test_Report_" + date.toString().replace(" IST", "").replace(" ", "_").replace(":", "_") + ".html";
    String fileName = "./report/" + reportName;

    public void extentReport() {
        extent = new ExtentReports();

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setDocumentTitle("Extent Test Report");
        htmlReporter.config().setReportName("YouTube Test Report");
        htmlReporter.config().setTheme(Theme.DARK);
        
        extent.attachReporter(htmlReporter);
        
        try {
			extent.setSystemInfo("Hostname", InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("User", System.getProperty("user.name"));
    }


    public void flushReport(){
        extent.flush();
    }
}
