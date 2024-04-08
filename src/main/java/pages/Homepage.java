package pages;

import fragments.HeaderFragment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage extends HeaderFragment {

    private static final String EVENT_BANNER_ONE = "//div[@class='card-w secondary-sale'][1]";
    private static final String EVENT_BANNER_TWO = "//div[@class='card-w secondary-sale'][2]";
    private static final String EVENT_BANNER_THREE = "//div[@class='button-w single-button']";

    public Homepage(WebDriver driver) {
        super(driver);
    }

    public WebElement getEventBannerOneElement() {
        return waitVisibilityOfElement(EVENT_BANNER_ONE);
    }

    public void eventBannerOneClick() {
        waitClickabilityOfElement(EVENT_BANNER_ONE).click();
    }

    public void eventBannerTwoClick() {
        waitClickabilityOfElement(EVENT_BANNER_TWO).click();
    }

    public void eventBannerThreeClick() {
        waitClickabilityOfElement(EVENT_BANNER_THREE).click();
    }
}