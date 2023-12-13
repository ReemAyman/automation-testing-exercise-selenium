package autoexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.ElementActions;

public class AutomationExerciseAccountInfoPage {

    /***** Locators *****/
    private WebDriver driver;
    private final By loginInfo_h2 = By.xpath("//div[@class='login-form']/h2[@class='title text-center']");
    private final By gender_textarea = By.id("id_gender2");
    private final By password_textarea = By.id("password");
    private final By bDay_button = By.xpath("//select[@id='days']//option[@value='3']");
    private final By bMonth_button = By.xpath("//select[@id='months']//option[@value='12']");
    private final By bYear_button = By.xpath("//select[@id='years']//option[@value='2001']");

    private final By firstName_textarea = By.xpath("//input[@name='first_name']");
    private final By lastName_textarea = By.xpath("//input[@name='last_name']");
    private final By company_textarea = By.xpath("//input[@name='company']");
    private final By address1_textarea = By.xpath("//input[@name='address1']");
    private final By address2_textarea = By.xpath("//input[@name='address2']");
    private final By country_dropdown = By.xpath("//select[@id='country']//option[@value='Canada']");
    private final By state_textarea = By.xpath("//input[@name='state']");
    private final By city_textarea = By.xpath("//input[@name='city']");
    private final By zipcode_textarea = By.xpath("//input[@name='zipcode']");
    private final By mobileNumber_textarea = By.xpath("//input[@name='mobile_number']");

    private final By accountCreated_text = By.xpath("//h2[@class='title text-center']");

    public AutomationExerciseAccountInfoPage(WebDriver driver){
        this.driver = driver;
    }

    /***** Actions *****/
    public AutomationExerciseAccountInfoPage enterAccountInformation
    (String password, String firstName,String lastName,String company){
        ElementActions.click(driver, gender_textarea);
        ElementActions.pressKey(driver, password_textarea, password);

        ElementActions.click(driver, bDay_button);
        ElementActions.click(driver, bMonth_button);
        ElementActions.click(driver, bYear_button);


        ElementActions.pressKey(driver, firstName_textarea, firstName);
        ElementActions.pressKey(driver, firstName_textarea, Keys.TAB);

        ElementActions.pressKey(driver, lastName_textarea, lastName);
        ElementActions.pressKey(driver, lastName_textarea, Keys.TAB);

        ElementActions.pressKey(driver, company_textarea, company);
        ElementActions.pressKey(driver, company_textarea, Keys.TAB);
        return this;
    }

    public AutomationExerciseAccountInfoPage enterAddressInformation
            (String address1, String address2,String state,
             String city, String zipcode, String mobileNumber){
        ElementActions.pressKey(driver, address1_textarea, address1);
        ElementActions.pressKey(driver, address1_textarea, Keys.TAB);

        ElementActions.pressKey(driver, address2_textarea, address2);
        ElementActions.pressKey(driver, address2_textarea, Keys.TAB);

        ElementActions.click(driver, country_dropdown);

        ElementActions.pressKey(driver, state_textarea, state);
        ElementActions.pressKey(driver, state_textarea, Keys.TAB);

        ElementActions.pressKey(driver, city_textarea, city);
        ElementActions.pressKey(driver, city_textarea, Keys.TAB);

        ElementActions.pressKey(driver, zipcode_textarea, zipcode);
        ElementActions.pressKey(driver, zipcode_textarea, Keys.TAB);

        ElementActions.pressKey(driver, mobileNumber_textarea, mobileNumber);
        ElementActions.pressKey(driver, mobileNumber_textarea, Keys.ENTER);
        return this;
    }

    /***** Validations *****/
    public AutomationExerciseAccountInfoPage validateAccountInfoPageTitle(String actualAccountPageTitle){
        String accountPageTitle = driver.findElement(loginInfo_h2).getText();
        Assert.assertEquals(accountPageTitle, actualAccountPageTitle);
        return this;
    }

    public void validateAccountCreatedMessage(String expectedAccountCreatedText){
        String accountCreatedText = driver.findElement(accountCreated_text).getText();
        Assert.assertEquals(accountCreatedText, expectedAccountCreatedText);
    }
}
