package epam.com.tsm.controls;

import epam.com.tsm.ui.Locator;
import epam.com.tsm.ui.UIElement;
import epam.com.tsm.webdriver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;

/**
 * Created by Irina_Kartun on 1/18/2016.
 */
public class TextLabel extends UIElement{

    public TextLabel(Locator loc) {
        super(loc);
    }

    public String getTextLabel(){
        return this.getText();
    }

}
