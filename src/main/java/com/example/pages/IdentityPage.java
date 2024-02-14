package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;

public class IdentityPage extends BasePage {

    public IdentityPage(WebDriver driver) {
        super(driver);

    }
    
    private static class Locators {
        //private final static By cookies = By.id("ez-accept-all");
        private final static By emailField = By.id("email");
        private final static By passwordField = By.id("passwd");
        private final static By submitLogin = By.id("SubmitLogin");
        private final static By submittedLoginForm = By.cssSelector(".alert.alert-danger ol li");
        private final static By signOutButton = By.xpath("//a[@title='Log me out']");

        private final static By personalInfoItem = By.xpath("//a[@title='Information']");
        //private final static By mrRadioButton = By.xpath("//div[@class='radio-inline'][1]/label");
        private final static By mrRadioButton = By.id("uniform-id_gender1");

        private final static By firstNameField = By.id("firstname");
        private final static By lastNameField = By.id("lastname");
        private final static By personalInfoEmail = By.id("email");

        private final static By daysSelect = By.id("days");
        //private final static By daysSelectOption = By.xpath("//select[@id='days']/option[@value='10']");
        private final static By monthsSelect = By.id("months");
        //private final static By monthsSelectOption = By.xpath("//select[@id='months']/option[@value='9']");
        private final static By yearsSelect = By.id("years");
        //private final static By yearsSelectOption = By.xpath("//select[@id='years']/option[@value='1992']");

        private final static By oldPswField = By.id("old_passwd");
        private final static By pswFieldNew = By.id("passwd");
        private final static By confirmPswField = By.id("confirmation");

        private final static By checkboxNewsLetter = By.xpath("//div[@class='checkbox']/label");
        private final static By submitIdentityButton = By.xpath("//button[@name='submitIdentity']");
        private final static By updatedPersonalInfo = By.xpath("//div[@id='center_column']/div/p");

        private final static By incorrectUpdatedPsw = By.xpath("//div[@id='center_column']/div/div/ol/li");

        
    }

    private static class Strings {
        private final static String siteUrl = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
        //private final static String myAccountUrl = "http://www.automationpractice.pl/index.php?controller=my-account";
    }

    /*
    public void acceptCookies() {
        elements.click(Locators.cookies);
    }
    */

    public void openWebsite() {
        logger.info("Open authentication Page Url to test the user personal info page");
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
    ////////////
    public void validOldPswPersonalInfo() {
        elements.clearAndSendKeys(Locators.oldPswField, "testqa6");
    }

    public void inCorrectOldPswPersonalInfo() {
        elements.clearAndSendKeys(Locators.oldPswField, "conanedogawa");
    }

    public void validNewPswPersonalInfo() {
        elements.clearAndSendKeys(Locators.pswFieldNew, "kagoromori");
    }

    public void validConfirmNewPswPersonalInfo() {
        elements.clearAndSendKeys(Locators.confirmPswField, "hiroshi");
    }
    ///////////
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

    public void clearFirstName() {
        elements.clear(Locators.firstNameField);
    }

    public void clearLasttName() {
        elements.clear(Locators.lastNameField);
    }

    public void clearPersonalInfoEmail() {
        elements.clear(Locators.personalInfoEmail);
    }
    ///////////////

    public void clickOnSigninButton() {
        elements.click(Locators.submitLogin);
    }

    public void clickOnSignOutButton() {
        elements.click(Locators.signOutButton);
    }

    public void clickOnPersonalInfo() {
        elements.click(Locators.personalInfoItem);
    }

    public void clickRadioButtonGender() {
        elements.click(Locators.mrRadioButton);
    }

    public void clickNewsLetterCheckbox() {
        elements.click(Locators.checkboxNewsLetter);
    }

    public void clicksubmitIdentity() {
        elements.click(Locators.submitIdentityButton);
    }

    
    ////////////////
    public void selectDateOfBirth() {
        Select days = new Select(driver.findElement(Locators.daysSelect));
        days.selectByValue("10");
        logger.info("select day" + Locators.daysSelect);
        //waiters.waitForVisabilityOfWebElement(Locators.daysSelect);
        //waiters.waitForVisabilityOfWebElementAndReturnElement(Locators.daysSelectOption);
        Select months = new Select(driver.findElement(Locators.monthsSelect));
        months.selectByValue("9");
        logger.info("select month" + Locators.monthsSelect);
        //waiters.waitForVisabilityOfWebElement(Locators.monthsSelect);
        //waiters.waitForVisabilityOfWebElementAndReturnElement(Locators.monthsSelectOption);
        Select years = new Select(driver.findElement(Locators.yearsSelect));
        years.selectByValue("1992");
        logger.info("select year" + Locators.yearsSelect);
        //waiters.waitForVisabilityOfWebElement(Locators.yearsSelect);
        //waiters.waitForVisabilityOfWebElementAndReturnElement(Locators.yearsSelectOption);

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
    
    /////////////////////

    // public String actualUrl() {
    //     //logger.info("Get Current URL");
    //     return driver.getCurrentUrl();
    // }

    public void assertSignOutAccount(String expectedLoginUrl) {
        assertions.assertSignOut(driver.getCurrentUrl(), expectedLoginUrl);
        logger.info("Assertion executed, Successful SignOut, URL match");
    }

    public void assertSignOutRelogin(String expectedEqualsMyAccountUrl) {
        assertions.assertSignOutRelogin(driver.getCurrentUrl(), expectedEqualsMyAccountUrl);
        logger.info("Assertion executed, Successful SignOut, SignOutRelogin URL match");
    }
    ///////////////////

    public String actualSuccessUpdated() {
        return elements.getTextFromElement(Locators.updatedPersonalInfo);
    }

    public void assertSuccessUpdated(String expectedSuccessUpdatedContains) {
        assertions.verifySuccessUpdated(actualSuccessUpdated().contains(expectedSuccessUpdatedContains));
        logger.info("Assertion executed, personal info SuccessUpdated txt matches");
    }
    /////////////////
    public void assertCurrentPswEditable() {
        //logger.info("find CurrentPsw element: " + Locators.oldPswField);
        waiters.waitForVisabilityOfWebElement(Locators.oldPswField);
        assertions.verifyCurrentPswEditable(driver.findElement(Locators.oldPswField).isEnabled());
        logger.info("Assertion executed, Current Password is enabled");
    }
    ///////////////////
    public String actualIncorrectUpdatedPsw() {
        return elements.getTextFromElement(Locators.incorrectUpdatedPsw);
    }

    public void assertincorrectUpdatedPsw(String incorrectUpdatedPswContains) {
        assertions.verifyIncorrectUpdatedPsw(actualIncorrectUpdatedPsw().contains(incorrectUpdatedPswContains));
        logger.info("Assertion executed, personal info IncorrectUpdated Password txt matches");
    }

    public void assertPswAndConfirmDontMatch(String noMatchPswAndConfirm) {
        assertions.verifyPswAndConfirmDontMatch(actualIncorrectUpdatedPsw(), noMatchPswAndConfirm);
        logger.info("Assertion executed, personal info IncorrectUpdated PswAndConfirmation txt matches");
    }
    /////////////////
    public void assertAll() {
        assertions.softAssertAll();
    }
    //////////
    
}
