package fragments;

import common.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HeaderFragment extends BasePage {

    private static final String SIGN_IN = "//div[contains(@class,'cart-container')]//a[@data-open='utilityNavModal7']";
    private static final String COOKIES_ACCEPTED = id("onetrust-accept-btn-handler");

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
}
