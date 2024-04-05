package fragments;

import common.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderFragment extends BasePage {

    private static final String SIGN_IN = "//div[contains(@class,'cart-container')]//a[@data-open='utilityNavModal7']";
    private static final String COOKIES_ACCEPTED = "//button[@id='onetrust-accept-btn-handler']";
    private static final String SEARCH_FIELD = "//*[@name='searchTerm']";
    private static final String CLEAR_BUTTON_SEARCH_FIELD = "//*[@ class='topnav-clear-input']";

    public HeaderFragment(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        try {
            waitClickabilityOfElement(COOKIES_ACCEPTED).click();
        } catch (NoSuchElementException e) {
        }
    }

    public void clickSignIn() {
        waitClickabilityOfElement(SIGN_IN).click();
    }

    public WebElement getSearchField() {
        return waitVisibilityOfElement(SEARCH_FIELD);
    }

    public WebElement getClearButtonSearchField() {
        return waitVisibilityOfElement(CLEAR_BUTTON_SEARCH_FIELD);
    }

    public boolean isButtonDisplayed() {
        return waitVisibilityOfElement(CLEAR_BUTTON_SEARCH_FIELD) !=null;
    }
}
