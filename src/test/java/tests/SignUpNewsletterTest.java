package tests;

import fragments.FooterFragment;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.PrivacyPolicyPage;

public class SignUpNewsletterTest extends BaseTest {

    private static final String EMAIL = "sadsad@gmail.com";
    private static final String EXPECTED_ERROR_MESSAGE = "Please acccept the Privacy Policy";
    private static final String PRIVACY_POLICY_MESSAGE_TEXT = "I acknowledge I have read and understood Privacy Policy and I consent to the processing of my personal data for marketing and profiling purposes.";

    private static FooterFragment footerFragment;
    private static PrivacyPolicyPage privacyPolicyPage;

    SoftAssert softAssert = new SoftAssert();
    @BeforeMethod
    private void initTest() {
        footerFragment = new FooterFragment(driver);
        privacyPolicyPage = new PrivacyPolicyPage(driver);
    }

    @Test(description = "SPRIN-9: Sign up for newsletter, privacy policy is not accepted")
    public void testSignUpNewsletterWithoutPrivacyPolicy() {

        footerFragment.enterEmailToSignUp(EMAIL);
        footerFragment.clickSubmit();

        softAssert.assertEquals(footerFragment.getErrorMessage().getText(), EXPECTED_ERROR_MESSAGE,
                "The expected error message is not displayed.");

        softAssert.assertTrue(footerFragment.getTitle().isDisplayed());
        softAssert.assertTrue(footerFragment.getSignUpRecommendation().isDisplayed());
        softAssert.assertTrue(footerFragment.getAcceptPrivacyPolicyCheckbox().isDisplayed());
        softAssert.assertEquals(footerFragment.getAcceptPrivacyPolicyText().getText(), PRIVACY_POLICY_MESSAGE_TEXT);

        String PrivacyPolicyText = footerFragment.getPrivacyPolicyLink().getText();
        footerFragment.getPrivacyPolicyLink().click();

        softAssert.assertEquals(privacyPolicyPage.getTitle().getText(), PrivacyPolicyText);
    }
}