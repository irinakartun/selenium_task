package epam.com.tsm.controls;

import epam.com.tsm.ui.Locator;
import epam.com.tsm.ui.UIElement;
import epam.com.tsm.webdriver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Irina_Kartun on 1/19/2016.
 */
public class DropdownList extends UIElement{

    public DropdownList(Locator loc) {
        super(loc);
    }

    public void selectValue(String valueToSelect){
        Select selectElement = new Select(WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()));
        selectElement.selectByVisibleText(valueToSelect);
    }

}
