package com.example;

//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateAccountPageTest extends BaseTest {

    /*
    @BeforeClass
    public void acceptCookies(){
        createAccountPage.openWebsite();
        try {
            createAccountPage.acceptCookies();
        }catch (Exception e){
            System.out.println("No button \"Cookies\"");
        }
    }
    */

    // validate registration during ( smoke testing )

    // Verify CreatAnAccount button is enabled after valid data is entered
    // gui testing
    // positive test case
    @Test(priority = 1)
    public void createAccountButtonTest() {
        createAccountPage.openWebsite();
        createAccountPage.validEmailCreate(); // pikachu@gmail.com
        createAccountPage.createAccountIsEnabled();
        createAccountPage.assertAll();
    }

    // Verify access page "CreateAnAccount" with valid Email, to register personal info

    // positive test case
    @Test(priority = 2)
    public void openCreateAccountFormTest() {
        createAccountPage.openWebsite();
        createAccountPage.validEmailCreate(); // pikachu@gmail.com
        // createAccountPage.clickOnCreateAnAccount();
        createAccountPage.enterKeyReg();
        createAccountPage.assertAccountCreationForm();
        createAccountPage.assertAll();
        // createAccountPage.assertRegTitleChanged("Create Account - My Shop");
        // createAccountPage.assertRegTitle("Login - My Shop");
        // createAccountPage.assertRegUrl("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
    }

    // CreatAnAccount with an invalid Email and verify that it returns error message
    // negative testing
    @Test(priority = 3)
    public void invalidMailCreateAccountTest() {
        createAccountPage.openWebsite();
        createAccountPage.invalidEmailCreate(); // Abc.yoda.com - no @ symbol
        // createAccountPage.clickOnCreateAnAccount();
        createAccountPage.enterKeyReg();
        // createAccountPage.assertTrueSubmittedReg("Invalid email");
        createAccountPage.assertEqualsSubmittedReg("Invalid email address.");
        createAccountPage.assertAll();
    }

    // CreateAnAccount with a blank Email field and ensure it provides an error message
    // negative testing
    @Test(priority = 4)
    public void invalidBlankCreateAccountTest() {
        createAccountPage.openWebsite();
        // createAccountPage.clearMailReg();
        createAccountPage.clearMailSendEnter();
        // createAccountPage.clickOnCreateAnAccount();
        createAccountPage.assertRegMailBlank("Invalid email address.");
        createAccountPage.assertAll();
    }

    // CreateAnAccount with a pre-existing email and verify that it returns error message
    // negative testing
    @Test(priority = 5)
    public void mailPreExistCreateAccountTest() {
        createAccountPage.openWebsite();
        createAccountPage.emailPreExistReg(); // testqa@gmail.com
        // createAccountPage.clickOnCreateAnAccount();
        createAccountPage.enterKeyReg();
        createAccountPage.assertTruePreExistEmailReg("email address has already been registered");
        createAccountPage.assertAll();
    }

    // @Test
    // public void borderInputMailCreateAccountTest() {
    // createAccountPage.openWebsite();
    // createAccountPage.invalidEmailCreate();
    // //createAccountPage.emailPreExistReg();
    // createAccountPage.clickOnCreateAnAccount();
    // createAccountPage.assertBorderInputMailReg("1px solid rgb(241, 51, 64)");
    // }
}
