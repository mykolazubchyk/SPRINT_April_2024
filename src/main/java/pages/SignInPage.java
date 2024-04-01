package pages;

import fragments.HeaderFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends HeaderFragment {

    private static final String EMAIL_FIELD = "//input[contains(@class,'myaccount-signin-email')]";
    private static final String PASSWORD_FIELD = "//input[contains(@class,'signin-password-input')]";
    private static final String SUBMIT_BUTTON = "//button[@id='buttonsignin']";
    private static final String ERROR_MESSAGE = "//div[@id='logonId-error']";
    public SignInPage(WebDriver driver) {super(driver);}


    public void enterInvalidCredentials(String email, String password) {
        waitVisibilityOfElement(EMAIL_FIELD).sendKeys(email);
        waitVisibilityOfElement(PASSWORD_FIELD).sendKeys(password);
    }

    public void clickSubmit() {
        waitVisibilityOfElement(SUBMIT_BUTTON).click();
    }

    public String getErrorMessage() {
        return waitVisibilityOfElement(ERROR_MESSAGE).getText();
    }
}
