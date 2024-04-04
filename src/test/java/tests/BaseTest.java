package tests;

import fragments.HeaderFragment;
import listeners.TestListener;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

@Listeners(TestListener.class)
public abstract class BaseTest {

    protected final String BASE_URL = "https://www.vans.co.uk/";

    @Getter
    protected WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    public static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    public void setup() {
        logger.info("Setting up driver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        openUrl();

        logger.info("Driver setup completed");

        HeaderFragment headerFragment = new HeaderFragment(driver);

        headerFragment.acceptCookies();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
        softAssert.assertAll();
    }

    public void openUrl() {
        driver.get(BASE_URL);
    }
}
