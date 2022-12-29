package SwagLabsPOM;

import methods.MainMethods;
import org.openqa.selenium.By;

public class SwagLabsCheckoutPageTwo {
    private MainMethods mainMethods;
    public SwagLabsCheckoutPageTwo(MainMethods mainMethods) {
        this.mainMethods = mainMethods;
    }
    public void clickFInish(){
        mainMethods.clickOn(By.id("finish"));
    }
}
