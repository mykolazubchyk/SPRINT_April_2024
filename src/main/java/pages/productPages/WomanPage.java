package pages.productPages;

import common.BasePage;
import fragments.FilterFragment;
import fragments.HeaderFragment;
import fragments.ItemCatalogFragment;
import fragments.ProductHeaderFragment;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

public class WomanPage extends BasePage {

    @Getter
    private final FilterFragment filterFragment = new FilterFragment(driver);
    @Getter
    private final ItemCatalogFragment itemCatalogFragment = new ItemCatalogFragment(driver);
    @Getter
    private final HeaderFragment headerFragment = new HeaderFragment(driver);
    @Getter
    private final ProductHeaderFragment productHeaderFragment = new ProductHeaderFragment(driver);

    public WomanPage(WebDriver driver) {
        super(driver);
    }
}
