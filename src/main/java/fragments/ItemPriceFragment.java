package fragments;

import common.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

import static common.CommonActions.getListOfString;

public class ItemPriceFragment extends BasePage {

    private static final String LIST_OF_ITEM_PRICES = "//span[contains(@class,'product-block-price')]";

    public ItemPriceFragment(WebDriver driver) {
        super(driver);
    }
    public List<Integer> getListOfAllItemsPrice() {
        List<String> fullPrice = getListOfString(waitVisibilityOfElements(LIST_OF_ITEM_PRICES));
        List<Integer> prices = fullPrice.stream()
                .map(price -> Integer.parseInt(price.replaceAll("[^0-9]", "")))
                .collect(Collectors.toList());
        return prices;
    }
}
