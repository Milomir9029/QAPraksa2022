package PolovniAutomobiliPOM;

import methods.MainMethods;
import methods.PropertyFile;
import org.openqa.selenium.By;

import java.io.IOException;

public class RegisterPage {

    private MainMethods mainMethods;
    public RegisterPage(MainMethods mainMethods){
        this.mainMethods = mainMethods;
    }

    public void typeEmail() throws IOException {
        mainMethods.type(By.id("email"), mainMethods.generateEmail());
    }
    private PropertyFile property = new PropertyFile();
    public void typePassword() throws IOException {
        mainMethods.type(By.id("password_first"), property.getProperty("password"));
    }
    public void RepeatPassword() throws IOException {
        mainMethods.type(By.id("password_second"), property.getProperty("password"));
    }
    public void clickToS(){
        mainMethods.clickOn(By.id("tos"));
    }
    public void clickEasySaleConsent(){
        mainMethods.clickOn(By.id("easySaleConsent"));
    }
    public void clickEasyBuyConsent(){
        mainMethods.clickOn(By.id("easyBuyConsent"));
    }
    public void clickRegister(){
        mainMethods.clickOn(By.xpath("//button[.='Registruj se']"));
    }


}
