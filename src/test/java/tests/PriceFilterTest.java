package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.WomanPage;

public class PriceFilterTest extends BaseTest {

    private static WomanPage womanPage;

    @BeforeMethod
    private void initTest() {
        womanPage = new WomanPage(driver);
    }

    @Test(description = "SPRIN-23:Product Price Filter ")
    public void priceFilter() {
        womanPage.getHeaderFragment().chooseCategoryDropdown("Women");
        womanPage.getFilterFragment().waitUntilSpinnerDisappear();
        womanPage.getFilterFragment().chooseCategory("Shoes");
        womanPage.getFilterFragment().waitUntilSpinnerDisappear();

        for (String name : womanPage.getItemCatalogFragment().getListOfAllItemsName()) {
            softAssert.assertTrue(name.contains("Shoes"), "Item name does not contain chosen category");
        }
        womanPage.getFilterFragment().dragFirstSliderToValue("50");
        womanPage.getFilterFragment().waitUntilSpinnerDisappear();
        womanPage.getFilterFragment().dragSecondSliderToValue("100");
        womanPage.getFilterFragment().waitUntilSpinnerDisappear();

        for (int price : womanPage.getItemPriceFragment().getListOfAllItemsPrice()) {
            softAssert.assertTrue(price >= 50 && price <= 100, "Item price is not within selected range");
        }
    }
}
