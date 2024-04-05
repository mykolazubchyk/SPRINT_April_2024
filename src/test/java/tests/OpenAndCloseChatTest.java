package tests;

import org.testng.annotations.Test;
import pages.Homepage;

@Test
public class OpenAndCloseChatTest extends BaseTest {
    public void clickOnVansPremiumButton() {
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
