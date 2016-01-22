package epam.com.tsm.controls;

import org.openqa.selenium.WebElement;

/**
 * Created by Irina_Kartun on 1/19/2016.
 */
public class CheckBox {

    private WebElement checkbox;

    public CheckBox(WebElement checkbox){
        this.checkbox = checkbox;
    }

    public void check(boolean valueToSet){
        if(valueToSet){
            checkbox.click();
        }
    }

}
