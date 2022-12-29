package PolovniAutomobiliPOM;

import methods.MainMethods;
import org.openqa.selenium.By;

public class ProfileSettingsPage {

    private MainMethods mainMethods;
    public ProfileSettingsPage(MainMethods mainMethods){
        this.mainMethods = mainMethods;
    }
    public void checkReviewingOffer(){
        mainMethods.clickOn(By.id("interestedInReviewingOffer"));
    }
    public void submitSurvey(){
        mainMethods.clickOn(By.name("submit_registration_survey"));
    }
    public void clickOkay (){
        mainMethods.clickOn(By.xpath("//button[.='U redu']"));
    }

    public void enterName(){
        mainMethods.type(By.id("first_name"), "Milomir");
    }
    public void enterSurname(){
        mainMethods.type((By.id("last_name")), "Milosevic");
    }
    public void enterAdress(){
        mainMethods.type(By.id("address"), "Sopic ");
    }
    public void enterCity(){
        mainMethods.type(By.id("city"), "Lazarevac");
    }
    public void chooseRegion(){
        mainMethods.clickOn(By.xpath("//span[.=' Odaberite okrug']"));
        mainMethods.clickOn(By.xpath("//label[.='Beograd (širi)']"));
    }
    public void enterCellphone(){
        mainMethods.type(By.id("cellphone"), "0641234567");
    }
    public void clickSubmit(){
        mainMethods.clickOn(By.id("submit"));
    }
    public void checkSuccessMessage(){
        mainMethods.checkPresence(By.cssSelector(".uk-alert-success"));
    }
    public void hoverLogout(){
        String dropdownDivContent = "\n" + "\t\t\t\t\t\t\t\t\tMOJ PROFIL ";
        String xpathExpression = "//div[contains(text(), '" + dropdownDivContent + "')]";
        mainMethods.hoverOver(By.xpath(xpathExpression));
    }
    public void clickLogout(){
        mainMethods.clickOn(By.xpath("//*[contains(@class, 'uk-button-dropdown')]//*[contains(@class, 'uk-dropdown')]//li[last()]"));
    }







}
