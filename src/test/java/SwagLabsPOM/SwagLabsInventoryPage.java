package SwagLabsPOM;

import methods.MainMethods;
import org.openqa.selenium.By;

public class SwagLabsInventoryPage {
    private MainMethods mainMethods;
    public SwagLabsInventoryPage(MainMethods mainMethods){
        this.mainMethods = mainMethods;
    }
    public void verifyCartPresence(){
        mainMethods.checkPresence(By.cssSelector(".shopping_cart_link"));
    }
    public void verifyBurgerMenuPresence(){
        mainMethods.checkPresence(By.cssSelector("#react-burger-menu-btn"));
    }
    public void verifyTwitterLinkPresence(){
        mainMethods.checkPresence(By.xpath("//a[.='Twitter']"));
    }
    public void verifyFBLinkPresence(){
        mainMethods.checkPresence(By.xpath("//a[.='Facebook']"));
    }
    public void verifyLinkedInLinkPresence(){
        mainMethods.checkPresence(By.xpath("//a[.='LinkedIn']"));
    }
    public void clickBurgerMenu(){
        mainMethods.clickOn(By.cssSelector("#react-burger-menu-btn"));
    }
    public void clickLogOut(){
        mainMethods.clickOn(By.xpath("//a[.='Logout']"));
    }
    public void selectItem(){
        mainMethods.clickOn(By.xpath("//div[.='Sauce Labs Backpack']"));
    }
    public void verifyProductsHeader(){
        mainMethods.checkPresence(By.xpath("//span[.='Products']"));
    }



}
