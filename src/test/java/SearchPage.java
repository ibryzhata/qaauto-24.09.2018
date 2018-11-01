import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SearchPage {
    private WebDriver webDriver;


    @FindBy(xpath = "//div[@class='search-result__wrapper']")
    private List<WebElement> searchListResults;

    @FindBy(xpath = "//div[contain(@class, 'search-filters-bar')]")
    private  WebElement searchBar;

    @FindBy(xpath = "//li[contains(@class, 'search-result__occluded-item')]")
    private List<WebElement>  searchResultLists;

      /*  @FindBy(xpath = "//p[@class='subline-level-1 t-14 t-black t-normal search-result__truncate']/span[@dir='ltr']")
        private WebElement expectedTerm;*/


    public SearchPage (WebDriver webDriver){
    this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isSearchPageLoad () {
        return webDriver.getCurrentUrl().contains("/search/results/")
                && webDriver.getTitle().contains("| Поиск | LinkedIn")
                && searchBar.isDisplayed();
    }


    public int getCountSearchResult() {
        return searchListResults.size();
    }

    public List<String> getSearchListResults() {
        List<String> searchResultLists = new ArrayList<String>();
        for (WebElement searchResult : searchListResults) {
            ((JavascriptExecutor) webDriver)
                    .executeScript("arguments[0].scrollIntoView(true);", searchResult);

            String searchResultText =  searchResult.getText();
            searchResultLists.add(searchResult.getText());
        }
            return searchResultLists;
        }
    }


