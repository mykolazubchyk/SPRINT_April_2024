package fragments;

import common.BasePage;
import org.openqa.selenium.WebDriver;

public class FilterFragment extends BasePage {

    public FilterFragment(WebDriver driver) {
        super(driver);
    }

    private static final String SHOES_CATEGORY = "//div[@class='filter-options']//span[normalize-space(text())='Shoes']";

    public void chooseShoesCategory() {
        waitClickabilityOfElement(SHOES_CATEGORY).click();
    }
}
