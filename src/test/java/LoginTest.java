import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;


public class LoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void  beforeMethod () {
         webDriver = new FirefoxDriver();
    }

    @AfterMethod
    public void afterMethod () {
        webDriver.quit();
    }

    /**
     * Preconditions:
     * -Open FF browser;
     * <p>
     * Scenario:
     * -Navigate to https://www.linkedin.com;
     * -Verify that login page is loaded;
     * - Enter userEmail in to UserEmail field;
     * - Enter userPassword in to userPassword;
     * - Click on signIn button;
     * - Verify that Home page is load
     * <p>
     * <p>
     * PostCondition:
     * -Close FF browser.
     */
    @Test
    public void successfulLoginTest() {

        webDriver.get("https://www.linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");

        loginPage.login("bryzhatan@gmail.com", "Qwerty");
        HomePage homePage = new HomePage(webDriver);
        Assert.assertTrue(homePage.isHomePageLoad(), "Home page is not loaded");

      /*  Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/feed/",
                "Login page URL is wrong");
        Assert.assertEquals (webDriver.getTitle(), "LinkedIn",
                "Home page title is wrong.");
        HomePage homePage = new HomePage(webDriver);
       // Assert.assertTrue(homePage.profileNavItem.isDisplayed(),
               // "profileNavItem is not displayed on Login page.");*/

    }

    @Test
    public void negativeLoginWithEmptyPasswordTest () {
        webDriver.get("https://www.linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");

        loginPage.login("a@b.c", "");

       Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/",
                "Login page URL is wrong");


    }

    @Test

    public void negativeTestInvalidPassword () {
        webDriver.get("https://www.linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");
        loginPage.login("bryzhatan@gmail.com", "qwerty");
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SubmitPage submitPage= new SubmitPage(webDriver);
        Assert.assertFalse(submitPage.isSubmitPageLoad(), "Submit page URL is wrong");

     //   Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME",  "Login page URL is wrong");
    }



}

