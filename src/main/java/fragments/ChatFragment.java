package fragments;

import common.BasePage;
import fragments.HeaderFragment;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ChatFragment extends BasePage {
    private static final String OPEN_CHAT = "//button[contains(@class, 'helpButton')]";
    private static final String CLOSE_CHAT_BUTTON ="//button[contains(@class, 'closeButton')]";
    private static final String START_CHAT_BUTTON = "//button[contains(@class,'startButton')]";
    @Getter
    private final HeaderFragment headerFragment= new HeaderFragment(driver);
    public WebElement clickOnChatButton() {
        return waitClickabilityOfElement(OPEN_CHAT);
    }

    public WebElement clickOnCloseChatButton() {
        return waitClickabilityOfElement(CLOSE_CHAT_BUTTON);
    }

    public ChatFragment(WebDriver driver) {
        super(driver);
    }
    public boolean isChatOpened(){
        return waitVisibilityOfElement(START_CHAT_BUTTON) !=null;
    }
    public boolean isChatClosed(){
        return  waitVisibilityOfElement(OPEN_CHAT)!= null;
    }
}

