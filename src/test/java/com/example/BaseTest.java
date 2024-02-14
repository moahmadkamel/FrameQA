
package com.example;
import com.example.driverFactory.DriverSetUp;
import com.example.functions.ActionClass;
import com.example.functions.AssertionsClass;
import com.example.functions.ElementsClass;
import com.example.functions.WaitersClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import com.example.pages.AutoPage;
import com.example.pages.BasePage;
import com.example.pages.ClickerPage;
import com.example.pages.LoginPage;
import com.example.pages.ProductCatalogPage;
import com.example.pages.CreateAccountPage;
import com.example.pages.SearchPage;
import com.example.pages.ShoppingCartPage;
import com.example.pages.IdentityPage;
import com.example.utils.TestResultListeners;

@Listeners(TestResultListeners.class)
public class BaseTest {

    protected WebDriver driver = DriverSetUp.startChromeDriver();

    protected ActionClass action = new ActionClass(driver);
    protected AssertionsClass assertions = new AssertionsClass(driver);
    protected ElementsClass elements = new ElementsClass(driver);
    protected WaitersClass waiters = new WaitersClass(driver);

    protected BasePage basePage = new BasePage(driver);
    protected ClickerPage clickerPage = new ClickerPage(driver);
    protected AutoPage autoPage = new AutoPage(driver);
    protected SearchPage searchPage = new SearchPage(driver);
    protected LoginPage loginPage = new LoginPage(driver);
    protected CreateAccountPage createAccountPage = new CreateAccountPage(driver);
    protected ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    protected ProductCatalogPage productCatalogPage = new ProductCatalogPage(driver);
    protected IdentityPage identityPage = new IdentityPage(driver);

    @BeforeSuite
    public void startDriver() {
        driver = DriverSetUp.startChromeDriver();
    }

    @AfterSuite
    public void closeDriver() {
        driver.quit();
    }
}
