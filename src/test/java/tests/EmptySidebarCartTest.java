package tests;

import fragments.HeaderFragment;
import fragments.SidebarCartFragment;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EmptySidebarCartTest extends BaseTest {

    public static HeaderFragment headerFragment;
    public static SidebarCartFragment sidebarCartFragment;
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void beforeTest() {
        headerFragment = new HeaderFragment(driver);
        sidebarCartFragment = new SidebarCartFragment(driver);
    }

    @Test(description = "SPRIN-12 Empty Sidebar Cart Verification")
    public void emptySidebarCart() {
        sidebarCartFragment.clickCartIcon();

        int itemsCount = sidebarCartFragment.getQuantityCount();
        softAssert.assertEquals(itemsCount, 0, "The number of items in the cart sidebar is not zero");

        softAssert.assertTrue(sidebarCartFragment.isCheckoutButtonAbsent(), "Checkout button is present in empty cart");
        softAssert.assertTrue(sidebarCartFragment.isSubtotalFieldAbsent(), "Subtotal field is present in empty cart");
    }
}
