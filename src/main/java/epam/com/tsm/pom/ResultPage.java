package epam.com.tsm.pom;

import epam.com.tsm.businessObjects.AirlinesFilter;
import epam.com.tsm.businessObjects.SliderFilter;
import epam.com.tsm.businessObjects.Filter;
import epam.com.tsm.controls.Button;
import epam.com.tsm.controls.CheckBox;
import epam.com.tsm.controls.TextLabel;
import epam.com.tsm.logger.Logging;
import epam.com.tsm.ui.Locator;
import epam.com.tsm.ui.LocatorType;
import epam.com.tsm.ui.UIElement;
import epam.com.tsm.webdriver.WebdriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import static com.thoughtworks.selenium.SeleneseTestBase.fail;
import static epam.com.tsm.webdriver.WebdriverSingleton.highlightElement;

/**
 * Created by Irina_Kartun on 12/5/2015.
 */
public class ResultPage extends AbstractPage {

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public UIElement uploadedResults = new UIElement(new Locator(LocatorType.XPATH, "//div[@class='results-summary results-summary--complete']"));
    public TextLabel header = new TextLabel(new Locator(LocatorType.XPATH, "//div[@class='results-list-wrapper']//h1"));
    public TextLabel airlinesTab = new TextLabel(new Locator(LocatorType.LINKTEXT, "Airlines"));
    public TextLabel costTab = new TextLabel(new Locator(LocatorType.LINKTEXT, "Cost"));
    public TextLabel airlinesFilter = new TextLabel(new Locator(LocatorType.ID, "airlines"));
    public TextLabel costFilter = new TextLabel(new Locator(LocatorType.XPATH, "//*[@tracking-label='Cost']"));
    public UIElement costLowValue = new UIElement(new Locator(LocatorType.XPATH, ".//*[@tracking-label='Cost']//*[@class='filter-slider__value filter-slider__value--low ng-binding']"));
    public UIElement costHighValue = new UIElement(new Locator(LocatorType.XPATH, ".//*[@tracking-label='Cost']//*[@class='filter-slider__value filter-slider__value--high ng-binding']"));
    public Button nextPage = new Button(new Locator(LocatorType.XPATH, "//*[@role='navigation']//button[contains(., 'Next')]"));


    public void waitResultsUploaded(){
        Logging.getLogger().info("Waiting for results..");
        WebdriverSingleton.waitElementIsPresented(uploadedResults);
    }

    public String verifyHeader(){
        Logging.getLogger().info("Get header value");
        return header.getText();
    }

    public void setSliderFilter(String type, int xLeft, int xRight){
        Logging.getLogger().info("Setting Slider Filter");
        if (!costFilter.isDisplayed()){
            costTab.click();
        }
        Filter costFilter = new SliderFilter(type, xLeft, 0, xRight, 0);
        costFilter.setFilter();
    }

    public void setFilterByAirlines(String airlineName){
        Logging.getLogger().info("Setting Airport Filter");
        if (!airlinesFilter.isDisplayed()){
            airlinesTab.click();
        }
        CheckBox airline = new CheckBox(new Locator(LocatorType.XPATH, "//*[@id='airlines']//span[contains(., '" + airlineName + "')]"));
        Filter airlinesFilter = new AirlinesFilter(airline);
        airlinesFilter.setFilter();
    }

    private float parseCurrencyToNumber(String currencyString) throws ParseException {
        Locale locale = Locale.UK;
        Number number = NumberFormat.getCurrencyInstance(locale).parse(currencyString);
        return number.floatValue();
    }

    public void verifyFilterResults(String airlineName) throws ParseException {
        Logging.getLogger().info("Verifying Filter Results");
        float lowCost = parseCurrencyToNumber(costLowValue.getText().trim());
        float highCost = parseCurrencyToNumber(costHighValue.getText().replace(" - ", "").trim());
        TextLabel prices = new TextLabel(new Locator(LocatorType.XPATH, "//*[@class='ng-scope ng-isolate-scope']//*[@class='card__price']"));
        TextLabel outboundAirline = new TextLabel(new Locator(LocatorType.XPATH, "//*[@details='card.outboundFlight']//h3/span[contains(., '" + airlineName + "')]"));
        TextLabel inboundAirline = new TextLabel(new Locator(LocatorType.XPATH, "//*[@details='card.inboundFlight']//h3/span[contains(., '" + airlineName + "')]"));

        for (int i = 0; i < prices.getList().size(); i++) {
            if ( (parseCurrencyToNumber(prices.getList().get(i).getText().trim()) >= lowCost) && (parseCurrencyToNumber(prices.getList().get(i).getText().trim()) <= highCost)
                    && outboundAirline.getList().get(i).getText().contains(airlineName) && inboundAirline.getList().get(i).getText().contains(airlineName) ){
                continue;
            }
            else {
                fail("Filter does not work correct!");
            }
        }
        if (nextPage.isDisplayed()){
            nextPage.click();
            verifyFilterResults(airlineName);
        }
        else{
            return;
        }
    }


}
