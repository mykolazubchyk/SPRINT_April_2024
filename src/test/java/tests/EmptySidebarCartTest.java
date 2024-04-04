package tests;

import fragments.HeaderFragment;
import fragments.SidebarCartFragment;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmptySidebarCartTest extends BaseTest {

    public static HeaderFragment headerFragment;
    public static SidebarCartFragment sidebarCartFragment;

    @BeforeMethod
    public void beforeTest() {
        headerFragment = new HeaderFragment(driver);
        sidebarCartFragment = new SidebarCartFragment(driver);
    }

    @Test(description = "SPRIN-12 Empty Sidebar Cart Verification")

    public void emptySidebarCart() {
        sidebarCartFragment.clickCartIcon();

        int itemsCount = sidebarCartFragment.getQuantityCount();
        Assert.assertEquals(itemsCount, 0, "The number of items in the cart sidebar is not zero");

        Assert.assertTrue(sidebarCartFragment.isCheckoutButtonAbsent(), "Checkout button is present in empty cart");
        Assert.assertTrue(sidebarCartFragment.isSubtotalFieldAbsent(), "Subtotal field is present in empty cart");
    }
}
