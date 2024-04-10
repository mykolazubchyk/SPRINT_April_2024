package tests;

import fragments.HeaderFragment;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GiftCardsPage;

public class GiftCardsFunctionalityTest extends BaseTest {
    private static GiftCardsPage giftCardsPage;
    private static HeaderFragment headerFragment;

    @BeforeMethod
    private void initTest() {
        giftCardsPage = new GiftCardsPage(driver);
        headerFragment = new HeaderFragment(driver);
    }

    @Test(description = "SPRIN-60: Functionality Gift Cards page")
    public void testGiftCardsFunctionality() {
        headerFragment.getToGiftCardsButton().click();
        softAssert.assertEquals(driver.getCurrentUrl(), giftCardsPage.getGiftCardUrl(),
                "The user was not redirected to the gift cards page");

        giftCardsPage.getToBuyGiftCardsButton().click();
        softAssert.assertEquals(driver.getCurrentUrl(), giftCardsPage.getBuyGiftCardsUrl(),
                "The website was not redirects to the appropriate page");

        driver.navigate().back();
        softAssert.assertEquals(driver.getCurrentUrl(), giftCardsPage.getGiftCardUrl(),
                "The user was not redirected back to the gift cards page");

        giftCardsPage.getToCheckBalanceButton().click();
        softAssert.assertTrue(giftCardsPage.getGiftCardNumberInput().isDisplayed());
    }
}
