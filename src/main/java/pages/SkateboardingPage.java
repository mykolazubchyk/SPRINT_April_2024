package pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SkateboardingPage extends BasePage {
    public SkateboardingPage(WebDriver driver) {
        super(driver);
    }

    private static final String SKATEBOARDING_TEAM_CONTAINER = "//*[@class='team-module']";
    private static final String TEAM_LIST = "//*[@class='inner-col']";          //"//*[@class='actionsport-track']";

    public WebElement getSkateboardingTeamContainer() {
        return waitVisibilityOfElement(SKATEBOARDING_TEAM_CONTAINER);
    }

    public List<WebElement> getSkateboardingTeamList() {
        return waitVisibilityOfElements(TEAM_LIST);
    }
}
