package pages;

import config.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
    protected WebDriver driver;
    protected Actions action;
    private Common common = new Common(driver);

    private By departmentsMenu = By.xpath("//span[contains(text(),'Departments')]");
    private By eletronicsDepartment = By.xpath("//span[@data-nav-panelkey='ElectronicsComputersPanel']");
    private By cameraPhotoVideoLink = By.xpath("//span[contains(text(),'Camera, Photo & Video')]");

    public Home(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
    }

    public void departmentsMouseOver(){
        WebElement departmentsMenuElement = driver.findElement(departmentsMenu);
        common.mouseOver(departmentsMenuElement, action);
    }

    public void eletronicDepartmentMouseOver(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement eletronicsDepartmentElement = driver.findElement(eletronicsDepartment);
        common.toBeClickable(eletronicsDepartmentElement,wait);
        common.mouseOver(eletronicsDepartmentElement, action);
    }

    public void goToCameraAndPhotoDep(){
        this.departmentsMouseOver();
        this.eletronicDepartmentMouseOver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement cameraPhotoVideoLinkElement = driver.findElement(cameraPhotoVideoLink);
        common.toBeClickable(cameraPhotoVideoLinkElement, wait);
        common.clickInTheElement(cameraPhotoVideoLinkElement);
    }
}
