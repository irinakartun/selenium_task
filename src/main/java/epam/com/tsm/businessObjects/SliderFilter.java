package epam.com.tsm.businessObjects;

import epam.com.tsm.controls.Slider;
import epam.com.tsm.ui.Locator;
import epam.com.tsm.ui.LocatorType;
import epam.com.tsm.webdriver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;


/**
 * Created by Irina_Kartun on 1/21/2016.
 */
public class SliderFilter extends Filter {

    String type;            //type can be Cost, Flights Flying From, Flights Flying To, Time_Outbound Take Off, Time_Inbound Take Off, Time_Flight_Outbound_Duration, Time_Flight_Inbound_Duration
    int xLeft;
    int yLeft;
    int xRight;
    int yRight;


    public SliderFilter(String type, int xLeft, int yLeft, int xRight, int yRight) {
        this.type = type;
        this.xLeft = xLeft;
        this.yLeft = yLeft;
        this.xRight = xRight;
        this.yRight = yRight;
    }


    @Override
    public void setFilter() {
        Slider leftFilter = new Slider(new Locator(LocatorType.XPATH, ".//*[@tracking-label='" + type + "']//*[@class='noUi-handle noUi-handle-lower']"));
        Slider rightFilter = new Slider(new Locator(LocatorType.XPATH, ".//*[@tracking-label='" + type + "']//*[@class='noUi-handle noUi-handle-upper']"));
        leftFilter.moveSlider(xLeft, yLeft);
        rightFilter.moveSlider(xRight, yRight);
    }

}
