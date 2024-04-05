package common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class BasePage {
    public static final Logger logger = LogManager.getLogger(BasePage.class);
    private final int BASE_WAIT = 5;
    protected static WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(BASE_WAIT));
    }

    protected WebElement waitVisibilityOfElement(String locator) {
        try {
            return wait.until(visibilityOfElementLocated(By.xpath(locator)));
        } catch (WebDriverException e) {
            logger.warn("No visibility of element: " + locator);
            return null;
        }
    }

    public WebElement waitClickabilityOfElement(String locator) {
        try {
            return wait.until(elementToBeClickable(By.xpath(locator)));
        } catch (WebDriverException e) {
            logger.warn("No clickability of element: " + locator);
            return null;
        }
    }

    protected WebElement waitPresenceOfElement(String locator) {
        try {
            return wait.until(presenceOfElementLocated(By.xpath(locator)));
        } catch (WebDriverException e) {
            logger.warn("No presence of element: " + locator);
            return null;
        }
    }

    protected List<WebElement> waitPresenceOfElements(String locator) {
        try {
            return wait.until(presenceOfAllElementsLocatedBy(By.xpath(locator)));
        } catch (WebDriverException e) {
            logger.warn("No presence of elements: " + locator);
            return null;
        }
    }

    protected List<WebElement> waitVisibilityOfElements(String locator) {
        try {
            return wait.until(visibilityOfAllElementsLocatedBy(By.xpath(locator)));
        } catch (WebDriverException e) {
            logger.warn("No visibility of elements: " + locator);
            return null;
        }
    }

    public static String id(String webElementId) {
        return String.format("//*[@id='%s']", webElementId);
    }

    protected boolean isElementEnabled(String locator) {
        return driver.findElement(By.xpath(locator)).isEnabled();
    }

    protected boolean isElementDisplayed(String locator) {
        return driver.findElement(By.xpath(locator)).isDisplayed();
    }
}
