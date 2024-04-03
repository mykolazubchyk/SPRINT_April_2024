package tests;

import fragments.HeaderFragment;
import fragments.SidebarCartFragment;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmptySidebarCartTest extends BaseTest {

    @Test(description = "Empty Sidebar Cart Verification")
    @Description("SPRIN-12")

    public void emptySidebarCart() {
        HeaderFragment headerFragment = new HeaderFragment(driver);
        SidebarCartFragment sidebarCartFragment = new SidebarCartFragment(driver);

        headerFragment.acceptCookies();
        sidebarCartFragment.clickCartIcon();

        int itemsCount = sidebarCartFragment.getQuantityCount();
        Assert.assertEquals(itemsCount, 0, "The number of items in the cart sidebar is not zero");

        Assert.assertTrue(sidebarCartFragment.isCheckoutButtonAbsent(), "Checkout button is present in empty cart");
        Assert.assertTrue(sidebarCartFragment.isSubtotalFieldAbsent(), "Subtotal field is present in empty cart");
    }
}
