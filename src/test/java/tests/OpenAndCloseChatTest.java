package tests;

import fragments.HeaderFragment;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import fragments.ChatFragment;

public class OpenAndCloseChatTest extends BaseTest {
    private static ChatFragment vansPremiumPage;
    private static HeaderFragment headerFragment;

    @BeforeMethod
    public void initTest() {
        headerFragment = new HeaderFragment(driver);
        vansPremiumPage = new ChatFragment(driver);
    }

    @Test(description = "Sprint_113_Open_And_Close_Chat")
    public void openAndCloseButtonsInChat() {
        headerFragment.getToGiftCardsButton().click();
        vansPremiumPage.clickOnChatButton().click();

        softAssert.assertTrue(vansPremiumPage.isChatOpened());

        vansPremiumPage.clickOnCloseChatButton().click();

        softAssert.assertTrue(vansPremiumPage.isChatClosed());
    }
}
