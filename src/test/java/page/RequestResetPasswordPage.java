package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

import static java.lang.Thread.sleep;

public class RequestResetPasswordPage extends BasePage {
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
        String messageSubject = "данное сообщение содержит ссылку для изменения пароля";
        String messageTo = "bryzhatan@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";


        GMailService gMailService = new GMailService();
        gMailService.connect();


        inputUserEmail.sendKeys(userEmail);
        buttonFindAccount.click();


        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 180);
        System.out.println("Content: " + message);

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CheckpointRequestPasswordPage (webDriver);

    }

    public boolean isPageLoaded() {
        return false;
    }
}
