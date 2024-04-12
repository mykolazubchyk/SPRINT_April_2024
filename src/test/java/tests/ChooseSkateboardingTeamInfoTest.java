package tests;

import common.BasePage;
import common.CommonActions;
import fragments.HeaderFragment;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SkateboardingPage;
import pages.productPages.SkateboardersPage;

import java.util.List;

public class ChooseSkateboardingTeamInfoTest extends BaseTest{

    private static HeaderFragment headerFragment;
    private static SkateboardingPage skateboardingPage;
    private static SkateboardersPage skateboardersPage;

    @BeforeMethod
    private void initTest() {
        headerFragment = new HeaderFragment(driver);
        skateboardingPage = new SkateboardingPage(driver);
        skateboardersPage = new SkateboardersPage(driver);
    }

    @Test(description = "SPRIN-90: Choose skateboarding team info")
    public void testChooseSkateboardingTeamInfo(){

        headerFragment.getCategoryDropdown("Action Sports").click();

        String nameItem = headerFragment.getOneOfTheItemsCategoryDropdown("Skateboarding").getText().toLowerCase();

        headerFragment.getOneOfTheItemsCategoryDropdown("Skateboarding").click();

        softAssert.assertTrue(skateboardingPage.getSkateboardingTeamContainer().getText().toLowerCase().contains(nameItem),
                "It's not a skateboarding team");
        softAssert.assertTrue(skateboardingPage.getSkateboardingTeamContainer().isDisplayed(),
                "The list of skateboarding teams is not displayed");

        CommonActions.scrollToElement(driver, skateboardingPage.getSkateboardingTeamContainer());

        List<WebElement> teamList = skateboardingPage.getSkateboardingTeamList();

        for (int i = 0; i < teamList.size(); i++) {
            teamList = skateboardingPage.getSkateboardingTeamList();

            String nameS = teamList.get(i).getText();

            teamList.get(i).click();

            softAssert.assertTrue(skateboardersPage.findElementByText(nameS).getText().toLowerCase().contains(nameS));

            driver.navigate().back();
        }
    }
}
