package fragments;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static common.CommonActions.getListOfString;
import static fragments.FilterFragment.LOADING_SPINNER;

public class ItemCatalogFragment extends BasePage {

    private static final String LIST_OF_ITEM_NAMES = "//span[@class='product-block-name-wrapper']";

    public ItemCatalogFragment(WebDriver driver) {
        super(driver);
    }

    public List<String> getListOfAllItemsName() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LOADING_SPINNER)));
        return getListOfString(waitVisibilityOfElements(LIST_OF_ITEM_NAMES));
    }
}