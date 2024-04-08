package pages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Homepage extends BasePage {
    public Homepage(){
        super(driver);
        driver.get("https://www.vans.co.uk");
    }

    public void scrollToElement() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[@href='https://twitter.com/vans_europe']")));
    }

    public void clickOnAllowAll() {
        WebElement element = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        element.click();
    }

    public void clickOnTwitterButton() {
        WebElement element = driver.findElement(By.xpath("//a[@href='https://twitter.com/vans_europe']"));
        element.click();
    }

    public void clickOnFacebookButton() {
        WebElement element = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/VansEurope']"));
        element.click();
    }

    public void clickOnInstagramButton() {
        WebElement element = driver.findElement(By.xpath("//a[@href='https://www.instagram.com/vans_europe/']"));
        element.click();
    }

    public void clickOnYoutubeButton() {
        WebElement element = driver.findElement(By.xpath("//a[@href='https://www.youtube.com/user/VansShoes66']"));
        element.click();
    }
}
