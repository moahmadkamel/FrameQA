
package com.example;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//import com.example.pages.BasePage;

public class ClickerPageTest extends BaseTest {

    @BeforeClass
    public void acceptCookies(){
        clickerPage.openWebsite();
        try {
            clickerPage.acceptCookies();
        }catch (Exception e){
            System.out.println("No button \"Cookies\"");
        }

    }

    @Test
    public void clickOnPlusButtonAndCheckResultField(){
        clickerPage.openWebsite();
        int countOfClicks = 5;
        clickerPage.switchToClickButtonsFrame();
        clickerPage.clickOnPlusButton(countOfClicks);
        clickerPage.assertCountOfClicks(8);
    }

    @Test
    public void clickOnPlusButtonAndCheckResultField2(){
        clickerPage.openWebsite();
        int countOfClicks = 5;
        clickerPage.switchToClickButtonsFrame();
        clickerPage.clickOnPlusButton(countOfClicks);
        clickerPage.assertCountOfClicks(countOfClicks);
    }
}
