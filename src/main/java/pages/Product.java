package pages;

import config.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product {
    protected WebDriver driver;
    private Common common = new Common(driver);
    private String qtyOfProduct = "";

    private By productQty = By.id("quantity");
    private By addCartButton = By.id("add-to-cart-button");
    private By productName = By.id("productTitle");
    private By productPrice = By.xpath("//td[contains(text(), 'Price:')]//following-sibling::td//span[@class='a-size-medium a-color-price']");
    private By addCoverageAnnounce = By.id("siAddCoverage-announce");
    private By noCoverageAnnounce = By.id("siNoCoverage-announce");
    private By coverageAnnounceValue = By.xpath("//span[@class='a-size-large a-color-price']");

    public Product(WebDriver driver){
        this.driver = driver;
    }

    public int setQtyOfProduct(int qty){
        Select productQtyElement =  new Select(driver.findElement(productQty));
        if (productQtyElement.getOptions().size() < qty) {
            qty = productQtyElement.getOptions().size();
            productQtyElement.selectByValue(String.format("%d", productQtyElement.getOptions().size()));
        } else {
            productQtyElement.selectByValue(String.format("%d", qty));
        }
        return qty;
    }

    public void addToCartClick(boolean hasCoverage) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement addCartButtonElement = driver.findElement(addCartButton);
        common.toBeClickable(addCartButtonElement, wait);
        common.clickInTheElement(addCartButtonElement);
        Thread.sleep(2000);
        if (driver.findElements(addCoverageAnnounce).size() != 0){
            addCoveragePopOver(hasCoverage);
        }
    }

    private void addCoveragePopOver(boolean add) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement addCoverageAnnounceElement = driver.findElement(addCoverageAnnounce);
        WebElement noCoverageAnnounceElement = driver.findElement(noCoverageAnnounce);
        if (add) {
            this.getCoverageValue();
            common.toBeClickable(addCoverageAnnounceElement, wait);
            common.clickInTheElement(addCoverageAnnounceElement);
        } else {
            common.toBeClickable(noCoverageAnnounceElement, wait);
            common.clickInTheElement(noCoverageAnnounceElement);
        }
    }

    public String getCoverageValue() {
        WebElement coverageAnnounceValueElement = driver.findElement(coverageAnnounceValue);
        return common.getElementText(coverageAnnounceValueElement);
    }

    public String getProductName(){
        WebElement productNameElement = driver.findElement(productName);
        return common.getElementText(productNameElement);
    }

    public String getProductValue(){
        WebElement productPriceElement = driver.findElement(productPrice);
        return common.getElementText(productPriceElement);
    }
}
