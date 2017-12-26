package config;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {
    protected WebDriver driver;

    public Common(WebDriver driver){
        this.driver = driver;
    }

    public void mouseOver(WebElement element, Actions action){
        action.moveToElement(element).build().perform();
    }

    public void toBeVisiable(WebElement element, WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void toBeSelected(WebElement element, WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public void toBeClickable(WebElement element, WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickInTheElement(WebElement element){
        element.click();
    }

    public String getElementText(WebElement element){
        return element.getText();
    }
}
