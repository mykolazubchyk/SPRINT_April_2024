package fragments;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static common.CommonActions.getListOfString;

public class FilterFragment extends BasePage {

    public FilterFragment(WebDriver driver) {
        super(driver);
    }

    private static final String LOADING_SPINNER = "//div[@class='activity-indicator']";
    private static final String CATEGORY = "//div[@class='filter-options']//span[normalize-space(text())='%s']";
    private static final String PRODUCT_TYPE = "//span[normalize-space(text())='%s']";
    private static final String SIZE = "//button[normalize-space(text())='%s']";
    private static final String SIZE_FIT_DROPDOWN_CONTENT = "//div[@class='product-content-form-size-step-content product-content-form-step-content step-content']";
    private static final String LIST_OF_ITEM_SIZES = "//span[@class='primary-label']";  //"//*[starts-with(@class,'dropdown-item ')]";

    public void chooseCategory(String category) {
        waitClickabilityOfElement(String.format(CATEGORY,category)).click();
    }

    public void chooseProductType(String productType) {
        waitClickabilityOfElement(String.format(PRODUCT_TYPE,productType)).click();
    }

    public WebElement getSize(String size) {
        return waitClickabilityOfElement(String.format(SIZE, size));
    }

    public void waitUntilSpinnerDisappear() {
        waitVisibilityOfElement(LOADING_SPINNER);
        waitUntilElementDisappear(LOADING_SPINNER);
    }

    public void getCustomSizeDropdownButton() {
        waitClickabilityOfElement(SIZE_FIT_DROPDOWN_CONTENT).click();
    }

    public List<String> getListOfAllItemSizes() {
        return getListOfString(waitPresenceOfElements(LIST_OF_ITEM_SIZES));
    }
}

