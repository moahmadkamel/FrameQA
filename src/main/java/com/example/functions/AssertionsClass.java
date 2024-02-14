package com.example.functions;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class AssertionsClass {
    private final WebDriver driver;
    private final ElementsClass elementsClass;
    private final WaitersClass waiters;
    private final ActionClass action;

    public AssertionsClass(WebDriver driver) {
        this.driver = driver;
        elementsClass = new ElementsClass(driver);
        waiters = new WaitersClass(driver);
        action = new ActionClass(driver);
    }

    SoftAssert softAssert = new SoftAssert();

    public void equalsOfInts(int actual, int expected) {
        Assert.assertEquals(actual, expected, "I expected to get " + expected + ", but found " + actual);
    }

    public void assertInexactMailAndPsw(String actual, String expected) {
        softAssert.assertEquals(actual, expected,"InexactMailAndPsw SubmittedSignin error-msg");
    }
    
    public void assertExactMailInexactPsw(String actual, String expected) {
        softAssert.assertEquals(actual, expected,"ExactMailInexactPsw SubmittedSignin error-msg");
    }

    public void assertInexactMailExactPsw(String actual, String expected) {
        softAssert.assertEquals(actual, expected,"InexactMailExactPsw SubmittedSignin error-msg");
    }

    public void assertIncorrectMailAndPsw(boolean condition) {
        softAssert.assertTrue(condition,
                "IncorrectMailAndPsw SubmittedSignin error doesn't contains 'Authentication failed'");
    }
    
    public void assertCorrectMailIncorrectPsw(boolean condition) {
        softAssert.assertTrue(condition,
                "CorrectMailIncorrectPsw SubmittedSignin error doesn't contains 'Authentication failed'");
    }

    public void assertIncorrectMailCorrectPsw(boolean condition) {
        softAssert.assertTrue(condition,
                "IncorrectMailCorrectPsw SubmittedSignin error doesn't contains 'Authentication failed'");
    }

    public void assertSigninFieldsBlank(String actual, String expected) {
        softAssert.assertEquals(actual, expected, "SigninFieldsBlank SubmittedSignin error-msg");
    }
    //////////////////
    public void equalsForgotPswUrl(String actual, String expected) {
        softAssert.assertEquals(actual, expected, "Forgotyourpassword, page URL doesnt match");
    }

    public void equalsForgotPswTitle(String actual, String expected) {
        softAssert.assertEquals(actual, expected, "Forgotyourpassword page Title doesnt match");
    }
    /////////////////////////
    public void equalsMyAccountUrl(String actual, String expected) {
        softAssert.assertEquals(actual, expected, "Login MyAccount, page URL doesnt match");
    }

    public void equalsMyAccountTitle(String actual, String expected) {
        softAssert.assertEquals(actual, expected, "Login MyAccount, page Title doesnt match");
    }

    public void assertSignOutRelogin(String actual, String expected) {
        softAssert.assertEquals(actual, expected, "SignOutRelogin URL not match");
    }

    public void assertSignOut(String actual, String expected) {
        softAssert.assertEquals(actual, expected, "Signout URL not match");
    }
    /////////////////////////////////////
    public void createAccountTitle(String actual, String expected) {
        softAssert.assertEquals(actual, expected, "assert open Reg form, CreateAccount Title doesnt match");
    }

    public void verifyAccountCreationForm(boolean condition) {
        softAssert.assertTrue(condition, "AccountCreationForm isnt displayed");
    }

    public void createAccountTitleIsChanged(boolean condition) {
        softAssert.assertFalse(condition, "assert open Reg form, CreateAccount Title IgnoreCase isnt changed");
    }

    public void createAccountUrl(String actual, String expected) {
        softAssert.assertEquals(actual, expected, "assert open Reg form, createAccount URL doesnt match");
    }
    ////////////////////////////////////
    public void assertCreateAccount(boolean condition) {
        softAssert.assertTrue(condition, "I expected CreateAccount Button must be isEnabled");
    }
    /////////////////////////

    public void equalsSubmittedReg(String actual, String expected) {
        softAssert.assertEquals(actual, expected, "Submitted Reg error");
    }

    public void verifySubmittedReg(boolean condition) {
        softAssert.assertTrue(condition, "I expected SubmittedReg error contains 'Invalid email'");
    }

    public void assertRegMailFieldBlank(String actual, String expected) {
        softAssert.assertEquals(actual, expected, "createAccountMailFieldBlank SubmittedReg error-msg");
    }

    public void verifyPreExistEmailReg(boolean condition) {
        softAssert.assertTrue(condition,
                "I Expected SubmittedReg Pre-Exist Email error contains 'email address has already been registered'");
    }

    public void borderInputMailReg(String actual, String expected) {
        Assert.assertEquals(actual, expected, "Border InputMailReg is mismatched");
    }
    ////////////////////////////////////////

    public void searchResultBlank(boolean condition) {
        softAssert.assertTrue(condition, "SearchResult Blank warning doesn't contains the matched text");
    }
    
    public void searchResultNotFoundItem(boolean condition) {
        softAssert.assertTrue(condition, "SearchResult NotFoundItem warninig doesn't contains the matched text");
    }

    public void searchResultNameItem(boolean actual, boolean expected) {
        softAssert.assertEquals(actual, expected, "Item rich snippet Name isnt displayed in search result");
    }

    public void searchResultPriceItem(boolean actual, boolean expected) {
        softAssert.assertEquals(actual, expected, "Item rich snippet Price isnt displayed in search result");
    }

    public void searchResultImgItem(boolean actual, boolean expected) {
        softAssert.assertEquals(actual, expected, "Item rich snippet Img isnt displayed in search result");
    }

    public void verifyMatchAndRelatedProductItem1(boolean condition) {
        softAssert.assertTrue(condition, "matchAndRelatedProduct item1 isnt displayed in search result");
    }

    public void verifyMatchAndRelatedProductItem2(boolean condition) {
        softAssert.assertTrue(condition, "matchAndRelatedProduct item2 isnt displayed in search result");
    }

    public void verifySearchResultByCategory(boolean condition) {
        softAssert.assertTrue(condition, "results from a corresponding T-shirts category item1 not displayed");
    }

    public void verifyStopWordsInput(boolean condition) {
        softAssert.assertTrue(condition, "search query consist of StopWords 'the' incorrectly handled");
    }

    ///////////////////

    public void verifySuccessUpdated(boolean condition) {
        softAssert.assertTrue(condition, "personal info SuccessUpdated txt doesn't matches");
    }
    
    public void verifyCurrentPswEditable(boolean condition) {
        softAssert.assertTrue(condition, "Current Password in personal info isn't enabled");
    }

    public void verifyIncorrectUpdatedPsw(boolean condition) {
        softAssert.assertTrue(condition, "personal info verifyIncorrectUpdated Password txt doesn't matches");
    }

    public void verifyPswAndConfirmDontMatch(String actual, String expected) {
        softAssert.assertEquals(actual, expected, "personal info IncorrectUpdated PswAndConfirmation txt doesn't matches");
    }

    ////////////////////
    public void softAssertAll() {
        softAssert.assertAll();
    }


}
