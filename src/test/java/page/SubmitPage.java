package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

public class SubmitPage extends BasePage {

    @FindBy(xpath = "//div[@error-for='username']")
    private WebElement emailValidationMessage;

    @FindBy(xpath = "//span[@class='error']")
    private WebElement passwordValidationMessage;

    @FindBy(xpath = "//span[@class='error']")
    private WebElement errorMinNumberForEmail;

    @FindBy(xpath = "//div[@class='alert error']")
    private WebElement alertErrorMessage;


    public SubmitPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isSubmitPageLoad() {
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME")
                && webDriver.getTitle().equals("Войти в LinkedIn")
                && isAlertErrorMessageDisplayed()
                && isMessageDisplayed();
    }

    public boolean isMessageDisplayed() {
        return emailValidationMessage.isDisplayed();
    }


    public boolean isErrorMessageDisplayed() {
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME")
                && webDriver.getTitle().equals("Войти в LinkedIn")
                && isAlertErrorMessageDisplayed()
                && isErrorForMinNumberLoad();
    }


    public boolean isErrorForMinNumberLoad() {
        return errorMinNumberForEmail.isDisplayed();
    }


   /* public boolean isErrorInvalidEmail() {
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME")
                && webDriver.getTitle().equals("Войти в LinkedIn")
                && isAlertErrorMessageDisplayed()
                && isErrorEmailDisplayed();*/


    public boolean isErrorEmailDisplayed() {
        return emailValidationMessage.isDisplayed();
    }

    public boolean isAlertErrorMessageDisplayed(){
        return alertErrorMessage.isDisplayed();
    }

    public String getAlertMessageText() {
        return alertErrorMessage.getText();
    }

    public String getEmailValidationMessage() {
        return emailValidationMessage.getText();

    }

    public String getPasswordValidationMessage() {
        return passwordValidationMessage.getText();
    }

    public boolean isPageLoaded() {
        return false;
    }
}