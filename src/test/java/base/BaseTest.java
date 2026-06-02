package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;

    protected String baseUrl;
    protected String email;
    protected String password;
    protected boolean headless;

    @BeforeMethod
    public void setup() throws Exception {

        Properties properties = new Properties();

        properties.load(
                new FileInputStream("src/test/resources/config.properties")
        );

        baseUrl = properties.getProperty("base.url");
        email = properties.getProperty("email");
        password = properties.getProperty("password");

        headless = Boolean.parseBoolean(
                properties.getProperty("headless")
        );

        ChromeOptions options = new ChromeOptions();

        if (headless) {
            options.addArguments("--headless=new");
        }

        options.addArguments("--start-maximized");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");

        driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                options
        );

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
    	if (driver != null) {
            	driver.quit();
    	}
    	try {
        	// 4 másodperc szünet a tesztek között, hogy a Sorozat-Barát szervere megnyugodjon
        	Thread.sleep(4000); 
    	} catch (InterruptedException e) {
        	Thread.currentThread().interrupt();
    	}
    }
}