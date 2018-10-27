import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

public class SubmitPage {


    private WebDriver webDriver;

    @FindBy(xpath = "//span[@class='error']")
    private WebElement errorInvalidPass;

    @FindBy(xpath = "//div[@error-for='username']")
    private WebElement errorEmail;

    @FindBy(xpath = "//span[@class='error']")
    private WebElement errorMinNumberForEmail;

    @FindBy(xpath = "//div[@class='alert error']")
    private WebElement genErrorMessage;


    public SubmitPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isSubmitPageLoad() {
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME")
                && webDriver.getTitle().equals("Войти в LinkedIn")
                && isGenErrorMessageDisplayed()
                && isMessageDisplayed();
    }

    public boolean isMessageDisplayed() {
        return errorInvalidPass.isDisplayed();
    }


    public boolean isErrorMessageDisplayed() {
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME")
                && webDriver.getTitle().equals("Войти в LinkedIn")
                && isGenErrorMessageDisplayed()
                && isErrorForMinNumberLoad();
    }


    public boolean isErrorForMinNumberLoad() {
        return errorMinNumberForEmail.isDisplayed();
    }


    public boolean isErrorInvalidEmail() {
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME")
                && webDriver.getTitle().equals("Войти в LinkedIn")
                && isGenErrorMessageDisplayed()
                && isErrorEmailDisplayed();
    }

    public boolean isErrorEmailDisplayed() {
        return errorEmail.isDisplayed();
    }

    public boolean isGenErrorMessageDisplayed(){
        return genErrorMessage.isDisplayed();
    }
}