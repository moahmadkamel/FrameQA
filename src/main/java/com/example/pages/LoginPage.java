package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    private static class Locators {
        //private final static By cookies = By.id("ez-accept-all");
        private final static By emailField = By.id("email");
        private final static By passwordField = By.id("passwd");
        private final static By submitLogin = By.id("SubmitLogin");
        private final static By forgotPassword = By.cssSelector(".lost_password.form-group a");
        private final static By submittedLoginForm = By.cssSelector(".alert.alert-danger ol li");
        private final static By signOutButton = By.xpath("//a[@title='Log me out']");
    }

    private static class Strings {
        private final static String siteUrl = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
        //private final static String forgotPasswordUrl = "http://www.automationpractice.pl/index.php?controller=password";
        //private final static String myAccountUrl = "http://www.automationpractice.pl/index.php?controller=my-account";
    }

    /*
    public void acceptCookies() {
        elements.click(Locators.cookies);
    }
    */

    public void openWebsite() {
        logger.info("Open authentication Page Url to test the signin form");
        driver.get(Strings.siteUrl);
    }

    public void correctEmail() {
        elements.clearAndSendKeys(Locators.emailField, "testqa@gmail.com");
    }

    public void correctPassword() {
        elements.clearAndSendKeys(Locators.passwordField, "testqa6");
    }

    public void incorrectEmail() {
        elements.clearAndSendKeys(Locators.emailField, "grogu@gmail.com");
    }

    public void incorrectPassword() {
        elements.clearAndSendKeys(Locators.passwordField, "9876543");
    }

    public void clearEmailSignin() {
        elements.clear(Locators.emailField);
    }

    public void clearPasswordSignin() {
        elements.clear(Locators.passwordField);
    }

    public void clearMailSendEnter() {
        elements.clearAndSendKeys(Locators.emailField, Keys.ENTER);
    }

    public void clearPswSendEnter() {
        elements.clearAndSendKeys(Locators.passwordField, Keys.ENTER);
    }

    public void enterKeySigninMail() {
        elements.sendKeys(Locators.emailField, Keys.ENTER);
    }

    public void enterKeySigninPsw() {
        elements.sendKeys(Locators.passwordField, Keys.ENTER);
    }
    
    ///////////////

    public void clickOnSigninButton() {
        elements.click(Locators.submitLogin);
    }

    public void clickOnForgotPassword() {
        elements.click(Locators.forgotPassword);
    }

    public void clickOnSignOutButton() {
        elements.click(Locators.signOutButton);
    }

    /////////////////////////
    public String actualSubmittedSignin() {
        return elements.getTextFromElement(Locators.submittedLoginForm);
    }

    public void inexactMailAndPsw(String expectedSubmittedSignin) {
        assertions.assertInexactMailAndPsw(actualSubmittedSignin(), expectedSubmittedSignin);
        logger.info("Assertion executed, InexactMailAndPsw SubmittedSignin error txt match");
    }

    public void exactMailInexactPsw(String expectedSubmittedSignin) {
        assertions.assertExactMailInexactPsw(actualSubmittedSignin(), expectedSubmittedSignin);
        logger.info("Assertion executed, ExactMailInexactPsw SubmittedSignin error txt match");
    }

    public void inexactMailExactPsw(String expectedSubmittedSignin) {
        assertions.assertInexactMailExactPsw(actualSubmittedSignin(), expectedSubmittedSignin);
        logger.info("Assertion executed, InexactMailExactPsw SubmittedSignin error txt match");
    }

    public void signinFieldsBlank(String expectedSubmittedSignin) {
        assertions.assertSigninFieldsBlank(actualSubmittedSignin(), expectedSubmittedSignin);
        logger.info("Assertion executed, SigninFieldsBlank SubmittedSignin error txt match");
    }

    public void incorrectMailAndPsw(String expectedSubmittedSigninContains) {
        assertions.assertIncorrectMailAndPsw(actualSubmittedSignin().contains(expectedSubmittedSigninContains));
        logger.info("Assertion executed, IncorrectMailAndPsw SubmittedSignin error contains txt match");
    }

    public void correctMailIncorrectPsw(String expectedSubmittedSigninContains) {
        assertions.assertCorrectMailIncorrectPsw(actualSubmittedSignin().contains(expectedSubmittedSigninContains));
        logger.info("Assertion executed, CorrectMailIncorrectPsw SubmittedSignin error contains txt match");
    }

    public void incorrectMailCorrectPsw(String expectedSubmittedSigninContains) {
        assertions.assertIncorrectMailCorrectPsw(actualSubmittedSignin().contains(expectedSubmittedSigninContains));
        logger.info("Assertion executed, IncorrectMailCorrectPsw SubmittedSignin error contains txt match");
    }
    //////////////////////////
    
    public String actualForgotPswUrl() {
        //logger.info("Get forgotyourpassword url");
        return driver.getCurrentUrl();
    }

    public void assertEqualsForgotPasswordUrl(String expectedEqualsForgotPasswordUrl) {
        assertions.equalsForgotPswUrl(actualForgotPswUrl(), expectedEqualsForgotPasswordUrl);
        logger.info("Assertion executed, Expected Forgotyourpassword URL match");
    }

    public String actualForgotPswTitle() {
        //logger.info("Get forgotyourpassword Title");
        return driver.getTitle();
    }

    public void assertEqualsForgotPasswordTitle(String expectedEqualsForgotPasswordTitle) {
        assertions.equalsForgotPswTitle(actualForgotPswTitle(), expectedEqualsForgotPasswordTitle);
        logger.info("Assertion executed, Forgotyourpassword Title match");
    }

    ////////////////

    public String actualTitle() {
        //logger.info("Get Title");
        return driver.getTitle();
    }
    
    public void assertEqualsMyAccountTitle(String expectedEqualsMyAccountTitle) {
        assertions.equalsMyAccountTitle(actualTitle(), expectedEqualsMyAccountTitle);
        logger.info("Assertion executed, Successful login Title match");
    }
    ///////////
    public String actualUrl() {
        //logger.info("Get Current URL");
        return driver.getCurrentUrl();
    }

    public void assertEqualsMyAccountUrl(String expectedEqualsMyAccountUrl) {
        assertions.equalsMyAccountUrl(actualUrl(), expectedEqualsMyAccountUrl);
        logger.info("Assertion executed, Successful login, URL match");
    }
    /////////////////////


    ///////////////////
    public void assertAll() {
        assertions.softAssertAll();
    }
    //////////

}
