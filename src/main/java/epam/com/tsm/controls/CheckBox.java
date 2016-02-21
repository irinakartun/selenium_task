package epam.com.tsm.controls;

import epam.com.tsm.ui.Locator;
import epam.com.tsm.ui.UIElement;

/**
 * Created by Irina_Kartun on 1/19/2016.
 */
public class CheckBox extends UIElement{

    public CheckBox(Locator loc) {
        super(loc);
    }

    public boolean isChecked(){
        return this.isSelected();
    }

    public void check(){
        this.click();
    }
}
