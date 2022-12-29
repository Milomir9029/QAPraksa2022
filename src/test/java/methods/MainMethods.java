package methods;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

public class MainMethods {
    private final WebDriver driver;
    public MainMethods(WebDriver driver){
        this.driver = driver;
    }
    public void type(By locator, String text) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(locator));
        element.clear();
        element.sendKeys(text);
    }
    public void clickOn(By locator){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void checkPresence(By locator){
        Assert.assertTrue(new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(locator)).isDisplayed());
    }

    public void hoverOver(By locator){
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
    public void scrollTo(By locator){
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        Dimension screenSize = driver.manage().window().getSize();
        int scrollDistance = screenSize.getHeight() / 3;
        for (int i = 0; i < scrollDistance; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
        }
    }
    public String getElementText(By locator){
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
        return element.getText();
    }
    private PropertyFile property = new PropertyFile();


    public void protonVerification() throws IOException {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://mail.proton.me/");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("username"))).sendKeys(property.getProperty("email") + "@protonmail.com");
        driver.findElement(By.id("password")).sendKeys(property.getProperty("password"));
        driver.findElement(By.xpath("//button[.='Sign in']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Aktivirajte Vaš nalog']"))).click();
        WebElement iframe = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-subject='Aktivirajte Vaš nalog']")));
        driver.switchTo().frame(iframe);
        WebElement link = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'aktivacija-naloga')]")));
        try {
            link.click();
            driver.switchTo().defaultContent();
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Confirm']"))).click();
        } catch (Exception ignored) {
            driver.switchTo().frame(iframe);
            link.click();
            driver.switchTo().defaultContent();
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Confirm']"))).click();
        }
    }
    public void switchTabs(int tabnum){
        Set<String> handles = driver.getWindowHandles();
        List<String> handleList = new ArrayList<>(handles);
        driver.switchTo().window(handleList.get(handleList.size() - tabnum));
    }

    private String email;


    public String generateEmail() throws IOException {
        Random rnd = new Random();
        email = property.getProperty("email") + "+"
                + String.format("%06d", rnd.nextInt(999999))
                + "@protonmail.com";
        return email;
    }
    public String getemail(){
        return email;
    }


    public void deleteEmail(){
        driver.findElement(By.cssSelector("[data-testid='toolbar:movetotrash']")).click();
        driver.findElement(By.cssSelector("[title='More']")).click();
        driver.findElement(By.cssSelector("[data-testid='navigation-link:trash']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='message-column:sender-address']")));
        driver.findElement(By.cssSelector("[data-testid='toolbar:select-all-checkbox']")).click();
        driver.findElement(By.cssSelector("[data-testid='toolbar:deletepermanently']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='permanent-delete-modal:submit']"))).click();
    }
    public void popupCheck(String elementID){
        try{
            WebElement popupElement = driver.findElement(By.id(elementID));
            if (popupElement.isDisplayed())
                popupElement.click();

        } catch (NoSuchElementException ignored){
        }
    }




}
