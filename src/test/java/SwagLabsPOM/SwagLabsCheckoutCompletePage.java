package SwagLabsPOM;

import methods.MainMethods;
import org.openqa.selenium.By;

public class SwagLabsCheckoutCompletePage {
    private MainMethods mainMethods;
    public SwagLabsCheckoutCompletePage(MainMethods mainMethods) {
        this.mainMethods = mainMethods;
    }
    public void verifyThankYouHeader(){
        mainMethods.checkPresence(By.xpath("//h2[.='THANK YOU FOR YOUR ORDER']"));
    }
    public void clickBurgerMenu(){
        mainMethods.clickOn(By.cssSelector("#react-burger-menu-btn"));
    }
    public void clickLogOut(){
        mainMethods.clickOn(By.xpath("//a[.='Logout']"));
    }

}