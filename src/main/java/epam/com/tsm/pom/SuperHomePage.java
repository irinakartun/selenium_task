package epam.com.tsm.pom;

import epam.com.tsm.businessObjects.Calendar;
import epam.com.tsm.controls.CheckBox;
import epam.com.tsm.controls.DropdownList;
import epam.com.tsm.controls.EditField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Irina_Kartun on 12/5/2015.
 */
public class SuperHomePage extends AbstractPage{

    public SuperHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    WebDriverWait wait = new WebDriverWait(driver, 3000);

    public static final String SHP_URL = "https://www.travelsupermarket.com/";

    @FindBy(xpath = "//div[@class='site-logo']")
    private WebElement logo;

    @FindBy(id = "navigation-screen-toggle-area")
    private WebElement menu;

    @FindBy(id = "hero")
    private WebElement hero;

    @FindBy(tagName = "search-gadget")
    private WebElement searchGadget;

    @FindBy(xpath = "//button[@class='searchGadgetForm__channelOption ng-binding searchGadgetForm__channelOption--current'][contains(., 'Holidays')]")
    private WebElement holidaysTab;

    @FindBy(xpath = "//button[contains(., 'Flights')]")
    private WebElement flightsTab;

    @FindBy(xpath = "//button[contains(., 'Hotels')]")
    private WebElement hotelsTab;

    @FindBy(xpath = "//button[contains(., 'Car Hire')]")
    private WebElement carHireTab;

    @FindBy(xpath = "//button[contains(., 'Insurance')]")
    private WebElement insuranceTab;

    @FindBy(id = "flyingFromField_input")
    private WebElement flyingFrom;

    @FindBy(xpath = "//auto-complete[@id='flyingFromField']/div/div")
    private WebElement autocompleteFrom;

    @FindBy(xpath = "//auto-complete[@id='flyingFromField']//button")
    private List<WebElement> airportsFrom;

    @FindBy(id = "flyingToField_input")
    private WebElement flyingTo;

    @FindBy(xpath = "//auto-complete[@id='flyingToField']/div/div")
    private WebElement autocompleteTo;

    @FindBy(xpath = "//auto-complete[@id='flyingToField']//button")
    private List<WebElement> airportsTo;

    @FindBy(id = "departureDate")
    private WebElement departCalendar;

    @FindBy(xpath = "//table[@id='departureDate_table']/tbody//div")
    private List<WebElement> departDates;

    @FindBy(xpath = "//div[@id='departureDate_root']//div[@title='Next month']")
    private WebElement nextMonth;

    @FindBy(id = "returnDate")
    private WebElement returnCalendar;

    @FindBy(xpath = "//table[@id='returnDate_table']/tbody//div")
    private List <WebElement> returnDates;

    @FindBy(xpath = "//select[@id='flightsAdults']")
    private WebElement adults;

    @FindBy(xpath = "//label[contains(text(), 'Direct flights only')]")
    private WebElement directFlights;

    @FindBy(xpath = "//form[@name='flightsEnquiryForm']//button[@type='submit']")
    private WebElement searchBtn;

    public boolean isLogoPresented(){
        return logo.isDisplayed();
    }

    public boolean isMenuPresented(){
        return menu.isDisplayed();
    }

    public boolean isHeroPresented(){
        return hero.getText().contains("Welcome to our new home");
    }

    public boolean isSearchGadgetPresented(){
        return searchGadget.isDisplayed();
    }

    public boolean isHolidayTabPresented(){
        return holidaysTab.isDisplayed();
    }

    public boolean isFlightTabPresented(){
        return flightsTab.isDisplayed();
    }

    public boolean isHotelsTabPresented(){
        return hotelsTab.isDisplayed();
    }

    public boolean isCarHireTabPresented(){
        return carHireTab.isDisplayed();
    }

    public boolean isInsuranceTabPresented(){
        return insuranceTab.isDisplayed();
    }



    public ResultPage searchFlights(String airportFrom, String abbrFrom, String airportTo, String abbrTo, String departDate, String returnDate, boolean direct, String adultsAmount){
        flightsTab.click();
        EditField from = new EditField(flyingFrom, autocompleteFrom, airportsFrom);
        from.selectAutocompleteValue(driver, airportFrom, abbrFrom);
        EditField to = new EditField(flyingTo, autocompleteTo, airportsTo);
        to.selectAutocompleteValue(driver, airportTo, abbrTo);
        Calendar fromDate = new Calendar(departCalendar, departDates, nextMonth);
        fromDate.selectDate(departDate);
        Calendar toDate = new Calendar(returnCalendar, returnDates, nextMonth);
        toDate.selectDate(returnDate);
        DropdownList adultsList = new DropdownList(adults);
        adultsList.selectDropdownValue(adultsAmount);
        CheckBox directFlight = new CheckBox(directFlights);
        directFlight.check(direct);
        searchBtn.click();
        return PageFactory.initElements(driver, ResultPage.class);
    }

/*
    public ResultPage searchFlights(String airportNameFrom, String airportAbbrFrom, String airportNameTo, String airportAbbrTo,
                                    String dateFrom, String dateTo,
                                    String quantity,
                                    Boolean set){
        FlightsSearch flightsGadget = new FlightsSearch(flightsTab, searchBtn);
        flightsGadget.setAirportFrom(flyingFrom);
        flightsGadget.setAirportsListFrom(airportsFrom);
        flightsGadget.setAutocompleteFrom(autocompleteFrom);
        flightsGadget.setAirportTo(flyingTo);
        flightsGadget.setAirportsListTo(airportsTo);
        flightsGadget.setAutocompleteTo(autocompleteTo);
        flightsGadget.setDepartCalendar(departCalendar);
        flightsGadget.setDepartDates(departDates);
        flightsGadget.setReturnCalendar(returnCalendar);
        flightsGadget.setReturnDates(returnDates);
        flightsGadget.setNextMonth(nextMonth);
        flightsGadget.setAdult(adults);
        flightsGadget.setDirectOnly(directFlights);
        flightsGadget.doSearch(airportNameFrom, airportAbbrFrom, airportNameTo, airportAbbrTo,
                                dateFrom, dateTo,
                                quantity,
                                set);
        return PageFactory.initElements(driver, ResultPage.class);
    }


    public ResultPage doFlightsSearch(String airportFrom, String airportAbbrFrom, String airportTo, String airportAbbrTo,
                                      String dateFrom, String dateTo,
                                      String quantity,
                                      boolean direct){

        SearchGadget flightSearch = new FlightsSearch("", airportFrom, airportTo, dateFrom, dateTo, quantity, direct)

    }





    public void goToFlightsTab(){
        flightsTab.click();
    }

    public void setFromAirport(String from, String airportAbbr) {
        flyingFrom.sendKeys(from);
        wait.until(ExpectedConditions.visibilityOf(autocompleteFrom));
        boolean found = false;
        for (int i = 0; i < airportsFrom.size(); i++) {
            airportsFrom.get(i).sendKeys(Keys.DOWN);
            if (airportsFrom.get(i).getAttribute("focus-on").equals(airportAbbr)) {
                airportsFrom.get(i).click();
                found = true;
            }
        }
        if (found) {
            return;
        }
        else {
            fail("Specified airport was not found!");
        }
    }

    public void typeFromAirport(String fromAirport){
        flyingFrom.click();
        Actions builder = new Actions(driver);
        builder.sendKeys(fromAirport).build().perform();
    }

    public void typeToAirport(String toAirport){
        flyingTo.click();
        Actions builder = new Actions(driver);
        builder.sendKeys(toAirport).build().perform();
    }

    public void setToAirport(String to, String airportAbbr){
        flyingTo.sendKeys(to);
        wait.until(ExpectedConditions.visibilityOf(autocompleteTo));
        boolean found = false;
        for (int i = 0; i < airportsTo.size(); i++) {
            airportsTo.get(i).sendKeys(Keys.DOWN);
            if (airportsTo.get(i).getAttribute("focus-on").equals(airportAbbr)){
                airportsTo.get(i).click();
                found = true;
            }
        }
        if (found) {
            return;
        }
        else {
            fail("Specified airport was not found!");
        }
    }

    public void setFromDate(String dateFrom) {
        departCalendar.click();
        findDate(departDates, dateFrom);
    }

    private void findDate(List<WebElement> calendar, String date){
        for (int i = 0; i < calendar.size(); i++) {
            if (calendar.get(i).getAttribute("aria-label").equals(date)){
                calendar.get(i).click();
                return;
            }
        }
        if (nextMonth.getAttribute("class").equals("picker__nav--next picker__nav--disabled")){
            fail("You can't book the ticket for specified date!");
        }
        else{
            nextMonth.click();
            findDate(calendar, date);
        }
    }

    public void setToDate(String dateTo) {
        returnCalendar.click();
        findDate(returnDates, dateTo);
    }

    public void execJSFromDate(String dateFrom) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('departureDate_root').setAttribute('aria-hidden', 'false');");
        js.executeScript("document.getElementById('departureDate_root').setAttribute('class', 'picker picker--opened picker--focused');");
        findDate(departDates, dateFrom);
    }

    public void execJSToDate(String dateTo) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('returnDate_root').setAttribute('aria-hidden', 'false');");
        js.executeScript("document.getElementById('returnDate_root').setAttribute('class', 'picker picker--opened picker--focused');");
        findDate(returnDates, dateTo);
    }

    public void selectAdults(String quantity){
        new Select(adults).selectByValue(quantity);
    }

    public void checkDirectOnly(){
        directFlights.click();
    }

    public ResultPage clickSearch(){
        searchBtn.click();
        return PageFactory.initElements(driver, ResultPage.class);
    }

*/
}
