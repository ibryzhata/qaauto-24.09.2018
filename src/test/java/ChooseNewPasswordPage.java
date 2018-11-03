import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class ChooseNewPasswordPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement buttonSendNewPassword;

    @FindBy(xpath = "//input[@id='newPassword']")
    private WebElement newPasswordField;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement confirmPasswordField;


    public ChooseNewPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    public boolean isChooseNewPasswordPageLoaded (){
        return webDriver.getCurrentUrl().contains("/checkpoint/rp/password-reset?requestSubmissionId")
                && buttonSendNewPassword.isDisplayed();
    }

    public CheckpointPasswordChangePage enterNewPassword(String newPassword, String confirmPassword){
        newPasswordField.sendKeys(newPassword);
        confirmPasswordField.sendKeys(confirmPassword);
        buttonSendNewPassword.sendKeys(Keys.RETURN);
        try {
            sleep (3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      return new CheckpointPasswordChangePage(webDriver);
    }


}