import SwagLabsPOM.*;
import methods.MainMethods;
import methods.SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class SwaglabsTests {
    private MainMethods mainMethods;
    private SwagLabsLoginPage loginPage;
    private SwagLabsInventoryPage inventoryPage;
    private SwagLabsItemPage itemPage;
    private SwagLabsCartPage cartPage;
    private SwagLabsCheckoutPageOne checkoutPageOne;
    private SwagLabsCheckoutPageTwo checkoutPageTwo;
    private SwagLabsCheckoutCompletePage checkoutCompletePage;
    private WebDriver driver;

    @BeforeTest
    public void setUp() throws IOException {
        SetUp setUp = new SetUp();
        setUp.setProperty();
    }
        @BeforeMethod
        void openWebsite(){
        driver = new ChromeDriver();
        mainMethods = new MainMethods(driver);
        loginPage = new SwagLabsLoginPage(mainMethods);
        inventoryPage = new SwagLabsInventoryPage(mainMethods);
        itemPage = new SwagLabsItemPage(mainMethods);
        cartPage = new SwagLabsCartPage(mainMethods);
        checkoutPageOne = new SwagLabsCheckoutPageOne(mainMethods);
        checkoutPageTwo = new SwagLabsCheckoutPageTwo(mainMethods);
        checkoutCompletePage = new SwagLabsCheckoutCompletePage(mainMethods);
            driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void loginVerifyUi() throws IOException {
        loginPage.typeUsername();
        loginPage.typePassword();
        loginPage.clickLogin();

        inventoryPage.verifyProductsHeader();
        inventoryPage.verifyCartPresence();
        inventoryPage.verifyBurgerMenuPresence();
        inventoryPage.verifyTwitterLinkPresence();
        inventoryPage.verifyFBLinkPresence();
        inventoryPage.verifyLinkedInLinkPresence();
        inventoryPage.clickBurgerMenu();
        inventoryPage.clickLogOut();
    }
    @Test
    public void loginAddtoCartCheckout() throws IOException {
        loginPage.typeUsername();
        loginPage.typePassword();
        loginPage.clickLogin();

        inventoryPage.selectItem();

        itemPage.verifyTitle();
        itemPage.verifyDescription();
        itemPage.verifyPrice();
        itemPage.clickDddToCart();
        itemPage.clickOpenCart();

        cartPage.clickCheckout();

        checkoutPageOne.typeName();
        checkoutPageOne.typeSurname();
        checkoutPageOne.typePostalCode();
        checkoutPageOne.clickContinue();

        checkoutPageTwo.clickFInish();

        checkoutCompletePage.verifyThankYouHeader();
        checkoutCompletePage.clickBurgerMenu();
        checkoutCompletePage.clickLogOut();
    }




    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}


