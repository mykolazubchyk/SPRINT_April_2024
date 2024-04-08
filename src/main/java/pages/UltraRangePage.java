package pages;

import fragments.HeaderFragment;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static common.CommonActions.*;

public class UltraRangePage extends HeaderFragment {

    private static final String ULTRARANGE_PAGE_TITLE = "//div[@class='category-title-and-description']//h1";
    private static final String ULTRARANGE_PRODUCTS = "//span[@class='product-block-name-wrapper']";
    public UltraRangePage(WebDriver driver) {
        super(driver);
    }

    public String getUltraRangePageTitleText() {
        return waitVisibilityOfElement(ULTRARANGE_PAGE_TITLE).getText();
    }

    public List<String> getUltraRangeProducts() {
        return getListOfString(waitPresenceOfElements(ULTRARANGE_PRODUCTS));
    }
}