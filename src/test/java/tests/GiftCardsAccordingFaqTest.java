package tests;

import common.CommonActions;
import fragments.FAQFragment;
import fragments.HeaderFragment;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GiftCardsAccordingFaqTest extends BaseTest {


    @Test(description = "Accordion FAQ Gift Cards page")
    @Description("SPRIN-79")

    public void testGiftCardsAccordingFaq() {
        HeaderFragment headerFragment = new HeaderFragment(driver);
        FAQFragment faqFragment = new FAQFragment(driver);

        headerFragment.acceptCookies();
        headerFragment.clickGiftCards();
        CommonActions.scrollToElement(driver, faqFragment.getFrequentlyAskedQuestionsElement());

        List<WebElement> faqFragments = faqFragment.getFAQFragments();

        if (!faqFragments.isEmpty()) {
            for (WebElement question : faqFragments) {
                question.click();

                Assert.assertFalse(question.getText().isEmpty(), "Content of the question is not displayed");

            }
        }
    }
}