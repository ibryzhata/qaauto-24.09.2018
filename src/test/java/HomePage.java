import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;

import static java.lang.Thread.sleep;

public class HomePage {
   private WebDriver webDriver;

   @FindBy(xpath = "//li[@id='profile-nav-item']")
   private WebElement profileNavItem;

    @FindBy(xpath = "//input[contains(@aria-owns, 'result')]")
    private WebElement searchField;

   /* @FindBy(xpath = "//form[@class='nav-search']")
    private WebElement searchButton;*/

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isHomePageLoad () {
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/feed/")
                && webDriver.getTitle().contains("LinkedIn")
             && isProfileNavItemDisplayed();
    }
   public boolean  isProfileNavItemDisplayed () {
        return profileNavItem.isDisplayed();
    }


    public SearchPage search (String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        try {
            sleep (3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new  SearchPage (webDriver);
    }


    }



