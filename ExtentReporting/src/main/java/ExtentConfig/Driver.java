package ExtentConfig;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
    public WebDriver driver;
    
    public WebDriver driverInitialization(String browserName){
        System.out.format("Starting driver: %s. \n", browserName);
        switch (browserName.toLowerCase()){
            case "chrome":
                setPropertyForChromeDriver();
        		ChromeOptions options = new ChromeOptions();
        		options.setPageLoadStrategy(PageLoadStrategy.NONE);
                driver = new ChromeDriver(options);
                break;
            case "firefox":
            	setPropertyForFireFoxDriver();
                driver = new FirefoxDriver();
                break;
            case "ie":
            	setPropertyForIEDriver();
                driver = new FirefoxDriver();
                break;
            default:
                throw new NotFoundException("Browser not found: " + browserName);
        }
        return driver;
    }

//    public WebDriver getDriver(){
//        return driver;
//    }

    public WebDriverWait getWebDriverWait(){
        return new WebDriverWait(driver, 60);
    }

    private void setPropertyForChromeDriver(){
        String chromeDriver = "./driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriver);
    }
    
    private void setPropertyForFireFoxDriver(){
    	String chromeDriver = "./driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriver);
    }
    
    private void setPropertyForIEDriver(){
    	String chromeDriver = "./driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriver);
    }

    public void terminateDriver(){
        System.out.println("Terminating driver.");
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
