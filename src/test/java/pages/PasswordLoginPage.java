package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PasswordLoginPage extends BasePage {

    private final By passwordInput =
            By.name("password");

    private final By loginButton =
            By.name("loginsubmit");

    public PasswordLoginPage(WebDriver driver) {
        super(driver);
    }

    public void submitPassword(String password) {
        // HELYREALLITAS: Megvarjuk, amig a jelszo mezo fizikailag megjelenik az oldalon
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));

        acceptCookiesIfPresent();

        type(passwordInput, password);
        click(loginButton);
    }
}