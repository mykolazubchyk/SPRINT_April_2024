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
        WebElement element = driver.findElement(By.xpath("//a[@href=/shop/en-gb/vans-gb/premium]"));
        element.click();
    }
}
