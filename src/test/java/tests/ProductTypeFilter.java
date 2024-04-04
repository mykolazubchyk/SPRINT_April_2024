package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WomanPage;

public class ProductTypeFilter extends BaseTest {

    @Test(description = "SPRIN-10:Product Type Filter ")
    public void verifyProductTypeFilter() throws InterruptedException {
        WomanPage womanPage = new WomanPage(driver);

        womanPage.getHeaderFragment().acceptCookies();
        womanPage.getHeaderFragment().chooseCategoryDropdown("Women");
        womanPage.getFilterFragment().waitUntilSpinnerDisappear();
        womanPage.getFilterFragment().chooseCategory("Shoes");
        womanPage.getFilterFragment().waitUntilSpinnerDisappear();

        for (String name : womanPage.getItemCatalogFragment().getListOfAllItemsName()) {
            Assert.assertTrue(name.contains("Shoes"), "Item name does not contain chosen category");
        }

        womanPage.getFilterFragment().chooseProductType("Slip-ons");

        for (String name : womanPage.getItemCatalogFragment().getListOfAllItemsName()) {
            Assert.assertTrue(name.contains("Slip-On"), "Item name does not contain chosen category");
        }
    }
}
