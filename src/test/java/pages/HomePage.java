package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By searchInput =
            By.cssSelector("input[name='searchtext'], input[type='text']");

    // PONTOSÍTVA: Kifejezetten a "Loki" feliratú linket keresi, aminek az URL-jében szerepel a seriesid=10244
    private final By firstResult =
            By.xpath("//a[contains(@href, 'seriesid=10244') and text()='Loki']");

    // PONTOSÍTVA: Kifejezetten a "(Profilom)" feliratú linket keresi, ami meghívja az account('menu') JS függvényt
    private final By profileMenu =
            By.xpath("//a[contains(@onclick, 'account') and contains(text(), 'Profilom')]");

    private final By logoutButton =
            By.xpath("//a[contains(@href,'logout')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchBarDisplayed() {
        return isDisplayed(searchInput);
    }

    public void search(String text) {
        type(searchInput, text);
        driver.findElement(searchInput).sendKeys(Keys.ENTER);
    }

    public void openFirstResult() {
        click(firstResult);
    }

    public void openProfileMenu() {
        click(profileMenu);
    }

    public void logout() {
        click(logoutButton);
    }

    public void openSeriesPage() {
        driver.get("https://www.sorozat-barat.club/sorozatok");
    }
}