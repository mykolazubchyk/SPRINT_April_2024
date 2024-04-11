package tests;

import io.qameta.allure.Issue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.productPages.BmxCollectionPage;
import pages.productPages.TheAvePage;
import pages.productPages.UltraRangePage;

import java.util.List;

import static common.CommonActions.*;

public class EventBannersTest extends BaseTest {

    private static Homepage homepage;
    private static UltraRangePage ultraRangePage;
    private static BmxCollectionPage bmxCollectionPage;
    private static TheAvePage theAvePage;

    @BeforeMethod
    public void initTest() {
        homepage = new Homepage(driver);
        ultraRangePage = new UltraRangePage(driver);
        theAvePage = new TheAvePage(driver);
        bmxCollectionPage = new BmxCollectionPage(driver);
    }

    @Issue("SPRIN-124")
    @Test(description = "SPRIN-19: Transfer to event banners and checking their content")
    public void testEventBannersContent() {
        scrollToElement(driver, homepage.getFirstEventBanner());

        softAssert.assertTrue(homepage.getFirstEventBanner().isDisplayed(), "The UltraRange banner is not displayed on the page.");
        softAssert.assertTrue(homepage.getSecondEventBanner().isDisplayed(), "The Ave 2.0 banner is not displayed on the page.");
        softAssert.assertTrue(homepage.getThirdEventBanner().isDisplayed(), "The BMX collection banner is not displayed on the page.");

        homepage.getFirstEventBanner().click();

        String titleText = ultraRangePage.getProductHeaderFragment().getProductTitleText();
        List<String> productList = ultraRangePage.getItemCatalogFragment().getListOfAllItemsName();

        softAssert.assertTrue(titleText.contains("ULTRARANGE"), "The expected title is different from the actual one");

        productList = convertListToLowerCase(productList);

        for (String product : productList) {
            softAssert.assertTrue(product.contains("ultrarange"), "Product does not contain 'ultrarange': " + product);
        }

        goToPreviousPage(driver);
        homepage.getSecondEventBanner().click();

        titleText = theAvePage.getProductHeaderFragment().getProductTitleText();
        productList = theAvePage.getItemCatalogFragment().getListOfAllItemsName();

        softAssert.assertTrue(titleText.contains("AVE 2.0"), "The expected title is different from the actual one");

        productList = convertListToLowerCase(productList);

        for (String product : productList) {
            softAssert.assertTrue(product.contains("ave"), "Product does not contain 'ave': " + product);
        }

        goToPreviousPage(driver);
        homepage.getThirdEventBanner().click();

        titleText = bmxCollectionPage.getProductHeaderFragment().getProductTitleText();
        productList = bmxCollectionPage.getItemCatalogFragment().getListOfAllItemsName();

        softAssert.assertTrue(titleText.contains("VANS BMX COLLECTION"), "The expected title is different from the actual one");

        productList = convertListToLowerCase(productList);

        for (String product : productList) {
            softAssert.assertTrue(product.contains("bmx") || product.contains("lewis"), "Product does not contain 'bmx': " + product);
        }
    }
}