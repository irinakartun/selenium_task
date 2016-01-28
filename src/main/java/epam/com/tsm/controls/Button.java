package epam.com.tsm.controls;

import epam.com.tsm.ui.Locator;
import epam.com.tsm.ui.UIElement;
import org.openqa.selenium.WebDriver;

/**
 * Created by Irina_Kartun on 1/19/2016.
 */
public class Button extends UIElement{

    public Button(Locator loc) {
        super(loc);
    }

    public void clickButton(){
        this.click();
    }

}
