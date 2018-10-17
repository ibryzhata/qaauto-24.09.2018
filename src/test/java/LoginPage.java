import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver webDriver;
    WebElement userEmailField ;
    WebElement userPasswordField ;
    WebElement signInButton ;

    public LoginPage(WebDriver webDriver) {
        this.webDriver=webDriver;
        initElements();
    }

    public void initElements () {
        userEmailField = webDriver.findElement(By.xpath("//input[@id='login-email']"));
        userPasswordField = webDriver.findElement(By.xpath("//input[@id='login-password']"));
        signInButton = webDriver.findElement(By.xpath("//input[@id='login-submit']"));

    }

    public void login (String userEmail, String userPassword){
        userEmailField.sendKeys(userEmail);
        /*userEmailField.sendKeys(Keys.TAB);*/
        userPasswordField.sendKeys(userPassword);
        /* userPasswordField.sendKeys(Keys.TAB);*/
        signInButton.click();
    }

}
