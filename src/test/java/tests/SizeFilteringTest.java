package tests;

import fragments.ItemCatalogFragment;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.productPages.WomanPage;

public class SizeFilteringTest extends BaseTest {
    private static WomanPage womanPage;
    private static ItemCatalogFragment itemCatalogFragment;

    private static ProductPage productPage;

    @BeforeMethod
    private void initTest(){
        womanPage = new WomanPage(driver);
        itemCatalogFragment = new ItemCatalogFragment(driver);
        productPage = new ProductPage(driver);
    }

    @Test(description = "SPRIN-23: Size Filter")
    public void verifySizeFilter() {

        womanPage.getHeaderFragment().chooseCategoryDropdown("Women");
        womanPage.getFilterFragment().waitUntilSpinnerDisappear();
        womanPage.getFilterFragment().getSizeButton("XXS").click();
        womanPage.getFilterFragment().waitUntilSpinnerDisappear();

        String productName = itemCatalogFragment.getListOfAllItems().getLast().getText().toUpperCase();

        itemCatalogFragment.getListOfAllItems().getLast().click();

        softAssert.assertTrue(productName.contains(productPage.getProductName().getText()),
                     "Product name does not match the selected one");
        softAssert.assertTrue(productPage.getProductImage().isDisplayed(),
                     "Product image is not displayed");
        softAssert.assertTrue(productPage.getProductName().isDisplayed(),
                     "Product name is not displayed");
        softAssert.assertTrue(productPage.getProductContent().isDisplayed(),
                     "Product content is not displayed");

        productPage.getCustomSizeDropdownButton().click();

        softAssert.assertTrue(productPage.getListOfAllItemSizes().contains("XXS"),
                     "No product in the right size");
    }
}
