package pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrivacyPolicyPage extends BasePage {
    public PrivacyPolicyPage(WebDriver driver) {
        super(driver);
    }

    private static final String TITLE = "//main/h1";

    public WebElement getTitle() {
        return waitVisibilityOfElement(TITLE);
    }
}
