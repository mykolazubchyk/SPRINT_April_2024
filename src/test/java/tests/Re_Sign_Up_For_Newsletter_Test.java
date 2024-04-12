package tests;

import fragments.FooterFragment;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static credentials.Data.EMAIL_FOR_RE_SIGN_UP;

public class Re_Sign_Up_For_Newsletter_Test extends BaseTest{
    private static FooterFragment footerFragment;
    private static final String GET_ERROR_MESSAGE = "This email address already receives our newsletters";

    @BeforeMethod
    public void InitTest(){
        footerFragment = new FooterFragment(driver);
    }

    @Test(description = "SPRIN-8_Re_Sign_Up_For_Newsletter")
    public void ReSignUpForNewsletter(){
        footerFragment.enterExistedEmail(EMAIL_FOR_RE_SIGN_UP);
        footerFragment.acceptPrivacyPolicy();
        footerFragment.submitForNewsletters();
        String getErrorMessage = footerFragment.getMessageError();
        softAssert.assertEquals(getErrorMessage,GET_ERROR_MESSAGE,"This email address already receives our newsletters");
    }
}
