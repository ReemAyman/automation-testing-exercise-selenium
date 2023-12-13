package autoexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;

public class AutomationExerciseMainMenu {
    /***** Locators *****/
    private WebDriver driver;

    private final By signupButton_button = By.xpath("(//i[@class='fa fa-lock'])");

    public AutomationExerciseMainMenu(WebDriver driver){
        this.driver = driver;
    }

    /***** Actions *****/
    public void navigateToSignupPage(){
        ElementActions.click(driver, signupButton_button);
    }
}
