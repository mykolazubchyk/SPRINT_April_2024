package fragments;

import common.BasePage;
import org.openqa.selenium.WebDriver;

public class FooterFragment extends BasePage {

    private static final String SIGN_UP_FIELD = "//div/*[@id='newsletterInputField']";

    private static final String SUBMIT_BUTTON = "//div/a[@id='newsletterSubmitCTA']";

    private static final String ERROR_MESSAGE = "//p[@id='signupForm-response']";

    public FooterFragment(WebDriver driver) {
        super(driver);
    }

    public String getErrorMessage() {
        return waitVisibilityOfElement(ERROR_MESSAGE).getText();
    }

    public void enterEmailToSignUp(String email) {
        waitClickabilityOfElement(SIGN_UP_FIELD).sendKeys(email);
    }

    public void clickSubmit() {
        waitClickabilityOfElement(SUBMIT_BUTTON).click();
    }
}