package autoexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AutomationExerciseHomePage {
    /***** Locators *****/
    private WebDriver driver;
    private final By pageTitle_h2 =  By.xpath("//div[@class=\"features_items\"]//h2");

    public AutomationExerciseHomePage(WebDriver driver){
        this.driver = driver;
    }

    /***** Actions *****/
    public AutomationExerciseHomePage navigateToHomePage(String url){
        driver.navigate().to(url);
        return this;
    }

    /***** Validations *****/
    public void validateOpenHomepage(String expectedHomePageTitle){
        String homePageTitle = driver.findElement(pageTitle_h2).getText();
        Assert.assertEquals(homePageTitle, expectedHomePageTitle);
    }
}
