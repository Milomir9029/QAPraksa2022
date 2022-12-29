package PolovniAutomobiliPOM;

import methods.MainMethods;
import org.openqa.selenium.By;

public class HomePage {
    private MainMethods mainMethods;
    public HomePage(MainMethods mainMethods){
        this.mainMethods = mainMethods;
    }
    public void clickPost(){
        mainMethods.clickOn(By.cssSelector("[data-label='Postavi oglas']"));
    }
    public void clickLogin(){
        mainMethods.clickOn(By.xpath("//a[@href='/login']/parent::div/parent::*"));
    }
    public void verifyEmail(){
        org.testng.Assert.assertEquals(mainMethods.
                getElementText(By.cssSelector(".ym-hide-content")), mainMethods.getemail());
    }
    public void scrollToDetailedSearch(){
        mainMethods.scrollTo(By.name("isDetailed"));
    }
    public void clickDetailedSearch(){
        try{
            mainMethods.clickOn(By.name("isDetailed"));
        } catch (Exception ignored){
            mainMethods.clickOn(By.name("isDetailed"));
        }
    }



}
