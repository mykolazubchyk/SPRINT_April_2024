package fragments;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class FilterFragment extends BasePage {

    public FilterFragment(WebDriver driver) {
        super(driver);
    }

    private static final String LOADING_SPINNER = "//div[@class='activity-indicator']";
    private static final String CATEGORY = "//div[@class='filter-options']//span[normalize-space(text())='%s']";
    private static final String PRODUCT_TYPE = "//span[normalize-space(text())='%s']";
    private static final String FIRST_SLIDER = "//input[@name='range-1']";
    private static final String SECOND_SLIDER = "//input[@name='range-2']";
    private static final String FIRST_OUTPUT = "//section[@class='range-slider']//output[1]";
    private static final String SECOND_OUTPUT = "//section[@class='range-slider']//output[2]";

    public void chooseCategory(String category) {
        waitClickabilityOfElement(String.format(CATEGORY,category)).click();
    }

    public void chooseProductType(String productType) {
        waitClickabilityOfElement(String.format(PRODUCT_TYPE,productType)).click();
    }

    public void waitUntilSpinnerDisappear() {
        waitVisibilityOfElement(LOADING_SPINNER);
        waitUntilElementDisappear(LOADING_SPINNER);
    }

//    public void dragFirstSlider(int xOffset, String minValue) {
//        Actions actions = new Actions(driver);
//
//
//        while(!FIRST_OUTPUT.getText().endsWith(minValue)) {
//            actions.dragAndDropBy(waitVisibilityOfElement(FIRST_SLIDER), 1, 0).perform();
//        }
   // }
public String getFirstSliderValue() {
    return waitVisibilityOfElement(FIRST_OUTPUT).getText();
}

public void dragFirstSliderToValue(String targetValue) {
    Actions actions = new Actions(driver);
    while (!getFirstSliderValue().endsWith(targetValue)) {
        actions.dragAndDropBy(waitVisibilityOfElement(FIRST_SLIDER), 1, 0).perform();
    }
}

    public String getSecondSliderValue() {
        return waitVisibilityOfElement(SECOND_OUTPUT).getText();
    }

    public void dragSecondSliderToValue(String targetValue) {
        Actions actions = new Actions(driver);
        while (!getSecondSliderValue().endsWith(targetValue)) {
            actions.dragAndDropBy(waitVisibilityOfElement(SECOND_SLIDER), -1, 0).perform();
        }
    }

//    public void dragSecondSlider(int xOffset) {
//        Actions actions = new Actions(driver);
//        actions.dragAndDropBy(waitClickabilityOfElement(SECOND_SLIDER), xOffset, 0).perform();
//    }
}
