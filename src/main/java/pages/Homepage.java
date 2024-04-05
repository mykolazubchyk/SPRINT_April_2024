package pages;

import fragments.HeaderFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage extends HeaderFragment {
    public Homepage(WebDriver driver) {
        super(driver);
    }

    public void clickOnVansPremiumButton() {
        WebElement element = driver.findElement(By.xpath("//*[contains(@class, 'l1category') and contains(@class, 'section')]"));
        element.click();
    }

    public void clickOnChatButton() {
        WebElement element = driver.findElement(By.xpath("//button[contains(@class, 'helpButton')]"));
        element.click();
    }

    public void clickOnCloseChatButton() {
        WebElement element = driver.findElement(By.xpath("//button[contains(@class, 'closeButton')]"));
        element.click();
    }

    public void clickOnAllowAll() {
        WebElement element = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        element.click();
    }
}
