package tests;

import fragments.FooterFragment;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static common.CommonActions.scrollToElement;

public class CheckFollowUsButtonTest extends BaseTest {

    private static final String EXPECTED_TWITTER_URL = "https://twitter.com/vans_europe";
    private static final String EXPECTED_FACEBOOK_URL = "https://www.facebook.com/VansEurope";
    private static final String EXPECTED_INSTAGRAM_URL = "https://www.instagram.com/vans_europe/";
    private static final String EXPECTED_PART_YOUTUBE_URL = "https://www.youtube.com/user/VansShoes66";

    private static FooterFragment footerFragment;

    @BeforeMethod
    public void initTest() {
        footerFragment = new FooterFragment(driver);

    }

    @Test(description = "SPRIN-114 Transfer FOLLOW US section in the footer")
    public void clickOnTheTwitterButton() {
        scrollToElement(driver,footerFragment.getFollowUsSection());
        footerFragment.goToTwitterPage();
        driver.getCurrentUrl();

        softAssert.assertEquals(driver.getCurrentUrl(),EXPECTED_TWITTER_URL,"Expected URL isn`t valid");

        driver.navigate().back();
        footerFragment.goToFacebookPage();

        softAssert.assertEquals(driver.getCurrentUrl(),EXPECTED_FACEBOOK_URL,"Expected URL isn`t valid");

        driver.navigate().back();
        footerFragment.goToInstagramPage();

        softAssert.assertEquals(driver.getCurrentUrl(),EXPECTED_INSTAGRAM_URL,"Expected URL isn`t valid");

        driver.navigate().back();
        footerFragment.goToYoutubeChannel();

        softAssert.assertTrue(driver.getCurrentUrl().startsWith(EXPECTED_PART_YOUTUBE_URL),"Expected URL isn`t valid");
    }

}

