package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {
    WebDriver driver1;
    public Homepage(WebDriver driver1) {
        this.driver1 = driver1;
        driver1.get("https://www.vans.co.uk");
    }

    public void scrollToElement() {
        ((JavascriptExecutor) driver1).executeScript("arguments[0].scrollIntoView(true);", driver1.findElement(By.xpath("//a[@href='https://twitter.com/vans_europe']")));
    }

    public void clickOnAllowAll() {
        WebElement element = driver1.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        element.click();
    }

    public void clickOnTwitterButton() {
        WebElement element = driver1.findElement(By.xpath("//a[@href='https://twitter.com/vans_europe']"));
        element.click();
    }

    public void clickOnFacebookButton() {
        WebElement element = driver1.findElement(By.xpath("//a[@href='https://www.facebook.com/VansEurope']"));
        element.click();    
    }

    public void clickOnInstagramButton() {
        WebElement element = driver1.findElement(By.xpath("//a[@href='https://www.instagram.com/vans_europe/']"));
        element.click();
    }

    public void clickOnYoutubeButton() {
        WebElement element = driver1.findElement(By.xpath("//a[@href='https://www.youtube.com/user/VansShoes66']"));
        element.click();
    }
}



