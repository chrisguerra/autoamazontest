package pages;

import config.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart {
    protected WebDriver driver;
    protected Actions action;
    private Common common = new Common(driver);
    private String finalProductName = "";
    private String productValue = "";

    private By productPrice = By.xpath("//div[@class='a-row a-spacing-micro']//span[@class='a-color-price hlb-price a-inline-block a-text-bold']");
    private By productImage = By.xpath("//img[@class='huc-no-radius huc-v2-order-row-image huc-v2-table-col']");
    private By productName = By.xpath("//span[contains(@class, 'sc-product-title')]");

    public Cart(WebDriver driver){
        this.driver = driver;
        this.action = new Actions(driver);
    }

    public void clickOnProductImage(){
        WebElement productImageElement = driver.findElement(productImage);
        common.mouseOver(productImageElement, action);
    }

    public String getProductName() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        this.clickOnProductImage();
        Thread.sleep(2000);
        WebElement productNameElement = driver.findElement(productName);
        common.toBeVisiable(productNameElement, wait);
        finalProductName = common.getElementText(productNameElement);
        return finalProductName;
    }

    public String getProductPrice() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement productPriceElement = driver.findElement(productPrice);
        common.toBeVisiable(productPriceElement, wait);
        productValue = common.getElementText(productPriceElement);
        return productValue;
    }
}
