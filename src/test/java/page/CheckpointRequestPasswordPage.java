package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class CheckpointRequestPasswordPage extends BasePage{

    @FindBy(xpath = "//header[@class='content__header']")
    private WebElement messageSentLink;


    public CheckpointRequestPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    public boolean isCheckpointRequestPasswordPageLoaded (){
        return webDriver.getCurrentUrl().contains("https://www.linkedin.com/checkpoint/rp/request-password-reset-submit")
               // && webDriver.getTitle().contains("Проверьте, получили ли вы сообщение эл. почты со ссылкой для изменения пароля. | LinkedIn)
                && messageSentLink.isDisplayed();
    }

    public ChooseNewPasswordPage navigateToLinkFromEmail (String resetPasswordLink) {
        resetPasswordLink = messageSentLink.getText();

        try {
            sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return new ChooseNewPasswordPage(webDriver);
    }


    public boolean isPageLoaded() {
        return false;
    }
}
