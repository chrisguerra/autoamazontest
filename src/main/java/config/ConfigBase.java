package config;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class ConfigBase {
    private static WebDriver driver;
    protected static String driverPath = "./drivers/";

    public static WebDriver getDriver(){
        return driver;
    }

    public void setDriver(String browserType, String appUrl){
        if (browserType == "chrome"){
            driver = initChromeDriver(appUrl);
        }else if (browserType == "firefox"){
            driver = initFireFoxDriver(appUrl);
        } else {
            System.out.println("Please, verify the testng.xml file on browserType XML tag.");
        }
    }

    private WebDriver initFireFoxDriver(String appUrl) {
        System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appUrl);
        return driver;
    }

    private WebDriver initChromeDriver(String appUrl) {
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appUrl);
        return driver;
    }

    //@Parameters({"browserType", "appUrl"})
    @BeforeSuite
    public void beginConfig(){
        try{
            setDriver("chrome", "https://www.amazon.com");
            driver = this.getDriver();
        } catch (Exception e){
            System.out.println("Error to start the driver : " + e.getStackTrace());
        }
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

}
