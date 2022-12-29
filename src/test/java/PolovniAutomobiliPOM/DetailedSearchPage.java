package PolovniAutomobiliPOM;

import methods.MainMethods;
import org.openqa.selenium.By;

public class DetailedSearchPage {
    private MainMethods mainMethods;
    public DetailedSearchPage(MainMethods mainMethods){
        this.mainMethods = mainMethods;
    }
    public void popUpCheckAndClose(){
        mainMethods.popupCheck("btn_poll_no");
    }
    public void chooseCarMake(){
        mainMethods.clickOn(By.xpath("//span[.=' Marka']"));
        mainMethods.clickOn(By.xpath("//label[.='Audi']"));
    }
    public void chooseModel(){
        mainMethods.clickOn(By.xpath("//span[.=' Svi modeli']"));
        try {
            mainMethods.clickOn(By.xpath("//label[.='\n" + "\t\tA4\n" + "\t']"));
        }catch (Exception ignored){
            mainMethods.clickOn(By.xpath("//span[.=' Svi modeli']"));
            mainMethods.clickOn(By.xpath("//label[.='\n" + "\t\tA4\n" + "\t']"));
        }
    }
    public void setPriceFrom(){
        mainMethods.type(By.id("price_from"), "5000");
    }
    public void setPriceTo(){
        mainMethods.type(By.id("price_to"), "8000");
    }
    public void chooseBodyStyle(){
        mainMethods.clickOn(By.xpath("//span[.=' Karoserija']"));
        mainMethods.clickOn(By.xpath("//label[.='Limuzina']/parent::*"));
    }
    public void chooseFuelType(){
        mainMethods.clickOn(By.xpath("//span[.=' Vrsta goriva']"));
        mainMethods.clickOn(By.xpath("//label[.='Benzin']"));
    }
    public void chooseRegion(){
        mainMethods.clickOn(By.xpath("//span[.=' Region']"));
        mainMethods.clickOn(By.xpath("//label[.='Beograd']/parent::*"));
    }
    public void setYearFrom(){
        mainMethods.clickOn(By.xpath("//span[.=' Godina od']"));
        mainMethods.clickOn(By.xpath("//label[.='2005 god.']"));
    }
    public void setYearTo(){
        mainMethods.clickOn(By.xpath("//span[.=' do']"));
        mainMethods.clickOn(By.xpath("//div[@class='SumoSelect sumo_year_to open']//div//ul//li[5]"));
    }
    public void setDoorNumber(){
        mainMethods.clickOn(By.xpath("//span[.=' Broj vrata']"));
        mainMethods.clickOn(By.xpath("//label[.='4/5 vrata']/parent::*"));
    }
    public void clickSearch(){
        mainMethods.clickOn(By.id("submit_1"));
    }


}
