package epam.com.tsm.controls;

import epam.com.tsm.ui.Locator;
import epam.com.tsm.ui.UIElement;

import static org.testng.AssertJUnit.fail;

/**
 * Created by Irina_Kartun on 1/19/2016.
 */
public class AutocompleteList extends UIElement{

    public AutocompleteList(Locator loc) {
        super(loc);
    }



    public void selectAutocompleteValue(String valueToSelect, String abbrValue){
        this.selectAutocompletedValue(valueToSelect, abbrValue);
    }
}
