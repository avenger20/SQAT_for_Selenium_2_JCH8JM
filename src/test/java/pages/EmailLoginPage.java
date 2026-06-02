package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmailLoginPage extends BasePage {

    private final String url =
            "https://www.sorozat-barat.club/";

    private final By emailInput =
            By.name("login");

    private final By loginButton =
            By.name("loginsubmit");

    public EmailLoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(url);
        acceptCookiesIfPresent();
    }

    public void submitEmail(String email) {
        acceptCookiesIfPresent();
        
        // Megvarjuk, amig az email mezo irhato
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        type(emailInput, email);
        
        // Megvarjuk, amig a gomb kattinthato (nem takarja el pl. suti banner)
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        click(loginButton);
    }
}