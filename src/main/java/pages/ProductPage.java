package pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static common.CommonActions.getListOfString;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_IMAGE = "//*[@class='product-template-container section-1']";
    private static final String PRODUCT_NAME = "//*[@class='product-info-js']";
    private static final String PRODUCT_CONTENT = id("product-content-container");
    private static final String SIZE_FIT_DROPDOWN_CONTENT = "//div[contains(@class,'product-content-form-size-step-c')]";
    private static final String LIST_OF_ITEM_SIZES = "//span[@class='primary-label']";

    public WebElement getProductImage() {
        return waitVisibilityOfElement(PRODUCT_IMAGE);
    }

    public WebElement getProductName() {
        return waitVisibilityOfElement(PRODUCT_NAME);
    }

    public WebElement getProductContent() {
        return waitVisibilityOfElement(PRODUCT_CONTENT);
    }

    public WebElement getCustomSizeDropdownButton() {
        return waitClickabilityOfElement(SIZE_FIT_DROPDOWN_CONTENT);
    }

    public List<String> getListOfAllItemSizes() {
        return getListOfString(waitPresenceOfElements(LIST_OF_ITEM_SIZES));
    }
}
