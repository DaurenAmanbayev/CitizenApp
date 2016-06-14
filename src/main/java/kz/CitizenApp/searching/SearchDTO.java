package kz.CitizenApp.searching;
//import org.apache.commons.*;
/**
 * Created by ktoloc on 14.06.2016.
 */
public class SearchDTO {
    private String searchTerm;

    private SearchType searchType;

    public SearchDTO() {

    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public SearchType getSearchType() {
        return searchType;
    }

    public void setSearchType(SearchType searchType) {
        this.searchType = searchType;
    }

    @Override
    public String toString() {
        return  "Object: SearchDTO";//ToStringBuilder.reflectionToString(this);
    }
}
