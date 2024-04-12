package pages.productPages;

import common.BasePage;
import fragments.FilterFragment;
import fragments.HeaderFragment;
import fragments.ItemCatalogFragment;
import fragments.ProductHeaderFragment;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SkateboardersPage extends BasePage {

    public SkateboardersPage(WebDriver driver) {
        super(driver);
    }

    private static final String ONE_OF_THE_ITEMS_CATEGORY_DROPDOWN = "//*[normalize-space(text())='%s']";

    public WebElement findElementByText(String text){
        return waitVisibilityOfElement(String.format("//*[lower-case(normalize-space(text()))=lower-case('%s')]", text));
    }
}
