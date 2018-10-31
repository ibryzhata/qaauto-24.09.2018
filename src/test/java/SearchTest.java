import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class SearchTest {

        WebDriver webDriver;
        LoginPage loginPage;

        @BeforeMethod
        public void beforeMethod() {
            webDriver = new FirefoxDriver();
            webDriver.get("https://www.linkedin.com");
            loginPage = new LoginPage(webDriver);

        }

        @AfterMethod
        public void afterMethod() {
            webDriver.quit();
        }


        /**
         * PreConditions:
         * - Open new Browser.
         * - navigate to linkedin.com.
         * <p>
         * Scenario:
         * <p>
         * - Verify that login page is loaded.
         * - Login with valid credentials.
         * - Verify that Home page is loaded
         * - Enter 'SearchTerm' into search field and PRESS key.
         * - Verify that Search page is loaded.
         * - Verify 10 searchResults displayed on page.
         * - Verify each result item contains 'SearchTerm'
         * <p>
         * PostConditions:
         * - Close Browser.
         */


        @DataProvider
        public Object[][] searchTerm() {
            return new Object[][]{
                    {"HR", "HR"}
            };
        }

        @Test (dataProvider = "searchTerm")
        public void basicSearchTest(String searchTerm, String expectedTerm) {
            Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");

            HomePage homePage=loginPage.login( "bryzhatan@gmail.com" , "Qwerty");

            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Assert.assertTrue(homePage.isHomePageLoad(), "Home page is not loaded");
            SearchPage searchPage = homePage.search(searchTerm);

            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Assert.assertTrue(searchPage.isSearchPageLoad(), "Search page is not loaded");
            Assert.assertEquals(searchPage.getCountSearchResult(),10, "Actual result is wrong");
            Assert.assertTrue(searchPage.getSearchListResults().get(0).contains(expectedTerm), "Search term is not found in results list");

        }

    }
