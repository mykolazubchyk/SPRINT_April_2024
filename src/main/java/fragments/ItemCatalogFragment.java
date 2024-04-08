package fragments;

import common.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static common.CommonActions.getListOfString;

public class    ItemCatalogFragment extends BasePage {

    private static final String LIST_OF_ITEM_NAMES = "//span[@class='product-block-name-wrapper']";

    public ItemCatalogFragment(WebDriver driver) {
        super(driver);
    }

    public List<String> getListOfAllItemsName() {
        return getListOfString(waitVisibilityOfElements(LIST_OF_ITEM_NAMES));
    }
}