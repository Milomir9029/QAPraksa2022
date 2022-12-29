package SwagLabsPOM;

import methods.MainMethods;
import org.openqa.selenium.By;

public class SwagLabsItemPage {
    private MainMethods mainMethods;
    public SwagLabsItemPage(MainMethods mainMethods){
        this.mainMethods = mainMethods;
    }
    public void verifyTitle(){
        mainMethods.checkPresence(By.xpath("//div[.='Sauce Labs Backpack']"));
    }
    public void verifyDescription(){
        mainMethods.checkPresence(By.cssSelector(".inventory_details_desc"));
    }
    public void verifyPrice(){
        mainMethods.checkPresence(By.cssSelector(".inventory_details_price"));
    }
    public void clickDddToCart(){
        mainMethods.clickOn(By.id("add-to-cart-sauce-labs-backpack"));
    }
    public void clickOpenCart(){
        mainMethods.clickOn(By.cssSelector(".shopping_cart_link"));
    }




}
