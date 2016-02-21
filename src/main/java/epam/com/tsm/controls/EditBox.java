package epam.com.tsm.controls;

import epam.com.tsm.ui.Locator;
import epam.com.tsm.ui.UIElement;

/**
 * Created by Irina_Kartun on 1/18/2016.
 */
public class EditBox extends UIElement{

    public EditBox(Locator loc) {
        super(loc);
    }


    public void setTextValue(String textToSet){
        this.sendKeys(textToSet);
    }

}
