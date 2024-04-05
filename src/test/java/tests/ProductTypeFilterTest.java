package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.WomanPage;

public class ProductTypeFilterTest extends BaseTest {
    private static WomanPage womanPage;

    @BeforeMethod
    private void initTest(){
        womanPage = new WomanPage(driver);
    }

    @Test(description = "SPRIN-10:Product Type Filter ")
    public void verifyProductTypeFilter() {

        womanPage.getHeaderFragment().chooseCategoryDropdown("Women");
        womanPage.getFilterFragment().waitUntilSpinnerDisappear();
        womanPage.getFilterFragment().chooseCategory("Shoes");
        womanPage.getFilterFragment().waitUntilSpinnerDisappear();

        for (String name : womanPage.getItemCatalogFragment().getListOfAllItemsName()) {
            softAssert.assertTrue(name.contains("Shoes"), "Item name does not contain chosen category");
        }

        womanPage.getFilterFragment().chooseProductType("Slip-ons");
        womanPage.getFilterFragment().waitUntilSpinnerDisappear();

        for (String name : womanPage.getItemCatalogFragment().getListOfAllItemsName()) {
            softAssert.assertTrue(name.contains("Slip-On"), "Item name does not contain chosen category");
        }
    }
}
