package PolovniAutomobiliPOM;

import org.openqa.selenium.By;

import java.io.IOException;

public class LoginPage {

    private MainMethods mainMethods;
    public LoginPage(MainMethods mainMethods){
        this.mainMethods = mainMethods;
    }
    public void clickRegister(){
        mainMethods.clickOn(By.xpath("//a[.='Registruj se']"));
    }
    public void enterEmail(){
        mainMethods.type(By.id("username_header"), mainMethods.getemail());
    }
    public void clickNextStep(){
        mainMethods.clickOn(By.id("next-step"));
    }
    public void enterPassword() throws IOException {
        mainMethods.type(By.id("password_header"), mainMethods.getProperty("password"));
    }
    public void clickLogin(){
        mainMethods.clickOn(By.name("login"));
    }


}
