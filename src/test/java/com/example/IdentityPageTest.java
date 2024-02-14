package com.example;

//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IdentityPageTest extends BaseTest {
    /*
    @BeforeClass
    public void acceptCookies() {
        identityPage.openWebsite();
        try {
            identityPage.acceptCookies();
        } catch (Exception e) {
            System.out.println("No button \"Cookies\"");
        }
    }
    */
    
    // Verify successfully updated user's personal information
    // positive test
    @Test(priority = 1)
    public void updatedIdentityTest() {
        identityPage.openWebsite();
        identityPage.correctEmail(); // testqa@gmail.com
        identityPage.correctPassword(); // testqa6
        identityPage.clickOnSigninButton();
        identityPage.clickOnPersonalInfo();
        identityPage.clickRadioButtonGender(); // Mr.
        identityPage.selectDateOfBirth(); // 10, 09, 1992
        identityPage.validOldPswPersonalInfo(); // testqa6
        // identityPage.validNewPswPersonalInfo();
        // identityPage.validConfirmNewPswPersonalInfo();
        identityPage.clickNewsLetterCheckbox();
        identityPage.clicksubmitIdentity();
        identityPage.assertSuccessUpdated("successfully updated");
        identityPage.clickOnSignOutButton();
        identityPage.assertAll();
    }

    // Check the Log Out button functionality
    // positive test
    @Test(priority = 2)
    public void signOutIdentityTest() {
        identityPage.openWebsite();
        identityPage.correctEmail(); // testqa@gmail.com
        identityPage.correctPassword(); // testqa6
        identityPage.clickOnSigninButton();
        identityPage.clickOnPersonalInfo();
        identityPage.clickOnSignOutButton();
        //identityPage.assertSignOutAccount("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
        identityPage.assertSignOutAccount(
                "http://www.automationpractice.pl/index.php?controller=authentication&back=identity");
        identityPage.assertAll();
        ///////////////////////
        // identityPage.openWebsite();
        // identityPage.correctEmail();
        // identityPage.correctPassword();
        // identityPage.clickOnSigninButton();
        // identityPage.clickOnPersonalInfo();
        // identityPage.clickOnSignOutButton();
        // identityPage.correctEmail();
        // identityPage.correctPassword();
        // identityPage.clickOnSigninButton();
        ////identityPage.assertSignOutAccount("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
        // identityPage.assertSignOutRelogin("http://www.automationpractice.pl/index.php?controller=identity");
        // identityPage.clickOnSignOutButton();
        // identityPage.assertAll();
    }

    // negative test
    // Update with missing the Required Field (Current Password) and ensure it provides an error message
    @Test(priority = 3)
    public void blankOldPswIdentityTest() {
        identityPage.openWebsite();
        identityPage.correctEmail();
        identityPage.correctPassword();
        identityPage.clickOnSigninButton();
        identityPage.clickOnPersonalInfo();
        identityPage.clicksubmitIdentity(); // blank old psw
        identityPage.assertincorrectUpdatedPsw("password you entered is incorrect");
        identityPage.clickOnSignOutButton();
        identityPage.assertAll();
    }

    // negative test
    // Update with incorrect the Required Field (Current Password) and ensure it provides an error message
    @Test(priority = 4)
    public void inCorrectOldPswIdentityTest() {
        identityPage.openWebsite();
        identityPage.correctEmail();
        identityPage.correctPassword();
        identityPage.clickOnSigninButton();
        identityPage.clickOnPersonalInfo();
        identityPage.inCorrectOldPswPersonalInfo(); // conanedogawa
        identityPage.clicksubmitIdentity();
        identityPage.assertincorrectUpdatedPsw("password you entered is incorrect");
        identityPage.clickOnSignOutButton();
        identityPage.assertAll();
    }

    // negative test
    // Update to Create new password using non-matching new passwords and verify that it returns error message
    @Test(priority = 5)
    public void pswNotMatchIdentityTest() {
        identityPage.openWebsite();
        identityPage.correctEmail();
        identityPage.correctPassword();
        identityPage.clickOnSigninButton();
        identityPage.clickOnPersonalInfo();
        identityPage.validOldPswPersonalInfo(); // testqa6
        identityPage.validNewPswPersonalInfo(); // kagoromori
        identityPage.validConfirmNewPswPersonalInfo(); // hiroshi
        identityPage.clicksubmitIdentity();
        identityPage.assertPswAndConfirmDontMatch("The password and confirmation do not match.");
        identityPage.clickOnSignOutButton();
        identityPage.assertAll();
    }

    // positive test, edit personal info
    // @Test 
    // public void currentPswEditableTest() {
    //     identityPage.openWebsite();
    //     identityPage.correctEmail();
    //     identityPage.correctPassword();
    //     identityPage.clickOnSigninButton();
    //     identityPage.clickOnPersonalInfo();
    //     identityPage.assertCurrentPswEditable(); 
    //     identityPage.clickOnSignOutButton();
    //     identityPage.assertAll();
    // }
    
     
}
