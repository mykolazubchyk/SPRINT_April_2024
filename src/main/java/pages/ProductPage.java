package pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_IMAGE = "//*[@class='product-template-container section-1']";
    private static final String PRODUCT_NAME = "//*[@class='product-info-js']";       //id("product-info-container");
    private static final String PRODUCT_CONTENT = id("product-content-container");

    public WebElement getProductImage() {
        return waitVisibilityOfElement(PRODUCT_IMAGE);
    }

    public WebElement getProductName() {
        return waitVisibilityOfElement(PRODUCT_NAME);
    }

    public WebElement getProductContent() {
        return waitVisibilityOfElement(PRODUCT_CONTENT);
    }
}
