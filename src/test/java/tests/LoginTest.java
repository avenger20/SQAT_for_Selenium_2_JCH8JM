package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.EmailLoginPage;
import pages.PasswordLoginPage;
import pages.HomePage;

public class LoginTest extends BaseTest {

    @Test(groups = "login")
    public void successfulLoginShouldDisplaySearchBar() {

        EmailLoginPage emailLoginPage =
                new EmailLoginPage(driver);

        PasswordLoginPage passwordLoginPage =
                new PasswordLoginPage(driver);

        HomePage homePage =
                new HomePage(driver);

        emailLoginPage.open();

        emailLoginPage.submitEmail(email);

        passwordLoginPage.submitPassword(password);

        Assert.assertTrue(
                homePage.isSearchBarDisplayed()
        );
    }
}