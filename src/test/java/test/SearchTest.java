package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchPage;
import java.util.List;


public class SearchTest extends BaseTest {

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

        @Test
        public void basicSearchTest() {
            String searchTerm ="HR";

            Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");

            HomePage homePage=loginPage.login( "bryzhatan@gmail.com" , "Qwerty");

            Assert.assertTrue(homePage.isHomePageLoad(), "Home page is not loaded");


           SearchPage searchPage= homePage.search ("searchTerm");

           Assert.assertTrue(searchPage.isSearchPageLoad(), "Search page is not loaded");
           Assert.assertEquals(searchPage.getCountSearchResult(),10, "SearchResult count is wrong");



            List<String> searchResultLists =searchPage.getSearchListResults();
           for (String searchResult: searchResultLists){
               Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                       "SearchTerm" +searchTerm+ "not found in "+searchResult);
           }

           /*


            Assert.assertTrue(searchPage.getSearchListResults().get(0).contains(expectedTerm), "Search term is not found in results list");

        }*/

    }
}
