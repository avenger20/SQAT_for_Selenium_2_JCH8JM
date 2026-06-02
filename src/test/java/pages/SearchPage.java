package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    private final By searchInput =
            By.id("search");

    private final By searchResults =
            By.cssSelector(".searchResult");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {

        type(searchInput, text);

        driver.findElement(searchInput)
                .sendKeys(Keys.ENTER);
    }

    public boolean hasResults() {
        return isDisplayed(searchResults);
    }
}