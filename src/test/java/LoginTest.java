import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    /**
     * Preconditions:
     * -Open FF browser;
     *
     * Scenario:
     * -Navigate to https://www.linkedin.com;
     * -Verify that login page is loaded;
     * - Enter userEmail in to UserEmail field;
     * - Enter userPassword in to userPassword;
     * - Click on signIn button;
     * - Verify that Home page is load
     *
     *
     * PostCondition:
     * -Close FF browser.
     */
    @Test
    public void  successfulLoginTest () {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com");
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/",
                "Home page URL is wrong.");

        webDriver.quit();

    }
}
