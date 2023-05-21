package com.openmrs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//button[@name='loginbtn']")
    WebElement login;

    @FindBy(xpath = "//div[text()='Authentication failed']")
    WebElement errorMessage;


    public void login(String username, String password) throws InterruptedException {
        this.username.clear();
        Thread.sleep(3000);
        this.username.sendKeys(username);
        this.password.clear();
        Thread.sleep(3000);
        this.password.sendKeys(password);
        Thread.sleep(3000);
        login.click();
        Thread.sleep(3000);

    }
    public String validateMessage(){
        return BrowserUtils.getText(errorMessage);
    }
}










