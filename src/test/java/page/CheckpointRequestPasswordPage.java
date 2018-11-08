package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

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
        && messageSentLink.isDisplayed();
    }



    public boolean isPageLoaded() {
        return false;
    }
}
