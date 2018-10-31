import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {
    private WebDriver webDriver;


        @FindBy(xpath = "//div[@class='search-result__wrapper']")
        private List<WebElement> searchListResults;

        @FindBy(xpath = "//p[@class='subline-level-1 t-14 t-black t-normal search-result__truncate']/span[@dir='ltr']")
        private WebElement expectedTerm;




    public SearchPage (WebDriver webDriver){
    this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isSearchPageLoad () {
        return webDriver.getCurrentUrl().contains("https://www.linkedin.com/search/results/all/?keywords=HR&origin=GLOBAL_SEARCH_HEADER");
                //&& webDriver.getTitle().contains("\"HR\" | Поиск | LinkedIn");
    }


    public int getCountSearchResult() {
        return searchListResults.size();
    }

    public List<String> getSearchListResults() {

        List<String> searchResultLists = new ArrayList();

        for (WebElement searchResult : searchListResults) {

            System.out.println(searchResult.getText());
            searchResultLists.add(searchResult.getText());
        }
            return searchResultLists;
        }
    }


