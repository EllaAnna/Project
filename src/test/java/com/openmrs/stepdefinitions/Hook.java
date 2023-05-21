package com.openmrs.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class Hook {

    WebDriver driver;
   @Before
    public void setup(){
        driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("QA_url"));
       //WebDriver driver = new ChromeDriver();
       driver.manage().deleteAllCookies();
    }



   @After
    public void tearDown(Scenario scenario){
        BrowserUtils.getScreenShotForCucumber(driver,scenario);
        //driver.quit();
    }
}


