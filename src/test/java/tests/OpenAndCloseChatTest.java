package tests;

import fragments.FooterFragment;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static common.CommonActions.scrollToElement;

public class OpenAndCloseChatTest extends BaseTest {
    private static FooterFragment footerFragment;

    @BeforeMethod
    public void initTest() {
        footerFragment = new FooterFragment(driver);
    }

    @Test(description = "Sprint_113_Open_And_Close_Chat")
    public void openAndCloseButtonsInChat() {
        scrollToElement(driver, footerFragment.getFollowUsSection());

    }
}
