import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckpointPasswordChangePage {
    private WebDriver webDriver;


    @FindBy(xpath ="//button[@id='reset-password-submit-button']")
    private WebElement buttonGoToTheMainPage;


    public CheckpointPasswordChangePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isCheckpointResetPasswordPageLoaded(){
        return webDriver.getCurrentUrl().contains("https://www.linkedin.com/checkpoint/rp/password-reset-submit")
               // && webDriver.getTitle().contains("Вы изменили свой пароль. | LinkedIn")
                && buttonGoToTheMainPage.isDisplayed();
    }


    public HomePage backToHomePage(){
        buttonGoToTheMainPage.click();
        return new HomePage(webDriver);

    }

}
