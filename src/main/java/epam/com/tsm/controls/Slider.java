package epam.com.tsm.controls;

import epam.com.tsm.ui.Locator;
import epam.com.tsm.ui.UIElement;

/**
 * Created by Irina_Kartun on 1/19/2016.
 */
public class Slider extends UIElement{

    public Slider(Locator loc) {
        super(loc);
    }

    public void moveSlider(int valueX, int valueY){
       this.dragAndDropElement(valueX, valueY);
    }



}
