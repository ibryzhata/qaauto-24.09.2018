package test;


import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;


public class ResetPasswordTest extends BaseTest {

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
        Assert.assertTrue(chooseNewPasswordPage.isChooseNewPasswordPageLoaded(),
                "page.ChooseNewPasswordPage is not loaded");

        CheckpointPasswordChangePage checkpointPasswordChangePage=chooseNewPasswordPage.enterNewPassword("1qazXSW@",
                "1qazXSW@");
        Assert.assertTrue(checkpointPasswordChangePage.isCheckpointResetPasswordPageLoaded(),
                "CheckpointResetPasswordPage is not loaded");

        HomePage homePage = checkpointPasswordChangePage.backToHomePage();
        Assert.assertTrue(homePage.isHomePageLoad(),
                "page.HomePage is not loaded");

    }

}
