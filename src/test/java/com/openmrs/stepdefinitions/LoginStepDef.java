package com.openmrs.stepdefinitions;

import com.openmrs.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginStepDef {
    WebDriver driver= DriverHelper.getDriver();
    LoginPage loginPage=new LoginPage(driver);

    @Given("User provides the {string} and {string} with login")
    public void user_provides_the_and_with_login(String username, String password) throws InterruptedException {
        loginPage.login(ConfigReader.readProperty("QA_username"),
                ConfigReader.readProperty("QA_password"));
    }



    @Then("User validates the {string} and {string}")
    public void user_validates_the_and(String expectedTitle, String expectedUrl) {
        Assert.assertEquals(expectedTitle,driver.getTitle().trim());
        Assert.assertEquals(expectedUrl,driver.getCurrentUrl().trim());
    }

    @Given("User provides {string} and {string}")
    public void user_provides_and(String username, String password) throws InterruptedException {
        loginPage.login(username,password);

    }
    @Then("User validates {string}")
    public void user_validates(String expectedMessage) {
        Assert.assertEquals(expectedMessage,loginPage.validateMessage());

    }

}
