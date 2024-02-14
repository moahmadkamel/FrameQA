package com.example;

//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    /*
    @BeforeClass
    public void acceptCookies(){
        loginPage.openWebsite();
        try {
            loginPage.acceptCookies();
        }catch (Exception e){
            System.out.println("No button \"Cookies\"");
        }
    }
    */

    // validate logging data during ( smoke testing )

    // Verify signin with valid credentials
    // positive test case
    @Test(priority = 1)
    public void correctLoginTest() {
        loginPage.openWebsite();
        loginPage.correctEmail(); // testqa@gmail.com
        loginPage.correctPassword(); // testqa6
        loginPage.clickOnSigninButton();
        // loginPage.assertEqualsMyAccountTitle("My account - My Shop");
        loginPage.assertEqualsMyAccountUrl("http://www.automationpractice.pl/index.php?controller=my-account");
        loginPage.clickOnSignOutButton();
        loginPage.assertAll();
    }

    // Test the "Forgot Password" link functionality
    // positive test case
    @Test(priority = 2)
    public void forgotPasswordTest() {
        loginPage.openWebsite();
        loginPage.clickOnForgotPassword();
        // loginPage.assertEqualsForgotPasswordTitle("Forgot your password - My Shop");
        loginPage.assertEqualsForgotPasswordUrl("http://www.automationpractice.pl/index.php?controller=password");
        loginPage.assertAll();
    }

    // Log in with both Email and Password incorrect and ensure it provides an error message
    //negative test case
    @Test(priority = 3)
    public void incorrectMailAndPswLoginTest() {
        loginPage.openWebsite();
        loginPage.incorrectEmail(); // grogu@gmail.com
        loginPage.incorrectPassword(); // 9876543
        loginPage.clickOnSigninButton();
        loginPage.incorrectMailAndPsw("Authentication failed");
        //loginPage.inexactMailAndPsw("Authentication failed.");
        loginPage.assertAll();
    }

    // Log in with an incorrect Password and verify that it returns error message
    // negative test case
    @Test(priority = 4)
    public void correctMailIncorrectPswLoginTest() {
        loginPage.openWebsite();
        loginPage.correctEmail(); // testqa@gmail.com
        loginPage.incorrectPassword(); // 9876543
        loginPage.clickOnSigninButton();
        loginPage.correctMailIncorrectPsw("Authentication failed");
        // loginPage.exactMailInexactPsw("Authentication failed.");
        loginPage.assertAll();

    }

    // Log in with incorrect Email and ensure it provides an error message
    // negative test case
    @Test(priority = 5)
    public void incorrectMailCorrectPswLoginTest() {
        loginPage.openWebsite();
        loginPage.incorrectEmail(); // grogu@gmail.com
        loginPage.correctPassword(); // testqa6
        loginPage.clickOnSigninButton();
        loginPage.incorrectMailCorrectPsw("Authentication failed");
        // loginPage.inexactMailExactPsw("Authentication failed.");
        loginPage.assertAll();
    }

    // Test login with a blank Email and Password fields and verify that it returns error message
    // negative test case 
    @Test(priority = 6)
    public void signinFieldsBlankLoginTest() {
        loginPage.openWebsite();
        loginPage.clearEmailSignin();
        loginPage.clearPasswordSignin();
        loginPage.clickOnSigninButton();
        loginPage.signinFieldsBlank("An email address required.");
        loginPage.assertAll();
    }
    
}
