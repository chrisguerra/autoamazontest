package pages;

import config.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Department {
    protected WebDriver driver;
    private Common common = new Common(driver);

    public Department(WebDriver driver){
        this.driver = driver;
    }

    private By bestSellerLink = By.xpath("//span[contains(text(),'Best Sellers')]");

    public void goTobestSellerPage(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement bestSellerElement = driver.findElement(bestSellerLink);
        common.clickInTheElement(bestSellerElement);
    }


}
