package fragments;

import common.BasePage;
import org.openqa.selenium.WebDriver;

public class FilterFragment extends BasePage {

    public FilterFragment(WebDriver driver) {
        super(driver);
    }

    private static final String CATEGORY = "//div[@class='filter-options']//span[normalize-space(text())='%s']";
    private static final String PRODUCT_TYPE = "//span[normalize-space(text())='%s']";

    public void chooseCategory(String category) {
        waitClickabilityOfElement(String.format(CATEGORY,category)).click();
    }

    public void chooseProductType(String productType) {
        waitClickabilityOfElement(String.format(PRODUCT_TYPE,productType)).click();
    }
}

