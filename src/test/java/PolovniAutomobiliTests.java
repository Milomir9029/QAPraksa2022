import PolovniAutomobiliPOM.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.io.IOException;
public class PolovniAutomobiliTests {
    private MainMethods mainMethods;
    private HomePage homePage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private ProfileSettingsPage profileSettingsPage;
    private DetailedSearchPage detailedSearchPage;
    private WebDriver driver;
    @BeforeTest
    public void setUp() {
        System.setProperty("web-driver.chrome.driver", "C:\\IdeaProjects\\chromedriver.exe");
    }
    @BeforeMethod
    void openWebsite() {
        driver = new ChromeDriver();
        mainMethods = new MainMethods(driver);
        homePage = new HomePage(mainMethods);
        loginPage = new LoginPage(mainMethods);
        registerPage = new RegisterPage(mainMethods);
        profileSettingsPage = new ProfileSettingsPage(mainMethods);
        detailedSearchPage = new DetailedSearchPage(mainMethods);

        driver.manage().window().maximize();
        driver.get("https://www.polovniautomobili.com/");
    }
    @Test
    public void RegisterVerifyLoginLogout() throws IOException {
        homePage.clickPost();
        loginPage.clickRegister();

        registerPage.typeEmail();
        registerPage.typePassword();
        registerPage.RepeatPassword();
        registerPage.clickToS();
        registerPage.clickEasySaleConsent();
        registerPage.clickEasyBuyConsent();
        registerPage.clickRegister();

        mainMethods.protonVerification();
        mainMethods.switchTabs(1);

        profileSettingsPage.checkReviewingOffer();
        profileSettingsPage.submitSurvey();
        profileSettingsPage.clickOkay();

        profileSettingsPage.enterName();
        profileSettingsPage.enterSurname();
        profileSettingsPage.enterAdress();
        profileSettingsPage.enterCity();
        profileSettingsPage.chooseRegion();
        profileSettingsPage.enterCellphone();
        profileSettingsPage.clickSubmit();
        profileSettingsPage.checkSuccessMessage();
        profileSettingsPage.hoverLogout();
        profileSettingsPage.clickLogout();

        homePage.clickLogin();
        loginPage.enterEmail();
        loginPage.clickNextStep();
        loginPage.enterPassword();
        loginPage.clickLogin();
        homePage.verifyEmail();

        mainMethods.switchTabs(2);
        mainMethods.deleteEmail();
    }

    @Test
    public void vehicleSearch()  {
        homePage.scrollToDetailedSearch();
        homePage.clickDetailedSearch();

        detailedSearchPage.popUpCheckAndClose();

        detailedSearchPage.chooseCarMake();
        detailedSearchPage.chooseModel();
        detailedSearchPage.setPriceFrom();
        detailedSearchPage.setPriceTo();
        detailedSearchPage.chooseBodyStyle();
        detailedSearchPage.chooseFuelType();
        detailedSearchPage.chooseRegion();
        detailedSearchPage.setYearFrom();
        detailedSearchPage.setYearTo();
        detailedSearchPage.setDoorNumber();
        detailedSearchPage.clickSearch();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
