package epam.com.tsm.businessObjects;

import epam.com.tsm.controls.Button;
import epam.com.tsm.controls.EditBox;
import epam.com.tsm.ui.Locator;
import epam.com.tsm.ui.LocatorType;
import epam.com.tsm.ui.UIElement;

import static com.thoughtworks.selenium.SeleneseTestBase.fail;

/**
 * Created by Irina_Kartun on 1/19/2016.
 */
public class Calendar {

    private EditBox calendar;

    public Calendar(EditBox calendar){
        this.calendar = calendar;
    }

    public void selectDate(String date, String type){
        calendar.click();
        findDate(date, type);
    }

    private void findDate(String date, String type){            //type can be departure or return
        UIElement calendarDates = new UIElement(new Locator(LocatorType.XPATH, "//table[@id='" + type + "Date_table']/tbody//div"));
        Button next = new Button(new Locator(LocatorType.XPATH, "//div[@id='departureDate_root']//div[@title='Next month']"));
        for (int i = 0; i < calendarDates.getList().size(); i++) {
            if (calendarDates.getList().get(i).getAttribute("aria-label").equals(date)){
                calendarDates.getList().get(i).click();
                return;
            }
        }
        if (next.getAttribute("class").equals("picker__nav--next picker__nav--disabled")){
            fail("You can't select specified date!");
        }
        else{
            next.click();
            findDate(date, type);
        }
    }

}
