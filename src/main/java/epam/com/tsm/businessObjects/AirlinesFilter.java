package epam.com.tsm.businessObjects;

import epam.com.tsm.controls.CheckBox;
import epam.com.tsm.controls.TextLabel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import static com.thoughtworks.selenium.SeleneseTestBase.fail;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Irina_Kartun on 1/23/2016.
 */
public class AirlinesFilter extends Filter {

    CheckBox airline;

    public AirlinesFilter(CheckBox airline) {
        this.airline = airline;
    }


    @Override
    public void setFilter() {
        airline.check();
    }

}
