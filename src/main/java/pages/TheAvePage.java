package pages;

import common.BasePage;
import fragments.HeaderFragment;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static common.CommonActions.getListOfString;

public class TheAvePage extends BasePage {

    private static final String THE_AVE_PAGE_TITLE = "//div[@class='category-title-and-description']";
    private static final String THE_AVE_PRODUCTS = "//span[@class='product-block-name-wrapper']";

    public TheAvePage(WebDriver driver) {
        super(driver);
    }

    public String getTheAvePageTitleText() {
        return waitVisibilityOfElement(THE_AVE_PAGE_TITLE).getText();
    }

    public List<String> getTheAveProducts() {
        return getListOfString(waitPresenceOfElements(THE_AVE_PRODUCTS));
    }
}
