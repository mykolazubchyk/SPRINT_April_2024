package tests;

import fragments.HeaderFragment;
import io.qameta.allure.Issue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.OldMeetsKnuPage;
import pages.TheAvePage;
import pages.UltraRangePage;

import java.util.List;

import static common.CommonActions.goToPreviousPage;
import static common.CommonActions.scrollToElement;

public class EventBannersTest extends BaseTest {

    public static Homepage homepage;
    public static HeaderFragment headerFragment;
    public static UltraRangePage ultraRangePage;
    public static OldMeetsKnuPage oldMeetsKnuPage;
    public static TheAvePage theAvePage;

    @BeforeMethod
    public void beforeTest() {
        homepage = new Homepage(driver);
        headerFragment = new HeaderFragment(driver);
        ultraRangePage = new UltraRangePage(driver);
        oldMeetsKnuPage = new OldMeetsKnuPage(driver);
        theAvePage = new TheAvePage(driver);
    }

    @Issue("SPRIN-124")
    @Test(description = "Transfer to event banners and checking their content")
    public void eventBannersContent() {
        scrollToElement(driver, homepage.getEventBannerOneElement());
        homepage.firstEventBannerGet();

        String ultraRangeTitleText = ultraRangePage.getUltraRangePageTitleText();
        List<String> ultraRangeProducts = ultraRangePage.getUltraRangeProducts();

        softAssert.assertTrue(ultraRangeTitleText.contains("ULTRARANGE"),"The expected title is different from the actual one");

        for (String product : ultraRangeProducts) {
            softAssert.assertTrue(product.contains("UltraRange"), "Product does not contain 'UltraRange': " + product);
        }

        goToPreviousPage(driver);
        homepage.secondEventBannerGet();

        String oldMeetsKnuTitleText = oldMeetsKnuPage.getOldMeetsKnuPageTitleText();
        List<String> oldMeetsKnuProducts = oldMeetsKnuPage.getOldMeetsKnuProducts();

        softAssert.assertTrue(oldMeetsKnuTitleText.contains("OLD MEETS KNU"), "The expected title is different from the actual one");

        for (String product : oldMeetsKnuProducts) {
            softAssert.assertTrue(product.contains("Knu") || product.contains("Skool"), "Product does not contain 'Knu' or 'Skool': " + product);
        }

        goToPreviousPage(driver);
        homepage.thirdEventBannerGet();

        String theAveTitleText = theAvePage.getTheAvePageTitleText();
        List<String> theAveProducts = theAvePage.getTheAveProducts();

        softAssert.assertTrue(theAveTitleText.contains("AVE 2.0"), "The expected title is different from the actual one");

        for (String product : theAveProducts) {
            softAssert.assertTrue(product.contains("Ave"), "Product does not contain 'Ave': " + product);
        }
    }
}