import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubmitPage {
    private WebDriver webDriver;
    private WebElement errorMinNumberForEmail;
    private WebElement errorInvalidPass;

    public SubmitPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        initElements();
    }

    public boolean isSubmitPageLoad() {
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME")
                && webDriver.getTitle().equals("Войти в LinkedIn")
                && isMessageDisplayed();
    }
    public boolean isMessageDisplayed () {
        return errorInvalidPass.isDisplayed();
    }


    public boolean isErrorMessageDisplayed () {
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME")
                && webDriver.getTitle().equals("Войти в LinkedIn")
                && isErrorForMinNumberLoad();
    }


    public boolean isErrorForMinNumberLoad() {
        return errorMinNumberForEmail.isDisplayed();
    }


    private void initElements() {
        errorInvalidPass = webDriver.findElement(By.xpath("//span[@class='error']"));
        errorMinNumberForEmail = webDriver.findElement(By.xpath("//span[@class='error']"));

    }
}