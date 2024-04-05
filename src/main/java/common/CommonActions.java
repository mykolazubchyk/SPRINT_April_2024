package common;

import com.github.javafaker.Faker;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.openqa.selenium.Keys.*;

public class CommonActions extends BasePage {

    public static final Faker faker = new Faker();

    protected CommonActions(WebDriver driver) {
        super(driver);
    }

    public static String generateRandomFirstName() {
        return faker.name().firstName();
    }

    public static String generateRandomLastName() {
        return faker.name().lastName();
    }

    public static String generateRandomPhoneNumber() {
        return "44" + faker.phoneNumber().subscriberNumber(7);
    }

    public static long getRandomNumber() {
        return System.currentTimeMillis();
    }

    public static int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static void clearField(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);

        String os = System.getProperty("os.name").toLowerCase();
        boolean isMac = os.contains("mac");

        element.click();

        if (isMac) {
            actions.keyDown(COMMAND).sendKeys("a").pause(200).keyUp(COMMAND).sendKeys(DELETE).perform();
        } else {
            actions.keyDown(CONTROL).sendKeys("a").pause(200).keyUp(CONTROL).sendKeys(DELETE).perform();
        }
    }

    public static void openNewTab(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.open();");
    }

    public boolean isCurrentUrlContains(String url) {
        try {
            wait.until(ExpectedConditions.urlContains(url));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] captureScreen(WebDriver driver) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("./target/allure-results//" + screenshot.getName()));
        return Files.toByteArray(screenshot);
    }

    public static void hover(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).pause(2).perform();
    }

    public static List<String> getListOfString(List<WebElement> webElements) {
        List<String> selections = new ArrayList<>();
        for (WebElement element : webElements) {
            selections.add(element.getText());
        }
        return selections;
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: \"center\"});", element);
    }
}