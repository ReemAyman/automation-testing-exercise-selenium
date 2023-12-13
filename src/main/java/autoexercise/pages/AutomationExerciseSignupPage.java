package autoexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.ElementActions;

public class AutomationExerciseSignupPage {
    /***** Locators *****/
    private WebDriver driver;
    private final By userSignUp_h2 = By.xpath("(//div[@class='signup-form'])/h2");
    private final By name_textarea = By.xpath("//input[@name='name']");
    private final By email_textarea = By.xpath("//div[@class='signup-form']//input[@name='email']");

    public AutomationExerciseSignupPage(WebDriver driver){
        this.driver = driver;
    }

    /***** Actions *****/
    public void enterSignupInfo(String name, String email){
        ElementActions.pressKey(driver, name_textarea, name);
        ElementActions.pressKey(driver, name_textarea, Keys.TAB);

        ElementActions.pressKey(driver, email_textarea, email);
        ElementActions.pressKey(driver, email_textarea, Keys.ENTER);
    }

    /***** Validations *****/
    public AutomationExerciseSignupPage validateSignupPageTitle(String expectedSignupPageTitle){
        String signupPageTitle =  driver.findElement(userSignUp_h2).getText();
        Assert.assertEquals(signupPageTitle, expectedSignupPageTitle);
        return this;
    }
}
