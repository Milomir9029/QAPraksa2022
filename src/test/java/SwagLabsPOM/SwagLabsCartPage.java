package SwagLabsPOM;

import methods.MainMethods;
import org.openqa.selenium.By;

public class SwagLabsCartPage {
    private MainMethods mainMethods;
    public SwagLabsCartPage(MainMethods mainMethods){
        this.mainMethods = mainMethods;
    }
    public void clickCheckout(){
        mainMethods.clickOn(By.id("checkout"));
    }
}
