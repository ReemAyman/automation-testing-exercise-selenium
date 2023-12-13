package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    public static WebDriver initializeDriver(String browserType, boolean maximize, boolean headless){
        WebDriver driver = null;
        if (browserType.equals("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            if (headless){
                chromeOptions.addArguments("headless --new");
            }
                driver = new ChromeDriver(chromeOptions);
        }else if (browserType.equals("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            if (headless){
                firefoxOptions.addArguments("headless");
            }
            driver = new FirefoxDriver(firefoxOptions);
        }else if (browserType.equals("edge")) {
            driver = new EdgeDriver();
        }else {
            driver = new SafariDriver();
        }
        if (maximize)
            driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver initializeDriver(){
        return initializeDriver(
                System.getProperty("browserType"),
                Boolean.parseBoolean(System.getProperty("maximizeWindow")),
                Boolean.parseBoolean(System.getProperty("headlessExecution")));
    }
}
