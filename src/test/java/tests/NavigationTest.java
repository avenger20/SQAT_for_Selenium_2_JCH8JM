package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    public void browserBackAndForwardShouldWork() {

        driver.navigate().to("https://www.sorozat-barat.info");

        String firstTitle = driver.getTitle();

        driver.navigate().to("https://www.sorozat-barat.info/forum");

        driver.navigate().back();

        Assert.assertEquals(driver.getTitle(), firstTitle);

        driver.navigate().forward();

        Assert.assertTrue(driver.getCurrentUrl().contains("forum"));
    }
}