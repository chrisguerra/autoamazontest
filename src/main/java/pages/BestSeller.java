package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BestSeller {
    protected WebDriver driver;
    private List<WebElement> elementsOut = new ArrayList();

    private By productsList = By.xpath("//div[@class='zg_itemImmersion']");

    public BestSeller(WebDriver driver){
        this.driver = driver;
    }
    
    public void goToEspecificProductById(int id){
        List<WebElement> productsListElement = driver.findElements(productsList);
        String realId = String.format ("%d", id);

        for (int i = 0; productsListElement.size() >= i; i++) {
            String aux = productsListElement.get(i).getText();
            if (aux.contains(realId + ".\n")) {
                productsListElement.get(i).click();
                break;
            } else {
                elementsOut.add(productsListElement.get(i));
            }
        }
        if (elementsOut.size() == productsListElement.size()){
            System.out.println("The index of this product does not exist!");
        }
    }
}
