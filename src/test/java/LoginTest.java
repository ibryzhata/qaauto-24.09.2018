import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


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

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/",
                "Home page URL is wrong.");
        loginPage.login("bryzhatan@gmail.com", "Qwerty");

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/feed/",  "Login page URL is wrong");

    }

    @Test
    public void negativeLoginTest () {
        webDriver.get("https://www.linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/",
                "Home page URL is wrong.");

        loginPage.login("a@b.c", "");

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/",  "Login page URL is wrong");


    }

    @Test

    public void negativeTestInvalidPassword () {
        webDriver.get("https://www.linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/",
                "Home page URL is wrong.");
        loginPage.login("bryzhatan@gmail.com", "qwerty");

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME",  "Login page URL is wrong");
    }

}

