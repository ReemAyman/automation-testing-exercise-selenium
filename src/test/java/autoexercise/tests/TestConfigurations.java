package autoexercise.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.DriverFactory;
import utils.JsonFileManager;
import utils.PropertiesReader;

public class TestConfigurations {
    /****** Drivers and Managers *****/
    WebDriver driver;
    JsonFileManager testData;

    /**** Configurations ****/
    @BeforeClass
    public void beforeClass(){
        PropertiesReader.loadProperties();
        driver = DriverFactory.initializeDriver();
        testData = new JsonFileManager("src/test/resources/Test Data/TestData.json");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
