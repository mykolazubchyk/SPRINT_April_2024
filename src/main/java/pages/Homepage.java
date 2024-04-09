package pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage extends BasePage {

    private static final String FIRST_EVENT_BANNER = "//div[@class='card-w secondary-sale'][1]";
    private static final String SECOND_EVENT_BANNER = "//div[@class='card-w secondary-sale'][2]";
    private static final String THIRD_EVENT_BANNER = "//div[@class='button-w single-button']";

    public Homepage(WebDriver driver) {
        super(driver);
    }

    public WebElement getEventBannerOneElement() {
        return waitVisibilityOfElement(FIRST_EVENT_BANNER);
    }

    public void firstEventBannerGet() {
        waitClickabilityOfElement(FIRST_EVENT_BANNER).click();
    }

    public void secondEventBannerGet() {
        waitClickabilityOfElement(SECOND_EVENT_BANNER).click();
    }

    public void thirdEventBannerGet() {
        waitClickabilityOfElement(THIRD_EVENT_BANNER).click();
    }
}