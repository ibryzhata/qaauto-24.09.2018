package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

public class RequestResetPasswordPage extends BasePage {

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement buttonFindAccount;

    @FindBy(xpath = "//input[@name='userName']")
    private WebElement inputUserEmail;

    String linkForReset;




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
        GMailService gMailService = new GMailService();
        gMailService.connect();

        inputUserEmail.sendKeys(userEmail);
        buttonFindAccount.click();

        String messageSubject = "данное сообщение содержит ссылку для изменения пароля";
        String messageTo = "bryzhatan@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";
        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 180);
        System.out.println("Content: " + message);

        linkForReset = StringUtils.substringBetween(message, "Чтобы изменить пароль в LinkedIn, нажмите <a href=\"",
                "\" style").replace("amp;","");
        System.out.println(linkForReset);
        //webDriver.get(linkForReset);

        return PageFactory.initElements(webDriver,CheckpointRequestPasswordPage.class);
    }

    public ChooseNewPasswordPage navigateToLinkFromEmail(){
        webDriver.get(linkForReset);
        return PageFactory.initElements(webDriver,ChooseNewPasswordPage.class);
    }


    public boolean isPageLoaded() {
        return false;
    }
}
