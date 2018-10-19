import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubmitPage {
    private WebDriver webDriver;
    private WebElement errorMessage;

    public SubmitPage (WebDriver webDriver) {
        this.webDriver = webDriver;

        initElements();
    }

    public boolean isSubmitPageLoad () {
    return webDriver.getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME")
            && webDriver.getTitle().equals("Войти в LinkedIn")
            && isErrorMessageDisplayed();
    }

    public boolean isErrorMessageDisplayed () {
        return errorMessage.isDisplayed();
    }
    private void initElements () {

        errorMessage = webDriver.findElement(By.xpath("//div[@id='error-for-password']"));
    }
}