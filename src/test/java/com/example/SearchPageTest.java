package com.example;

//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchPageTest extends BaseTest {
    /*
    @BeforeClass
    public void acceptCookies(){
        searchPage.openWebsite();
        try {
            searchPage.acceptCookies();
        }catch (Exception e){
            System.out.println("No button \"Cookies\"");
        }
    }
    */

    //////////////

    // "related product information (name, price, img) included in the search results"
    // positive test
    @Test(priority = 1)
    public void specsProductDisplayTest() {
        searchPage.openWebsite();
        searchPage.validItemSearch1(); // Faded Short
        searchPage.clickOnSearchIcon();
        // searchPage.enterKeyBoard();
        searchPage.assertResultNameItem(true);
        searchPage.assertResultPriceItem(true);
        searchPage.assertResultImgItem(true);
        searchPage.assertAll();
    }

    // Test the display of direct & related products alongside search results.
    // positive test
    @Test(priority = 2)
    public void matchAndRelatedProductsTest() {
        searchPage.openWebsite();
        searchPage.validItemSearch2(); // Printed Chiffon Dress
        searchPage.clickOnSearchIcon();
        // searchPage.enterKeyBoard();
        searchPage.assertMatchAndRelatedProductItem1();
        searchPage.assertMatchAndRelatedProductItem2();
        // searchPage.assertMatchAndRelatedProducts();
        searchPage.assertAll();
    }

    // Enter a query for a specific category and verify that only relevant products are displayed.
    // positive test
    @Test(priority = 3)
    public void searchByCategoryTest() {
        searchPage.openWebsite();
        searchPage.validInputByCategory(); // T-shirts
        searchPage.clickOnSearchIcon();
        // searchPage.enterKeyBoard();
        searchPage.assertSearchResultCategory();

        searchPage.assertAll();
    }

    // consist of common stopwords(and,the,a,or,of,on,this,we,were,is,not,..)
    // "Test queries with stop words (e,g., ""the"") and verify they are handled correctly
    // negative test
    @Test(priority = 4)
    public void consistStopWordsTest() {
        searchPage.openWebsite();
        searchPage.stopWordsThe(); // the faded short, faded a short,faded short and
        searchPage.clickOnSearchIcon();
        // searchPage.enterKeyBoard();
        searchPage.assertStopWordsInput();

        searchPage.assertAll();
    }

    // Enter an empty search query and ensure it provides an appropriate warning message
    // negative test
    @Test(priority = 5)
    public void emptySearchResultsTest() {
        searchPage.openWebsite();
        //searchPage.clickOnSearchIcon();
        //searchPage.enterKeyBoard();
        searchPage.clearSearchSendEnter();
        searchPage.assertResultBlank("Please enter a search keyword");

        searchPage.assertAll();
    }

    // Search for a product that doesn't exist in the database and verify that it returns no results
    // negative test
    @Test(priority = 6)
    public void productNoExistSearchTest() {
        searchPage.openWebsite();
        searchPage.validItemNotFound(); // coat
        // searchPage.clickOnSearchIcon();
        searchPage.enterKeyBoard();
        searchPage.assertNotFoundItem("No results were found");

        searchPage.assertAll();
    }







    // verify if the search is case-sensitive or not
    // add unnecessary spaces at the beginning or end
    // queries with synonyms
    // (boolean search:and,or,not)
    // queries with hyphens and special characters
    // queries with numeric values
    // queries with diacritics and accented characters
    // wildcard characters (* or ?) in queries
    // queries with common misspellings and assess auto-correction
    // queries in different languages
    // geographic or location-based keywords
    // ambiguous queries and assess the accuracy of suggested alternatives
    // Test sorting options (e.g., price low to high) and validate correct order
    // Check if the number of results matches the displayed count
    // Test the display of product images for all search results
    // Verify that product names and descriptions match the query
    // Test the accuracy of displayed product prices
    // Check if product ratings and reviews are correctly associated with search results.
    // a query for a specific brand and verify that only relevant products are displayed
    // Test the "Quick View" feature to ensure it opens the correct product details
    // Verify that product availability (in stock/out of stock) matches the search results
    // Test the display of related products or suggestions alongside search results
    // Check if sponsored or promoted products are clearly labeled
    // Test the behavior when a user clicks on a search result link
    // Verify that search results can be easily added to a shopping cart or wish list
    // Check if search suggestions and auto-corrections
    // Test the usability of filters and sorting options in refining search results
    // the effectiveness of the "Search As You Type" feature in providing relevant suggestions
    // Verify that the search feature offers clear navigation to refine or expand search queries
    // the effectiveness of product recommendations integrated with search results.
    //
    //
    
}
