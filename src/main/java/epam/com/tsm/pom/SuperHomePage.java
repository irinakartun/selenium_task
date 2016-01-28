package epam.com.tsm.pom;

import epam.com.tsm.businessObjects.Calendar;
import epam.com.tsm.controls.*;
import epam.com.tsm.ui.Locator;
import epam.com.tsm.ui.LocatorType;
import epam.com.tsm.ui.UIElement;
import epam.com.tsm.ui.UIElementDecorator;
import epam.com.tsm.webdriver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Irina_Kartun on 12/5/2015.
 */
public class SuperHomePage extends AbstractPage{

    public SuperHomePage(WebDriver driver) {
        super(driver);
    }


    public static final String SHP_URL = "https://www.travelsupermarket.com";

    public WebElement logo = new UIElementDecorator(new Locator(LocatorType.XPATH, "//div[@class='site-logo']"));
    public UIElement menu = new UIElement(new Locator(LocatorType.ID, "navigation-screen-toggle-area"));
    public TextLabel hero = new TextLabel(new Locator(LocatorType.ID, "hero"));
    public UIElement searchGadget = new UIElement(new Locator(LocatorType.TAG, "search-gadget"));
    public Button holidaysTab = new Button(new Locator(LocatorType.XPATH, "//button[@class='searchGadgetForm__channelOption ng-binding searchGadgetForm__channelOption--current'][contains(., 'Holidays')]"));
    public Button flightsTab = new Button(new Locator(LocatorType.XPATH, "//button[contains(., 'Flights')]"));
    public Button hotelsTab = new Button(new Locator(LocatorType.XPATH, "//button[contains(., 'Hotels')]"));
    public Button carHireTab = new Button(new Locator(LocatorType.XPATH, "//button[contains(., 'Car Hire')]"));
    public Button insuranceTab = new Button(new Locator(LocatorType.XPATH, "//button[contains(., 'Insurance')]"));
    public EditBox flyingFrom = new EditBox(new Locator(LocatorType.ID, "flyingFromField_input"));
    public AutocompleteList autocompleteFrom = new AutocompleteList(new Locator(LocatorType.XPATH, "//auto-complete[@id='flyingFromField']/div/div"));
    public AutocompleteList airportsFrom = new AutocompleteList(new Locator(LocatorType.XPATH, "//auto-complete[@id='flyingFromField']//button"));
    public EditBox flyingTo = new EditBox(new Locator(LocatorType.ID, "flyingToField_input"));
    public AutocompleteList autocompleteTo = new AutocompleteList(new Locator(LocatorType.XPATH, "//auto-complete[@id='flyingToField']/div/div"));
    public AutocompleteList airportsTo = new AutocompleteList(new Locator(LocatorType.XPATH, "//auto-complete[@id='flyingToField']//button"));
    public EditBox departCalendar = new EditBox(new Locator(LocatorType.ID, "departureDate"));
    public EditBox returnCalendar = new EditBox(new Locator(LocatorType.ID, "returnDate"));
    public UIElement returnDates = new UIElement(new Locator(LocatorType.XPATH, "//table[@id='returnDate_table']/tbody//div"));
    public DropdownList adults = new DropdownList(new Locator(LocatorType.XPATH, "//select[@id='flightsAdults']"));
    public CheckBox directFlights = new CheckBox(new Locator(LocatorType.XPATH, "//label[contains(text(), 'Direct flights only')]"));
    public Button searchBtn = new Button(new Locator(LocatorType.XPATH, "//form[@name='flightsEnquiryForm']//button[@type='submit']"));


    public void openFlightsTab(){
        flightsTab.clickButton();
    }

    public void setDepartAirport(String airportFrom, String abbrFrom){
        flyingFrom.setTextValue(airportFrom);
        WebDriverSingleton.waitElementIsPresented(autocompleteFrom);
        airportsFrom.selectAutocompleteValue(airportFrom, abbrFrom);
    }

    public void setDestinationAirport(String airportTo, String abbrTo){
        flyingTo.setTextValue(airportTo);
        WebDriverSingleton.waitElementIsPresented(autocompleteTo);
        airportsTo.selectAutocompleteValue(airportTo, abbrTo);
    }

    public void setDepartDate(String departDate){
        Calendar calendarFrom = new Calendar(departCalendar);
        calendarFrom.selectDate(departDate, "departure");
    }

    public void setReturnDate(String returnDate){
        Calendar calendarTo = new Calendar(returnCalendar);
        calendarTo.selectDate(returnDate, "return");
    }

    public void setAdultsAmount(String adultsAmount){
        adults.selectValue(adultsAmount);
    }

    public ResultPage clickSearchButton(){
        searchBtn.clickButton();
        return PageFactory.initElements(driver, ResultPage.class);
    }


}
