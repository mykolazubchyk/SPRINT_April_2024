package fragments;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static credentials.Data.EMAIL_FOR_RE_SIGN_UP;

public class FooterFragment extends BasePage {

    private static final String SIGN_UP_FIELD = id("newsletterInputField");
    private static final String SUBMIT_BUTTON = id("newsletterSubmitCTA");
    private static final String ERROR_MESSAGE = id("signupForm-response");
    private static final String SIGN_UP_CONTAINER= id("footerRow1ContentContainer");
    private static final String TITLE = SIGN_UP_CONTAINER + "//h4";
    private static final String SING_UP_RECOMMENDATION = SIGN_UP_CONTAINER + "//div/p";
    private static final String ACCEPT_PRIVACY_POLICY_CHECKBOX = id("newsletterCheckField");
    private static final String PRIVACY_POLICY_TEXT = "//*[@class='text-wrapper']";
    private static final String PRIVACY_POLICY_LINK = PRIVACY_POLICY_TEXT + "/a";
    private static final String EMAIL_FIELD =id("newsletterInputField");
    private static final String ACCEPT_PRIVACY_POLICY = id ("newsletterCheckField");
    private static final String  CLICK_ENTER = "//a[@id='newsletterSubmitCTA']";
    private static final String GET_ERROR_MESSAGE = "//p[@class='error']";

    public FooterFragment(WebDriver driver) {
        super(driver);
    }

    public WebElement getErrorMessage() {
        return waitVisibilityOfElement(ERROR_MESSAGE);
    }

    public void enterEmailToSignUp(String email) {
        waitClickabilityOfElement(SIGN_UP_FIELD).sendKeys(email);
    }

    public void clickSubmit() {
        waitClickabilityOfElement(SUBMIT_BUTTON).click();
    }

    public WebElement getTitle() {
        return waitVisibilityOfElement(TITLE);
    }

    public WebElement getSignUpRecommendation() {
        return waitVisibilityOfElement(SING_UP_RECOMMENDATION);
    }

    public WebElement getAcceptPrivacyPolicyCheckbox() {
        return waitVisibilityOfElement(ACCEPT_PRIVACY_POLICY_CHECKBOX);
    }

    public WebElement getAcceptPrivacyPolicyText() {
        return waitVisibilityOfElement(PRIVACY_POLICY_TEXT);
    }

    public WebElement getPrivacyPolicyLink() {
        return waitVisibilityOfElement(PRIVACY_POLICY_LINK);
    }
    public void enterExistedEmail(String email) {
        waitClickabilityOfElement(EMAIL_FIELD).sendKeys(email);
    }
    public void acceptPrivacyPolicy(){
        waitClickabilityOfElement(ACCEPT_PRIVACY_POLICY).click();
    }
    public void submitForNewsletters(){
        waitClickabilityOfElement(CLICK_ENTER).click();
    }
    public String getMessageError() {
       return waitVisibilityOfElement(GET_ERROR_MESSAGE).getText();
    }
}


