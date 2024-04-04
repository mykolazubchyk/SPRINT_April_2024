package pages;

import common.BasePage;
import fragments.FilterFragment;
import fragments.HeaderFragment;
import fragments.ItemCatalogFragment;
import org.openqa.selenium.WebDriver;

public class WomanPage extends BasePage {

    private FilterFragment filterFragment;
    private ItemCatalogFragment itemCatalogFragment;
    private HeaderFragment headerFragment;

    public WomanPage(WebDriver driver) {

        super(driver);

        this.filterFragment = new FilterFragment(driver);
        this.itemCatalogFragment = new ItemCatalogFragment(driver);
        this.headerFragment = new HeaderFragment(driver);
    }

    public FilterFragment getFilterFragment() {
        return filterFragment;
    }

    public ItemCatalogFragment getItemCatalogFragment() {
        return itemCatalogFragment;
    }

    public HeaderFragment getHeaderFragment() {
        return headerFragment;
    }
}
