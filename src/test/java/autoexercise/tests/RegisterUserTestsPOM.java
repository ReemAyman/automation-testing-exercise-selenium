package autoexercise.tests;

import autoexercise.pages.AutomationExerciseAccountInfoPage;
import autoexercise.pages.AutomationExerciseHomePage;
import autoexercise.pages.AutomationExerciseMainMenu;
import autoexercise.pages.AutomationExerciseSignupPage;
import org.testng.annotations.Test;


public class RegisterUserTestsPOM extends TestConfigurations{

    /***** Testcases *****/
    @Test
    public void registerUserTestcase(){
        new AutomationExerciseHomePage(driver)
                .navigateToHomePage("http://automationexercise.com")
                .validateOpenHomepage("FEATURES ITEMS");
        new AutomationExerciseMainMenu(driver).navigateToSignupPage();
        new AutomationExerciseSignupPage(driver)
                .validateSignupPageTitle("New User Signup!")
                .enterSignupInfo(testData.getTestData("$.Account1.name"), testData.getTestData("$.Account1.email"));
        new AutomationExerciseAccountInfoPage(driver)
                .validateAccountInfoPageTitle("ENTER ACCOUNT INFORMATION")
                .enterAccountInformation(testData.getTestData("$.Account1.password"), testData.getTestData("$.Account1.firstName"),
                        testData.getTestData("$.Account1.lastName"), testData.getTestData("$.Account1.company"))
                .enterAddressInformation(testData.getTestData("$.Account1.address1"), testData.getTestData("$.Account1.address2"),
                        testData.getTestData("$.Account1.state"), testData.getTestData("$.Account1.city"),
                        testData.getTestData("$.Account1.zipcode"), testData.getTestData("$.Account1.mobileNumber"))
                .validateAccountCreatedMessage("ACCOUNT CREATED!");

    }
}
