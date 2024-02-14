package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage extends BasePage {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    private static class Locators {
        //private final static By cookies = By.id("ez-accept-all");
        private final static By emailCreateField = By.id("email_create");
        private final static By submitCreate = By.id("SubmitCreate");
        private final static By submittedReg = By.xpath("//div[@id='create_account_error']/ol/li");
        private final static By accountCreationForm = By.id("account-creation_form");
    }

    private static class Strings {
        private final static String siteUrl = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";

    }

    /*
    public void acceptCookies() {
        elements.click(Locators.cookies);
    }
    */

    public void openWebsite() {
        logger.info("Open authentication Page Url to test create account form");
        driver.get(Strings.siteUrl);
    }

    public void emailPreExistReg() {
        elements.clearAndSendKeys(Locators.emailCreateField, "testqa@gmail.com");
    }

    public void validEmailCreate() {
        elements.clearAndSendKeys(Locators.emailCreateField, "pikachu@gmail.com");
    }

    public void validEmailCreate2() {
        elements.clearAndSendKeys(Locators.emailCreateField, "krillin@gmail.com");
    }

    public void invalidEmailCreate() {
        elements.clearAndSendKeys(Locators.emailCreateField, "Abc.yoda.com"); // no @ symbol
        // @example.com - the local part is missing
        // name@.com - email domain name is missing
        // name@example - top level domain (.com) is missing
    }

    public void clearMailSendEnter() {
        elements.clearAndSendKeys(Locators.emailCreateField, Keys.ENTER);
    }

    public void enterKeyReg() {
        elements.sendKeys(Locators.emailCreateField, Keys.ENTER);
    }

    public void clearMailReg() {
        elements.clear(Locators.emailCreateField);
    }

    public void clickOnCreateAnAccount() {
        elements.click(Locators.submitCreate);
    }

    ////////////////

    public String actualSubmittedReg() {
        return elements.getTextFromElement(Locators.submittedReg);
    }

    public void assertEqualsSubmittedReg(String expectedEqualsSubmittedReg) {
        assertions.equalsSubmittedReg(actualSubmittedReg(), expectedEqualsSubmittedReg);
        logger.info("Assertion executed, Submitted Reg error contains txt match");
    }

    public void assertTrueSubmittedReg(String expectedContainsSubmittedReg) {
        assertions.verifySubmittedReg(actualSubmittedReg().contains(expectedContainsSubmittedReg));
        logger.info("Assertion executed, Submitted Reg error contains txt match");
    }

    public void assertTruePreExistEmailReg(String expectedContainsSubmittedReg) {
        assertions.verifyPreExistEmailReg(actualSubmittedReg().contains(expectedContainsSubmittedReg));
        logger.info("Assertion executed, Submitted Reg Pre-Exist Email error contains txt match");
    }

    public void assertRegMailBlank(String expectedSubmittedReg) {
        assertions.assertRegMailFieldBlank(actualSubmittedReg(), expectedSubmittedReg);
        logger.info("Assertion executed, createAccountMailFieldBlank Submitted error txt match");
    }

    //////////////////
    public String actualBorderInputMailReg() {
        //logger.info("Border InputMailReg getCssValue border: " + Locators.emailCreateField);
        return driver.findElement(Locators.emailCreateField).getCssValue("border");
    }

    public void assertBorderInputMailReg(String expectedBorderInputMailReg) {
        assertions.borderInputMailReg(actualBorderInputMailReg(), expectedBorderInputMailReg);
        logger.info("Assertion executed, Border InputMailReg error is matched");
    }
    ////////////////////
    public void createAccountIsEnabled() {
        //logger.info("find Create an account button element: " + Locators.submitCreate);
        waiters.waitForVisabilityOfWebElement(Locators.submitCreate);
        assertions.assertCreateAccount(driver.findElement(Locators.submitCreate).isEnabled());
        logger.info("Assertion executed, createAccount Button is isEnabled");
    }
    /////////////////////
    public void assertAccountCreationForm() {
        //logger.info("find AccountCreationForm element: " + Locators.accountCreationForm);
        waiters.waitForVisabilityOfWebElement(Locators.accountCreationForm);
        assertions.verifyAccountCreationForm(driver.findElement(Locators.accountCreationForm).isDisplayed());
        logger.info("Assertion executed, AccountCreationForm is Displayed");
    }
    //////////////////////

    public String actualTitle() {
        //logger.info("Get Title");
        return driver.getTitle();
    }

    public void assertRegTitle(String equalsTitle) {
        assertions.createAccountTitle(actualTitle(), equalsTitle);
        logger.info("Assertion executed, Title equals, Reg form opens");
    }

    public void assertRegTitleChanged(String falseTitleChangedIgnoreCase) {
        assertions.createAccountTitleIsChanged(actualTitle().equalsIgnoreCase(falseTitleChangedIgnoreCase));
        logger.info("Assertion executed, title IgnoreCase not changed, Reg form opens");
    }
    /////////
    public String actualUrl() {
        //logger.info("Get Url");
        return driver.getCurrentUrl();
    }

    public void assertRegUrl(String equalsUrl) {
        assertions.createAccountUrl(actualUrl(), equalsUrl);
        logger.info("Assertion executed, createAccount URL match, Reg form opens");
    }
    ////////////
    public void assertAll() {
        assertions.softAssertAll();
    }
    //////////////////////



    
}
