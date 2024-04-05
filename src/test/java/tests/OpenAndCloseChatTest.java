package tests;

import common.BasePage;
import org.testng.annotations.Test;
import pages.Homepage;

@Test
public class OpenAndCloseChatTest extends BaseTest {

        public void clickOnVansPremiumButton() {
                Homepage homepage = new Homepage(driver);
                homepage.clickOnVansPremiumButton();
        homepage.clickOnChatButton();
        homepage.clickOnCloseChatButton();

        }
}
