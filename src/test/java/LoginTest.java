import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                {"bryzhatan@gmail.com" , "Qwerty"},
                {"Bryzhatan@gmail.com", "Qwerty"},
                {" bryzhatan@gmail.com ", "Qwerty"}
        };
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
    @Test (dataProvider = "validDataProvider")
    public void successfulLoginTest(String userEmail, String userPassword) {

        webDriver.get("https://www.linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");

        HomePage homePage=loginPage.login(userEmail, userPassword);

        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(homePage.isHomePageLoad(), "Home page is not loaded");
    }

    @Test
    public void negativeLoginWithEmptyPasswordTest () {
        webDriver.get("https://www.linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");

        loginPage = loginPage.login("a@b.c", "");

       Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/",
                "Login page URL is wrong");
    }

    @Test

    public void negativeTestInvalidPassword () {
        webDriver.get("https://www.linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");
        SubmitPage submitPage=loginPage.login("bryzhatan@gmail.com", "qwerty");
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(submitPage.isSubmitPageLoad(), "Submit page URL is wrong");
    }
    @Test

    public void TestMinNumberOfCharEmailField () {
        webDriver.get("https://www.linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");
        SubmitPage submitPage=loginPage.login("s", "Qwerty");
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Assert.assertTrue(submitPage.isErrorMessageDisplayed(), "Submit page URL is wrong");
        }

    }

    @Test

    public void negativeTestInvalidEmail () {
        webDriver.get("https://www.linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");
        SubmitPage submitPage=loginPage.login("bryzhatan@gmail1.com", "Qwerty");
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();

            Assert.assertTrue(submitPage.isCheckpointPageLoad(), "Checkpoint Page is wrong");
        }
    }


}