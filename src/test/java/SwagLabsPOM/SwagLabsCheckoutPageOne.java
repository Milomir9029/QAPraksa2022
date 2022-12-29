package SwagLabsPOM;

import methods.MainMethods;
import org.openqa.selenium.By;

public class SwagLabsCheckoutPageOne {
    private MainMethods mainMethods;
    public SwagLabsCheckoutPageOne(MainMethods mainMethods){
        this.mainMethods = mainMethods;
    }
    public void typeName(){
        mainMethods.type(By.id("first-name"), "Milomir");
    }
    public void typeSurname(){
        mainMethods.type(By.id("last-name"), "Milosevic");
    }
    public void typePostalCode(){
        mainMethods.type(By.id("postal-code"), "11550");
    }
    public void clickContinue(){
        mainMethods.clickOn(By.id("continue"));
    }
}
