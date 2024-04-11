package tests;

import common.CommonActions;
import fragments.FooterFragment;
import fragments.HeaderFragment;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PrivacyPolicyPage;
import pages.SkateboardingPage;

import java.util.List;

public class ChooseSkateboardingTeamInfoTest extends BaseTest{

    private static HeaderFragment headerFragment;
    private static SkateboardingPage skateboardingPage;

    @BeforeMethod
    private void initTest() {
        headerFragment = new HeaderFragment(driver);
        skateboardingPage = new SkateboardingPage(driver);
    }

    @Test(description = "SPRIN-90: Choose skateboarding team info")
    public void testChooseSkateboardingTeamInfo(){

        String nameCategory = headerFragment.getCategoryAccordion("SKATEBOARDING").getText().toLowerCase();

        headerFragment.getCategoryAccordion("SKATEBOARDING").click();

        softAssert.assertTrue(skateboardingPage.getSkateboardingTeamContainer().getText().toLowerCase().contains(nameCategory),
                "It's not a skateboarding team");
        softAssert.assertTrue(skateboardingPage.getSkateboardingTeamContainer().isDisplayed(),
                "The list of skateboarding teams is not displayed");

        CommonActions.scrollToElement(driver, skateboardingPage.getSkateboardingTeamContainer());

        String playerName = skateboardingPage.getSkateboardingTeamList().get(27).getText().toLowerCase();

        skateboardingPage.getSkateboardingTeamList().get(27).click();






    }


}
