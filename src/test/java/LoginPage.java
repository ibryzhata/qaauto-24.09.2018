import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

   private WebDriver webDriver;

   @FindBy(xpath ="//input[@id='login-email']")
   private   WebElement userEmailField ;

   @FindBy(xpath = "//input[@id='login-password']")
   private WebElement userPasswordField ;

   @FindBy(xpath = "//input[@id='login-submit']")
   private   WebElement signInButton ;

    public LoginPage(WebDriver webDriver) {
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver, this);
    }


    public boolean isPageLoaded () {

    return webDriver.getCurrentUrl().equals("https://www.linkedin.com/")
            && webDriver.getTitle().equals("LinkedIn: Log In or Sign Up")
            && isSignInButtonDisplayed();
    }
    public boolean isSignInButtonDisplayed (){
       return signInButton.isDisplayed();
    }


    public HomePage login (String userEmail, String userPassword){
        userEmailField.sendKeys(userEmail);
        /*userEmailField.sendKeys(Keys.TAB);*/
        userPasswordField.sendKeys(userPassword);
        /* userPasswordField.sendKeys(Keys.TAB);*/
        signInButton.click();
        return new HomePage(webDriver);
    }

}
