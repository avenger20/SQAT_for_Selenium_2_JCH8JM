package base;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor; // Új import a JS kattintáshoz
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );
    }

    protected void click(By locator) {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );

        try {
            // Megpróbálunk normálisan, a böngésző felületén rákattintani
            element.click();
        } catch (ElementClickInterceptedException e) {
            // Ha egy reklám eltakarná a gombot, akkor a háttérben, JavaScripttel kattintunk rá
            System.out.println("Sima kattintás blokkolva reklám által, JS click alkalmazása a lokátorra: " + locator);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        }
    }

    protected void type(By locator, String text) {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );

        element.clear();
        element.sendKeys(text);
    }

    protected boolean isDisplayed(By locator) {
        try {
            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(locator)
            ).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected void acceptCookiesIfPresent() {
        By acceptButton = By.cssSelector("button[mode='primary']");

        try {
            WebElement button = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(
                            ExpectedConditions.elementToBeClickable(acceptButton)
                    );

            button.click();
        } catch (TimeoutException | ElementClickInterceptedException e) {
            // nincs cookie popup -> nem csinálunk semmit
        }
    }
}