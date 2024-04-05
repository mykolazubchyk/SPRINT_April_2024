package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Homepage;

public class CheckFollowUsButtonTest extends BaseTest {
    private static final String EXPECTED_TWITTER_URL = "https://twitter.com/vans_europe";
    private static final String EXPECTED_FACEBOOK_URL = "https://www.facebook.com/VansEurope";
    private static final String EXPECTED_INSTAGRAM_URL = "https://www.instagram.com/vans_europe/";
    private static final String EXPECTED_YOUTUBE_URL = "https://www.youtube.com/user/VansShoes66";

    @Test
    public void clickOnTheTwitterButton() {
        Homepage homepage = new Homepage(driver);
        homepage.scrollToElement();
        homepage.clickOnAllowAll();
        homepage.clickOnTwitterButton();
        driver.getCurrentUrl();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,EXPECTED_TWITTER_URL,"Expected URL isn`t valid");
        driver.navigate().back();
        homepage.scrollToElement();
        homepage.clickOnFacebookButton();
        Assert.assertEquals(driver.getCurrentUrl(),EXPECTED_FACEBOOK_URL,"Expected URL isn`t valid");
        driver.navigate().back();
        homepage.scrollToElement();
        homepage.clickOnInstagramButton();
        Assert.assertEquals(driver.getCurrentUrl(),EXPECTED_INSTAGRAM_URL,"Expected URL isn`t valid");
        driver.navigate().back();
        homepage.scrollToElement();
        homepage.clickOnYoutubeButton();
        Assert.assertEquals(driver.getCurrentUrl(),EXPECTED_YOUTUBE_URL,"Expected URL isn`t valid");
    }
}

