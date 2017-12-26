package suite001;

import config.ConfigBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class TestCase001 extends ConfigBase {
    private WebDriver driver;

    private int productId = 5;
    private int qty = 8;
    private double valueTotal = 0.0;
    private double unitValue = 0.0;
    private String pValue = "";
    private String total = "";
    private String pBestSellerName = "";
    private String pname = "";

    @BeforeClass
    public void preConditions() throws InterruptedException {
        this.driver = ConfigBase.getDriver();
        Home homePage = new Home(driver);
        Department departmentPage = new Department(driver);
        BestSeller bestSellerPage = new BestSeller(driver);
        Product productPage = new Product(driver);
        Cart cartPage = new Cart(driver);
        homePage.goToCameraAndPhotoDep();
        departmentPage.goTobestSellerPage();
        bestSellerPage.goToEspecificProductById(productId);
        qty = productPage.setQtyOfProduct(qty);
        pBestSellerName = productPage.getProductName();
        pValue = productPage.getProductValue();
        productPage.addToCartClick(false);
        pname = cartPage.getProductName();
        total = cartPage.getProductPrice();
        convertStringIntoDouble(pValue, total);
    }

    private void convertStringIntoDouble(String pValue, String total) {
        pValue = pValue.replace("$", "");
        total = total.replace("$", "");
        unitValue = Double.parseDouble(pValue);
        valueTotal = Double.parseDouble(total);
    }

    @Test
    public void testCase001(){
        System.out.println("Testing to buy the 5th best seller camera on Amazon");
        Assert.assertEquals(pBestSellerName.substring(0,(pname.length()-3)),pname.substring(0,(pname.length()-3)));
        Assert.assertEquals(unitValue*qty, valueTotal);
    }
}
