package fragments;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderFragment extends BasePage {

    private static final String SIGN_IN = "//div[contains(@class,'cart-container')]//a[@data-open='utilityNavModal7']";
    private static final String COOKIES_ACCEPTED = id("onetrust-accept-btn-handler");
    private static final String GIFT_CARDS_BUTTON = "//*[@class='topnav-utility-medium']//span[contains(text(),'Cards')]";
    private static final String SEARCH_FIELD = "//*[@name='searchTerm']";
    private static final String CLEAR_BUTTON_SEARCH_FIELD = "//*[@ class='topnav-clear-input']";
    private static final String CATEGORY_DROPDOWN = "//a[normalize-space(text())='%s']";

    public HeaderFragment(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        waitClickabilityOfElement(COOKIES_ACCEPTED).click();
    }

    public void clickSignIn() {
        waitClickabilityOfElement(SIGN_IN).click();
    }

    public WebElement getSearchField() {
        return waitVisibilityOfElement(SEARCH_FIELD);
    }

    public WebElement getClearSearchFieldButton() {
        return waitPresenceOfElement(CLEAR_BUTTON_SEARCH_FIELD);
    }

    public WebElement getToGiftCardsButton() {
        return waitClickabilityOfElement(GIFT_CARDS_BUTTON);
    }

    public void chooseCategoryDropdown(String category) {
        waitClickabilityOfElement(String.format(CATEGORY_DROPDOWN, category)).click();
    }
}