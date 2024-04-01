package tests;

import common.BasePage;
import fragments.HeaderFragment;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignInPage;

import static java.lang.Thread.sleep;

public class InvalidSignIn extends BaseTest {

    @Test
    public void testSignInWithInvalidCredentials() {
        HeaderFragment headerFragment = new HeaderFragment(driver);
        SignInPage signInPage = new SignInPage(driver);

        headerFragment.acceptCookiesAndSignIn();
        headerFragment.clickSignIn();
        signInPage.enterInvalidCredentials("fgjhj", "46trdgdfg");
        signInPage.clickSubmit();

        String errorMessage = signInPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Please enter a valid email address.", "Повідомлення про помилку не відображається або не відображається правильно");
    }
}
