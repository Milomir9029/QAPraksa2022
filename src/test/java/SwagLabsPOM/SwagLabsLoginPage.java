package SwagLabsPOM;

import methods.MainMethods;
import methods.PropertyFile;
import org.openqa.selenium.By;

import java.io.IOException;

public class SwagLabsLoginPage {
    PropertyFile property = new PropertyFile();
    private MainMethods mainMethods;
    public SwagLabsLoginPage(MainMethods mainMethods){
        this.mainMethods = mainMethods;
    }
    public void typeUsername() throws IOException {
        mainMethods.type(By.cssSelector("#user-name"), property.getProperty("SwagLabsUsername"));
    }
    public void typePassword() throws IOException {
        mainMethods.type(By.cssSelector("#password"), property.getProperty("SwagLabsPassword"));
    }
    public void clickLogin(){
        mainMethods.clickOn(By.cssSelector("#login-button"));
    }




}
