package fragments;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FilterFragment extends BasePage {

    public FilterFragment(WebDriver driver) {
        super(driver);
    }

    static final String LOADING_SPINNER = "//div[@class='activity-indicator']";
    private static final String CATEGORY = "//div[@class='filter-options']//span[normalize-space(text())='%s']";
    private static final String PRODUCT_TYPE = "//span[normalize-space(text())='%s']";

    public void chooseCategory(String category) {
        waitClickabilityOfElement(String.format(CATEGORY,category)).click();
    }

    public void chooseProductType(String productType) {
        waitClickabilityOfElement(String.format(PRODUCT_TYPE,productType)).click();
    }

    protected void waitUntilElementInvisible(By locator) {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (WebDriverException e) {
            logger.warn("Element is still visible: " + locator);
        }
    }
    public void waitUntilSpinnerDisappear() {
        try {
            waitUntilElementInvisible(By.xpath(LOADING_SPINNER));
        } catch (Exception e) {
            System.out.println("Spinner is still visible");
        }
    }
}

