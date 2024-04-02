package fragments;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FAQFragment extends BasePage {

    public FAQFragment(WebDriver driver) {
        super(driver);
    }

    public WebElement getFrequentlyAskedQuestionsElement() {
        return waitVisibilityOfElement("//div[@class='gc-faq__intro']");
    }

    public List<WebElement> getFAQFragments() {
        return waitVisibilityOfElements("//div[@class='gc-faq__block--wrp']");
    }

}

