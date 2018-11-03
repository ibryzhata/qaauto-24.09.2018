import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class RequestResetPasswordPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement buttonFindAccount;

    @FindBy(xpath = "//input[@name='userName']")
    private WebElement inputUserEmail;



    public RequestResetPasswordPage (WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isRequestResetPasswordPageLoaded(){
        return webDriver.getCurrentUrl().contains("/request-password-reset?trk=uno-reg-guest-home-forgot-password")
             //   && webDriver.getTitle().contains("Изменить пароль | LinkedIn")
                        && buttonFindAccount.isDisplayed();
    }


    public CheckpointRequestPasswordPage searchAccount(String userEmail){
        inputUserEmail.sendKeys(userEmail);
        buttonFindAccount.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CheckpointRequestPasswordPage (webDriver);

    }
}
