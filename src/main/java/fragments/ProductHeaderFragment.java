package fragments;

import common.BasePage;
import org.openqa.selenium.WebDriver;

public class ProductHeaderFragment extends BasePage {

    private static final String PRODUCT_TITLE = "//div[@class='category-title-and-description']";

    public ProductHeaderFragment(WebDriver driver) {
        super(driver);
    }

    public String getProductTitleText() {
        return waitVisibilityOfElement(PRODUCT_TITLE).getText();
    }
}
