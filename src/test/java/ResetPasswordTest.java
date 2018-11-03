import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.holdsLock;
import static java.lang.Thread.sleep;

public class ResetPasswordTest {
    WebDriver webDriver;
    LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com");
        loginPage = new LoginPage(webDriver);

    }

    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }


    @Test
    public void ResetPasswordTest(){
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");

        RequestResetPasswordPage requestResetPasswordPage = loginPage.clickLinkForgotPassword();
        Assert.assertTrue(requestResetPasswordPage.isRequestResetPasswordPageLoaded(),
                "Request Reset Password Page is not loaded");

        CheckpointRequestPasswordPage checkpointRequestPasswordPage = requestResetPasswordPage.searchAccount("bryzhatan@gmail.com");
        Assert.assertTrue(checkpointRequestPasswordPage.isCheckpointRequestPasswordPageLoaded(),
                "CheckpointPage is not loaded");

        ChooseNewPasswordPage chooseNewPasswordPage = checkpointRequestPasswordPage.navigateToLinkFromEmail("");
        Assert.assertTrue(chooseNewPasswordPage.isChooseNewPasswordPageLoaded());

        CheckpointPasswordChangePage checkpointPasswordChangePage=chooseNewPasswordPage.enterNewPassword("1qazXSW@", "1qazXSW@");
        Assert.assertTrue(checkpointPasswordChangePage.isCheckpointResetPasswordPageLoaded());

        HomePage homePage = checkpointPasswordChangePage.backToHomePage();
        Assert.assertTrue(homePage.isHomePageLoad());

    }

}
