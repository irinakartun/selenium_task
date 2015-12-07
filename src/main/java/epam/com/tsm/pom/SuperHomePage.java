package epam.com.tsm.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.security.Key;
import java.util.List;

import static com.thoughtworks.selenium.SeleneseTestBase.fail;

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

    public SuperHomePage goToFlightsTab(){
        flightsTab.click();
        return this;
    }

    public SuperHomePage setFromAirport(String from, String airportAbbr){
        flyingFrom.sendKeys(from);
        wait.until(ExpectedConditions.visibilityOf(autocompleteFrom));
        for (int i = 0; i < airportsFrom.size(); i++) {
            airportsFrom.get(i).sendKeys(Keys.DOWN);
            if (airportsFrom.get(i).getAttribute("focus-on").equals(airportAbbr)){
                airportsFrom.get(i).click();
                return this;
            }
        }
        fail("Specified airport was not found!");
        return this;
    }

    public SuperHomePage setToAirport(String to, String airportAbbr){
        flyingTo.sendKeys(to);
        wait.until(ExpectedConditions.visibilityOf(autocompleteTo));
        for (int i = 0; i < airportsTo.size(); i++) {
            airportsTo.get(i).sendKeys(Keys.DOWN);
            if (airportsTo.get(i).getAttribute("focus-on").equals(airportAbbr)){
                airportsTo.get(i).click();
                return this;
            }
        }
        fail("Specified airport was not found!");
        return this;
    }

    public SuperHomePage setFromDate(String dateFrom){
        departCalendar.click();
        findDate(departDates, dateFrom);
        return this;
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

    public SuperHomePage setToDate(String dateTo){
        returnCalendar.click();
        findDate(returnDates, dateTo);
        return this;
    }

    public SuperHomePage selectAdults(String quantity){
        new Select(adults).selectByValue(quantity);
        return this;
    }

    public SuperHomePage checkDirectOnly(){
        directFlights.click();
        return this;
    }

    public ResultPage clickSearch(){
        searchBtn.click();
        return PageFactory.initElements(driver, ResultPage.class);
    }

}
