package fragments;

import common.BasePage;
import org.openqa.selenium.WebDriver;

import static common.CommonActions.getElementsNumber;

public class SidebarCartFragment extends BasePage {

    private static final String SHOPPING_SIDEBAR_ICON = id("icon-panel-cart");
    private static final String QUANTITY_TITLE = "//h3[contains(@class,'section-title')]";
    private static final String SUBTOTAL_FIELD = "//h4[contains(@class,'cart-subtotal')]";
    private static final String CHECKOUT_BUTTON = "//div[contains(@class,'item-container ')]//a[contains(@class,'action button')]";

    public SidebarCartFragment(WebDriver driver) {
        super(driver);
    }

    public void clickCartIcon() {
        waitClickabilityOfElement(SHOPPING_SIDEBAR_ICON).click();
    }

    public int getQuantityCount() {
        String quantityText = waitVisibilityOfElement(QUANTITY_TITLE).getText();
        return Integer.parseInt(quantityText.replaceAll("[^0-9]", ""));
    }

    public boolean isCheckoutButtonAbsent() {
        return (getElementsNumber(CHECKOUT_BUTTON) == 0);
    }

    public boolean isSubtotalFieldAbsent() {
        return (getElementsNumber(SUBTOTAL_FIELD) == 0);
    }
}
