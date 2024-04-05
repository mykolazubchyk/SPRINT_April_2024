package tests;


import fragments.HeaderFragment;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.GiftCardsPage;

import java.util.List;

public class GiftCardsAccordingFaqTest extends BaseTest {

    private static GiftCardsPage giftCardsPage;
    private static HeaderFragment headerFragment;
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    private void initTest() {
        giftCardsPage = new GiftCardsPage(driver);
        headerFragment = new HeaderFragment(driver);
    }

    @Test(description = "SPRIN-79: Accordion FAQ Gift Cards page")
    public void testGiftCardsAccordingFaq() {
        headerFragment.getToGiftCardsButton().click();

        softAssert.assertTrue(giftCardsPage.getFrequentlyAskedQuestionsElement().isDisplayed(),
                "FAQ section is not displayed on the page");

        List<WebElement> faqPanels = giftCardsPage.getGiftCardsFaqPanels();
        List<WebElement> faqExtendedContents = giftCardsPage.getGiftCardsFaqExtendedContents();

        for (WebElement content : faqExtendedContents) {
            softAssert.assertFalse(content.isDisplayed(), "FAQ panels are not collapsed");
        }
        for (int i = 0; i < faqPanels.size(); i++) {
            WebElement panel = faqPanels.get(i);
            softAssert.assertFalse(panel.getText().isEmpty(), "FAQ panel is empty");

            giftCardsPage.scrollToSpecificGiftCardFaqPanel(i);
            panel.click();
            WebElement content = faqExtendedContents.get(i);

            softAssert.assertTrue(content.isDisplayed() && content.getText().length() >= 3,
                    "Content of the question is too short or not displayed");
        }
    }
}