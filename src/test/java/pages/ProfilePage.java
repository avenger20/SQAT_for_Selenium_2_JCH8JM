package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    private final By logoutButton = By.xpath(
            "//a[contains(@href,'logout')]"
    );

    public void logout() {
        click(logoutButton);
    }
}