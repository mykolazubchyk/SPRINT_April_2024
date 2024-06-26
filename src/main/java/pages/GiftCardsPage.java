package pages;

import common.BasePage;
import common.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GiftCardsPage extends BasePage {

    private static final String FAQ_TITLE = "//div[@class='gc-faq__intro']";
    private static final String FAQ_PANELS = "//div[@class='gc-faq__block--wrp']";
    private static final String SPECIFIC_FAQ_PANEL = "//div[@class='gc-faq__block--wrp'][%s]";
    private static final String FAQ_EXTENDED_CONTENT = FAQ_PANELS + "/div";
    private static final String FAQ_SPECIFIC_CONTENT ="(//div[@class='gc-faq__block--wrp']/div)[%s]";

    public GiftCardsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFrequentlyAskedQuestionsElement() {
        return waitVisibilityOfElement(FAQ_TITLE);
    }

    public List<WebElement> getGiftCardsFaqPanels() {
        return waitVisibilityOfElements(FAQ_PANELS);
    }

    public void scrollToSpecificGiftCardFaqPanel(int panelNumber) {
        WebElement panel = waitVisibilityOfElement(String.format(SPECIFIC_FAQ_PANEL, panelNumber + 1));
        CommonActions.scrollToElement(driver, panel);
    }

    public List<WebElement> getGiftCardsFaqExtendedContents() {
        return waitPresenceOfElements(FAQ_EXTENDED_CONTENT);
    }

    public WebElement getGiftCardsFaqSpecificContents(int contentText) {
        return waitVisibilityOfElement(String.format(FAQ_SPECIFIC_CONTENT, contentText + 1));
    }
}