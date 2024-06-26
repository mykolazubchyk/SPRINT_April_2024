package fragments;

import common.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class SignInFragment extends BasePage {

    private static final String EMAIL_FIELD = "//input[contains(@class,'myaccount-signin-email')]";
    private static final String PASSWORD_FIELD = "//input[contains(@class,'signin-password-input')]";
    private static final String SUBMIT_BUTTON = id("buttonsignin");
    private static final String ERROR_MESSAGE = "//div[@id='logonId-error']";

    public SignInFragment(WebDriver driver) {
        super(driver);
    }

    @Step("Enter a credentials in sign in fields: {email}; {password}")
    public void enterCredentials(String email, String password) {
        waitClickabilityOfElement(EMAIL_FIELD).sendKeys(email);
        waitClickabilityOfElement(PASSWORD_FIELD).sendKeys(password);
    }

    public void clickSubmit() {
        waitClickabilityOfElement(SUBMIT_BUTTON).click();
    }

    public String getErrorMessage() {
        return waitVisibilityOfElement(ERROR_MESSAGE).getText();
    }
}
