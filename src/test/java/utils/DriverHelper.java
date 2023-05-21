package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverHelper {

    private static WebDriver driver;
    private DriverHelper(){
        //I make my constructor private because I do not want anyone
        // to create an object and manipulate my driver from this class.
        // no one can be able tach my stuff - they can call it only.
    }
    public static WebDriver getDriver(){ // SINGLE PATERN DESIGN
        if (driver==null || ((RemoteWebDriver)driver).getSessionId()==null){ // "||" means OR

            switch (ConfigReader.readProperty("QA_browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();

                    driver = new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options1 = new ChromeOptions();
                    options1.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options1);
                    break;
            }
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }
        return driver;
    }
}

