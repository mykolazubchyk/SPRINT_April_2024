package fragments;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ItemCatalogFragment extends BasePage {

    public ItemCatalogFragment(WebDriver driver) {
        super(driver);
    }

    private static final String LIST_OF_ITEM_NAMES = "//span[@class='product-block-name-wrapper']";

    public List<String> getListOfAllItemsName() {
        List<String> list = new ArrayList<>();

        for (WebElement name : waitVisibilityOfElements(LIST_OF_ITEM_NAMES)) {
             list.add(name.getText());
        }

        return list;
    }
}
