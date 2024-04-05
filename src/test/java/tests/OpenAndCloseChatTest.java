package tests;

import common.BasePage;
import org.testng.annotations.Test;
import pages.Homepage;

import static common.BasePage.driver;

@Test
public class OpenAndCloseChatTest extends BaseTest{


        Homepage homepage = new Homepage(driver);
        homepage.clickOnVansPremiumButton();
        .clickOnChatButton();
        .clickOnCloseChatButton();

}
