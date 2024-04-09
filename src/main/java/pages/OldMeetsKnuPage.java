package pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static common.CommonActions.getListOfString;

public class OldMeetsKnuPage extends BasePage {

    private static final String OLD_MEETS_KNU_PAGE_TITLE = "//div[@class='category-title-and-description']";
    private static final String OLD_MEETS_KNU_PRODUCTS = "//span[@class='product-block-name-wrapper']";

    public OldMeetsKnuPage(WebDriver driver) {
        super(driver);
    }

    public String getOldMeetsKnuPageTitleText() {
        return waitVisibilityOfElement(OLD_MEETS_KNU_PAGE_TITLE).getText();
    }

    public List<String> getOldMeetsKnuProducts() {
        return getListOfString(waitPresenceOfElements(OLD_MEETS_KNU_PRODUCTS));
    }
}
