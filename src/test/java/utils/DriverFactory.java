package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public static WebDriver createDriver(boolean headless) {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");

        if (headless) {
            options.addArguments("--headless=new");
        }

        try {

            return new RemoteWebDriver(
                    new URL("http://localhost:4444/wd/hub"),
                    options
            );

        } catch (MalformedURLException e) {

            throw new RuntimeException(e);
        }
    }
}