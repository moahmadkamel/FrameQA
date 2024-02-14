package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private static class Locators {
        //private final static By cookies = By.id("ez-accept-all");
        private final static By searchField = By.id("search_query_top");
        private final static By searchButton = By.name("submit_search");
        private final static By searchResult = By.xpath("//div[@id='center_column']/p");

        private final static By nameProduct1 = By.xpath("//div[@id='center_column']/ul/li[1]/div/div[2]/h5/a"); //Faded Short
        private final static By priceProduct1 = By.xpath("//div[@id='center_column']/ul/li[1]/div/div[2]/div[1]/span");
        private final static By imgProduct1 = By.xpath("//div[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img");

        //private final static By nameProduct2 = By.xpath("//div[@id='center_column']/ul/li[1]/div/div[2]/h5/a"); //Printed Chiffon Dress

        private final static By product2Item1 = By.xpath("//div[@id='center_column']/ul/li[1]"); //Printed Chiffon Dress
        private final static By product2Item2 = By.xpath("//div[@id='center_column']/ul/li[2]/div"); //Printed Summer Dress

        private final static By categoryItem1 = By.xpath("//div[@id='center_column']/ul/li/div");

        //private final static By cart = By.xpath("//a[@title='View my shopping cart']");
        //private final static By addItemToCart = By.xpath("//button[@name='Submit']");
        //private final static By buttonContinue = By.xpath("//span[@title='Continue shopping']");   
        //private final static By navItem1 = By.xpath("//a[@title='Women'][1]");    

    }

    private static class Strings {
        private final static String siteUrl = "http://www.automationpractice.pl/index.php";
    }

    // private static class Data {
    //     private static final String inputForSearch1 = "Printed Chiffon Dress";
    //     private static final String inputForSearch2 = "Faded Short";
    // }

    /*
    public void acceptCookies() {
        elements.click(Locators.cookies);
    }
    */

    public void openWebsite() {
        logger.info("Open Home Page to test the search bar");
        driver.get(Strings.siteUrl);
    }

    public void validItemSearch1() {
        elements.clearAndSendKeys(Locators.searchField, "Faded Short");
    }

    public void validItemSearch2() {
        elements.clearAndSendKeys(Locators.searchField, "Printed Chiffon Dress");
    }

    public void validInputByCategory() {
        elements.clearAndSendKeys(Locators.searchField, "T-shirts");
    }

    public void validItemNotFound() {
        elements.clearAndSendKeys(Locators.searchField, "coat");
    }

    public void validCaseSensitiveInput() {
        elements.clearAndSendKeys(Locators.searchField, "fAdEd sHoRt");
    }

    public void addSpacesInput() {
        elements.clearAndSendKeys(Locators.searchField, "   Faded    Short   ");
    }

    public void stopWordsThe() {
        elements.clearAndSendKeys(Locators.searchField, "the faded short");
    }
    
    public void stopWordsA() {
        elements.clearAndSendKeys(Locators.searchField, "faded a short");
    }
    
    public void stopWordsAnd() {
        elements.clearAndSendKeys(Locators.searchField, "faded short and");
    }

    public void clearSearchSendEnter() {
        elements.clearAndSendKeys(Locators.searchField, Keys.ENTER);
    }

    public void enterKeyBoard() {
        elements.sendKeys(Locators.searchField, Keys.ENTER);
    }

    public void clearsearchField() {
        elements.clear(Locators.searchField);
    }

    public void clickOnSearchIcon() {
        elements.click(Locators.searchButton);
    }

    /////////////////////

    public String actualsearchResult() {
        return elements.getTextFromElement(Locators.searchResult);
    }

    public void assertResultBlank(String expectedResultBlankContains) {
        assertions.searchResultBlank(actualsearchResult().contains(expectedResultBlankContains));
        logger.info("Assertion executed, ResultBlank warninig contains txt match");
    }

    public void assertNotFoundItem(String expectedNotFoundItemContains) {
        assertions.searchResultNotFoundItem(actualsearchResult().contains(expectedNotFoundItemContains));
        logger.info("Assertion executed, SearchResult NotFoundItem warninig contains txt match");
    }
    ////////////////////////

    public void assertResultNameItem(boolean expectedItemNameDisplayed) {
        waiters.waitForVisabilityOfWebElement(Locators.nameProduct1);
        assertions.searchResultNameItem(driver.findElement(Locators.nameProduct1).isDisplayed(),
                expectedItemNameDisplayed);
        logger.info("Assertion executed, item rich snippet Name is displayed in search result");
    }

    public void assertResultPriceItem(boolean expectedItemPriceDisplayed) {
        waiters.waitForVisabilityOfWebElement(Locators.priceProduct1);
        assertions.searchResultPriceItem(driver.findElement(Locators.priceProduct1).isDisplayed(),
                expectedItemPriceDisplayed);
        logger.info("Assertion executed, item rich snippet Price is displayed in search result");
    }

    public void assertResultImgItem(boolean expectedItemImgDisplayed) {
        waiters.waitForVisabilityOfWebElement(Locators.imgProduct1);
        assertions.searchResultImgItem(driver.findElement(Locators.imgProduct1).isDisplayed(),
                expectedItemImgDisplayed);
        logger.info("Assertion executed, item rich snippet Img is displayed in search result");
    }

    ///////////////////

    public void assertMatchAndRelatedProductItem1() {
        waiters.waitForVisabilityOfWebElement(Locators.product2Item1);
        assertions.verifyMatchAndRelatedProductItem1(driver.findElement(Locators.product2Item1).isDisplayed());
        logger.info("Assertion executed, matchAndRelatedProduct item1 is displayed in search result");
    }

    public void assertMatchAndRelatedProductItem2() {
        waiters.waitForVisabilityOfWebElement(Locators.product2Item2);
        assertions.verifyMatchAndRelatedProductItem2(driver.findElement(Locators.product2Item2).isDisplayed());
        logger.info("Assertion executed, matchAndRelatedProduct item2 is displayed in search result");
    }

    // public void assertMatchAndRelatedProducts() {
    //     waiters.waitForVisabilityOfWebElement(Locators.product2Item1);
    //     assertions.verifyMatchAndRelatedProductItem1(driver.findElement(Locators.product2Item1).isDisplayed());
    //     logger.info("Assertion executed, matchAndRelatedProduct item1 is displayed in search result");
    //     waiters.waitForVisabilityOfWebElement(Locators.product2Item2);
    //     assertions.verifyMatchAndRelatedProductItem2(driver.findElement(Locators.product2Item2).isDisplayed());
    //     logger.info("Assertion executed, matchAndRelatedProduct item2 is displayed in search result");
    // }

    /////////////////////
    public void assertSearchResultCategory() {
        waiters.waitForVisabilityOfWebElement(Locators.categoryItem1);
        assertions.verifySearchResultByCategory(driver.findElement(Locators.categoryItem1).isDisplayed());
        logger.info("Assertion executed, results from a corresponding T-shirts category item1 are displayed");
    }
    ////////////////////
    public void assertStopWordsInput() {
        waiters.waitForVisabilityOfWebElement(Locators.categoryItem1);
        assertions.verifyStopWordsInput(driver.findElement(Locators.categoryItem1).isDisplayed());
        logger.info("Assertion executed, search query consist of StopWords 'the' correctly handled");
    }

    //////////////////
    public void assertAll() {
        assertions.softAssertAll();
    }
    //////////

}
