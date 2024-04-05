package tests;

import fragments.HeaderFragment;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchFieldTest extends BaseTest {

    private static final String SEARCH_TEXT = "Customer car";

    private static HeaderFragment headerFragment;

    @BeforeMethod
    private void initTest() {
        headerFragment = new HeaderFragment(driver);
    }

    @Test(description = "SPRIN-64: Clear the search field")
    public void testClearSearchField() {

        softAssert.assertTrue(!headerFragment.isButtonDisplayed(), "The button is visible");

        headerFragment.getSearchField().sendKeys(SEARCH_TEXT);

        softAssert.assertTrue(headerFragment.isButtonDisplayed(), "The button is not visible");

        headerFragment.getClearButtonSearchField().click();

        softAssert.assertTrue(!headerFragment.isButtonDisplayed(), "The button is visible");
    }
}