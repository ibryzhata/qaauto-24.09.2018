import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LoginTest {

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
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com");
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/",
                "Home page URL is wrong.");

        WebElement userEmail = webDriver.findElement(By.xpath("//input[@id='login-email']"));
        userEmail.sendKeys("bryzhatan@gmail.com");
        userEmail.sendKeys(Keys.TAB);


        WebElement userPassword = webDriver.findElement(By.xpath("//input[@id='login-password']"));
        userPassword.sendKeys("Qwerty");
        userPassword.sendKeys(Keys.TAB);

        WebElement signInButton = webDriver.findElement(By.xpath("//input[@id='login-submit']"));
        signInButton.click();

        /*webDriver.get("https://www.linkedin.com/feed/");*/
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/feed/",  "Profile page is wrong");

        webDriver.quit();

    }
}
