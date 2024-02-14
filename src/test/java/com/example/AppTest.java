package com.example;

import org.openqa.selenium.WebDriver;

import com.example.driverFactory.DriverSetUp;

// import static org.junit.Assert.assertTrue;

// import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    //     @Test
    //     public void shouldAnswerWithTrue()
    //     {
    //         assertTrue( true );
    //     }
    @org.testng.annotations.Test
    public void test() {
        WebDriver driver = DriverSetUp.startChromeDriver();
        driver.get("https://guinnessworldrecords.com/search");
    }    

}
