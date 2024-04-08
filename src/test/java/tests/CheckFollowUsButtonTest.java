package tests;

import fragments.FooterFragment;
import fragments.HeaderFragment;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Homepage;
import static common.CommonActions.scrollToElement;

public class CheckFollowUsButtonTest extends BaseTest {

    private static final String EXPECTED_TWITTER_URL = "https://twitter.com/vans_europe";
    private static final String EXPECTED_FACEBOOK_URL = "https://www.facebook.com/VansEurope";
    private static final String EXPECTED_INSTAGRAM_URL = "https://www.instagram.com/vans_europe/";
    private static final String EXPECTED_YOUTUBE_URL = "https://www.youtube.com/user/VansShoes66";

    public static Homepage homepage;
    public static FooterFragment footerFragment;
    public static HeaderFragment headerFragment;

    @BeforeMethod
    public void initTest() {
        homepage = new Homepage(driver);
        footerFragment = new FooterFragment(driver);
        headerFragment = new HeaderFragment(driver);

    }

    @Test(description = "SPRIN-114 Transfer FOLLOW US section in the footer")
    public void clickOnTheTwitterButton() {
        scrollToElement(driver,footerFragment.getFollowUsSection());
        footerFragment.getTwitterLink();
        driver.getCurrentUrl();
        String currentUrl = driver.getCurrentUrl();

        softAssert.assertEquals(currentUrl,EXPECTED_TWITTER_URL,"Expected URL isn`t valid");

        driver.navigate().back();
        footerFragment.getFacebookLink();

        softAssert.assertEquals(driver.getCurrentUrl(),EXPECTED_FACEBOOK_URL,"Expected URL isn`t valid");

        driver.navigate().back();
        footerFragment.getInstagramLink();

        softAssert.assertEquals(driver.getCurrentUrl(),EXPECTED_INSTAGRAM_URL,"Expected URL isn`t valid");

        driver.navigate().back();
        footerFragment.getYoutubeLink();

        softAssert.assertEquals(driver.getCurrentUrl(),EXPECTED_YOUTUBE_URL,"Expected URL isn`t valid");
    }
}

