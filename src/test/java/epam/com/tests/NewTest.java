package epam.com.tests;

import epam.com.tsm.pom.ResultPage;
import epam.com.tsm.pom.SuperHomePage;
import org.testng.annotations.Test;

import java.text.ParseException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Irina_Kartun on 12/5/2015.
 */
public class NewTest extends BasicTest {

    @Test(description = "verify superHomePage", enabled = true)
    public void testSuperhomepage(){
        SuperHomePage shp = new SuperHomePage(driver);
        assertTrue(shp.logo.isDisplayed());
        assertTrue(shp.menu.isDisplayed());
        assertEquals(shp.hero.getText(), "We search wider than any other\n" +
                "holiday website (Super, aren’t we!)");
        assertTrue(shp.searchGadget.isDisplayed());
        assertTrue(shp.holidaysTab.isDisplayed());
        assertTrue(shp.flightsTab.isDisplayed());
        assertTrue(shp.carHireTab.isDisplayed());
        assertTrue(shp.hotelsTab.isDisplayed());
        assertTrue(shp.insuranceTab.isDisplayed());
    }

    @Test(description = "verify flight search with filters", enabled = true)
    public void testCostFilter() throws ParseException {
        SuperHomePage shp = new SuperHomePage(driver);
        shp.openFlightsTab();
        shp.setDepartAirport("los angeles", "LAX");
        shp.setDestinationAirport("rome", "FCO");
        shp.setDepartDate("20 Feb 16");
        shp.setReturnDate("27 Feb 16");
        shp.setAdultsAmount("1");
        ResultPage result = shp.clickSearchButton();
        result.waitResultsUploaded();
        assertEquals(result.verifyHeader(), "LAX to FCO");
        result.setFilterByAirlines("Aeroflot Russian Airlines");
        result.setSliderFilter("Cost", 10, -100);
        result.verifyFilterResults("Aeroflot Russian Airlines");
    }

}
