package tests;

import fragments.HeaderFragment;
import org.testng.Assert;
import org.testng.annotations.Test;
import fragments.SignInFragment;
import org.testng.asserts.SoftAssert;

public class SignInValidationTest extends BaseTest {

    private static final String INVALID_EMAIL = "fgjhj";
    private static final String INVALID_PASSWORD = "46trdgdfg";
    private static final String EXPECTED_ERROR_MESSAGE = "Please enter a valid email address.";

    @Test
    public void testSignInWithInvalidCredentials() {
        HeaderFragment headerFragment = new HeaderFragment(driver);
        SignInFragment signInFragment = new SignInFragment(driver);

        headerFragment.clickSignIn();
        signInFragment.enterCredentials(INVALID_EMAIL, INVALID_PASSWORD);
        signInFragment.clickSubmit();

        String errorMessage = signInFragment.getErrorMessage();
        softAssert.assertEquals(errorMessage, EXPECTED_ERROR_MESSAGE, "The expected error message is not displayed.");
    }
}