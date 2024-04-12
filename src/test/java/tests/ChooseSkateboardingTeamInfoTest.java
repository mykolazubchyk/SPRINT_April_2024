package tests;

import common.CommonActions;
import fragments.HeaderFragment;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SkateboardingPage;
import pages.productPages.SkateboarderPage;

import java.util.List;

public class ChooseSkateboardingTeamInfoTest extends BaseTest{

    private static HeaderFragment headerFragment;
    private static SkateboardingPage skateboardingPage;
    private static SkateboarderPage skateboarderPage;

    @BeforeMethod
    private void initTest() {
        headerFragment = new HeaderFragment(driver);
        skateboardingPage = new SkateboardingPage(driver);
        skateboarderPage = new SkateboarderPage(driver);
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

            String nameSkater = teamList.get(i).getText().toLowerCase();

            teamList.get(i).click();

            softAssert.assertTrue(skateboarderPage.getTitle().getText().toLowerCase().contains(nameSkater),
                         "The page does not match the selected skater");

            driver.navigate().back();
        }
    }
}
