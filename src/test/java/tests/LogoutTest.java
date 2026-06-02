package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.EmailLoginPage;
import pages.PasswordLoginPage;
import pages.HomePage;

public class LogoutTest extends BaseTest {

    @Test(dependsOnGroups = "login")
    public void logoutShouldReturnToLoginPage() {

        EmailLoginPage emailLoginPage =
                new EmailLoginPage(driver);

        PasswordLoginPage passwordLoginPage =
                new PasswordLoginPage(driver);

        HomePage homePage =
                new HomePage(driver);

        emailLoginPage.open();

        emailLoginPage.submitEmail(email);

        passwordLoginPage.submitPassword(password);

        homePage.openSeriesPage();

        homePage.search("Loki");

        homePage.openFirstResult();

        homePage.openProfileMenu();

        homePage.logout();

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("/auth/")
        );
    }
}