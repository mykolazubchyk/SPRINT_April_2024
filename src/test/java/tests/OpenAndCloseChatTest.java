package tests;

import fragments.FooterFragment;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Homepage;
public class OpenAndCloseChatTest extends BaseTest {

@Test

    public void OpenAndCloseChat() {
        Homepage homepage = new Homepage(driver);
        homepage.clickOnAllowAll();
        homepage.clickOnVansPremiumButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homepage.clickOnChatButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homepage.clickOnCloseChatButton();
    }
}
