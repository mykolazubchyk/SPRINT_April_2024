package tests;

import fragments.FilterFragment;
import fragments.HeaderFragment;
import fragments.ItemCatalogFragment;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTypeFilter extends BaseTest {

    @Test
    public void verifyProductTypeFilter() {
        HeaderFragment headerFragment = new HeaderFragment(driver);
        FilterFragment filterFragment = new FilterFragment(driver);
        ItemCatalogFragment itemCatalogFragment = new ItemCatalogFragment(driver);

        headerFragment.acceptCookies();
        headerFragment.chooseWomenCategory();
        filterFragment.chooseShoesCategory();

        for (String name : itemCatalogFragment.getListOfAllItemsName()) {
            Assert.assertTrue(name.contains("Shoes"));
        }
    }
}
