package pages.productPages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SkateboarderPage extends BasePage {

    public SkateboarderPage(WebDriver driver) {
        super(driver);
    }

    private static final String TITLE = "//h1";

    public WebElement getTitle(){
        return waitVisibilityOfElement(TITLE);
    }
}
