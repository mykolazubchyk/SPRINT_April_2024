package tests;

import fragments.FooterFragment;
import fragments.HeaderFragment;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpNewsletterTest extends BaseTest {

    private static final String EMAIL = "sadsad@gmail.com";
    private static final String EXPECTED_ERROR_MESSAGE = "Please acccept the Privacy Policy";

    @Test(description = "SPRIN-9 Sign up for newsletter, privacy policy is not accepted")
    public void testSignUpNewsletterWithoutPrivacyPolicy() {
        HeaderFragment headerFragment = new HeaderFragment(driver);
        FooterFragment footerFragment = new FooterFragment(driver);

        headerFragment.acceptCookies();
        footerFragment.enterEmailToSignUp(EMAIL);
        footerFragment.clickSubmit();

        String errorMessage = footerFragment.getErrorMessage();

        Assert.assertEquals(errorMessage, EXPECTED_ERROR_MESSAGE, "The expected error message is not displayed.");
    }
}
