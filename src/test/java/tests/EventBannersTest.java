package tests;

import io.qameta.allure.Issue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.productPages.BmxCollectionPage;
import pages.productPages.TheAvePage;
import pages.productPages.UltraRangePage;

import java.util.List;

import static common.CommonActions.goToPreviousPage;
import static common.CommonActions.scrollToElement;

public class EventBannersTest extends BaseTest {

    public static Homepage homepage;
    public static UltraRangePage ultraRangePage;
    public static BmxCollectionPage bmxCollectionPage;
    public static TheAvePage theAvePage;

    @BeforeMethod
    public void initTest() {
        homepage = new Homepage(driver);
        ultraRangePage = new UltraRangePage(driver);
        theAvePage = new TheAvePage(driver);
        bmxCollectionPage = new BmxCollectionPage(driver);
    }

    @Issue("SPRIN-124")
    @Test(description = "Transfer to event banners and checking their content")
    public void eventBannersContent() {
        scrollToElement(driver, homepage.getEventBannerOneElement());
        homepage.getFirstEventBanner().click();

        String ultraRangeTitleText = ultraRangePage.getProductHeaderFragment().getProductTitleText();
        List<String> ultraRangeProducts = ultraRangePage.getItemCatalogFragment().getListOfAllItemsName();

        softAssert.assertTrue(ultraRangeTitleText.contains("ULTRARANGE"), "The expected title is different from the actual one");

        convertToLowerCase(ultraRangeProducts);

        for (String product : ultraRangeProducts) {
            softAssert.assertTrue(product.contains("ultrarange"), "Product does not contain 'ultrarange': " + product);
        }

        goToPreviousPage(driver);
        homepage.getSecondEventBanner().click();

        String theAveTitleText = theAvePage.getProductHeaderFragment().getProductTitleText();
        List<String> theAveProducts = theAvePage.getItemCatalogFragment().getListOfAllItemsName();

        softAssert.assertTrue(theAveTitleText.contains("AVE 2.0"), "The expected title is different from the actual one");

        convertToLowerCase(theAveProducts);

        for (String product : theAveProducts) {
            softAssert.assertTrue(product.contains("ave"), "Product does not contain 'ave': " + product);
        }

        goToPreviousPage(driver);
        homepage.getThirdEventBanner().click();

        String bmxCollectionTitleText = bmxCollectionPage.getProductHeaderFragment().getProductTitleText();
        List<String> bmxCollectionProducts = bmxCollectionPage.getItemCatalogFragment().getListOfAllItemsName();

        softAssert.assertTrue(bmxCollectionTitleText.contains("VANS BMX COLLECTION"), "The expected title is different from the actual one");

        convertToLowerCase(bmxCollectionProducts);

        for (String product : bmxCollectionProducts) {
            softAssert.assertTrue(product.contains("bmx") || product.contains("lewis"), "Product does not contain 'bmx': " + product);
        }
    }

    public static void convertToLowerCase(List<String> products) {
        for (int i = 0; i < products.size(); i++) {
            String product = products.get(i);
            products.set(i, product.toLowerCase());
        }
    }
}