package epam.com.tests;

import epam.com.tsm.logger.Logging;
import epam.com.tsm.pom.ResultPage;
import epam.com.tsm.pom.SuperHomePage;
import epam.com.tsm.ui.UIElement;
import epam.com.tsm.webdriver.WebdriverSingleton;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.text.ParseException;

import static epam.com.tsm.webdriver.WebdriverSingleton.highlightElement;
import static epam.com.tsm.webdriver.WebdriverSingleton.takeScreenshot;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Irina_Kartun on 12/5/2015.
 */
public class NewTest extends BasicTest {

    @Test(description = "verify superHomePage", enabled = true)
    public void testSuperhomepage(){
        Logging.getLogger().info("Run testSuperhomepage test");
        SuperHomePage shp = new SuperHomePage(driver);
        assertTrue(shp.logo.isDisplayed());
        assertTrue(shp.menu.isDisplayed());
        assertEquals(shp.hero.getText(), "We search wider than any other");
//                "holiday website (Super, aren’t we!)");
        highlightElement(shp.hero);
        takeScreenshot(WebdriverSingleton.getWebDriverInstance());
        assertTrue(shp.searchGadget.isDisplayed());
        assertTrue(shp.holidaysTab.isDisplayed());
        assertTrue(shp.flightsTab.isDisplayed());
        assertTrue(shp.carHireTab.isDisplayed());
        assertTrue(shp.hotelsTab.isDisplayed());
        assertTrue(shp.insuranceTab.isDisplayed());
        Logging.getLogger().info("Finish testSuperhomepage test");
    }

    @Test(description = "verify flight search with filters", enabled = true)
    public void testCostFilter() throws ParseException {
        Logging.getLogger().info("Run testCostFilter test");
        SuperHomePage shp = new SuperHomePage(driver);
        shp.openFlightsTab();
        shp.setDepartAirport("los angeles", "LAX");
        shp.setDestinationAirport("rome", "FCO");
        takeScreenshot(WebdriverSingleton.getWebDriverInstance());
        shp.setDepartDate("20 Mar 16");
        shp.setReturnDate("27 Mar 16");
        shp.setAdultsAmount("1");
        ResultPage result = shp.clickSearchButton();
        result.waitResultsUploaded();
        assertEquals(result.verifyHeader(), "LAX to FCO");
        result.setFilterByAirlines("Aeroflot Russian Airlines");
        result.setSliderFilter("Cost", 10, -100);
        result.verifyFilterResults("Aeroflot Russian Airlines");
        Logging.getLogger().info("Finish testCostFilter test");
    }

}
