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


    @Test(description = "verify superHomePage", enabled = false)
    public void testSuperhomepage(){
        SuperHomePage shp = new SuperHomePage(driver);
        assertTrue(shp.isLogoPresented());
        assertTrue(shp.isMenuPresented());
        assertTrue(shp.isHeroPresented());
        assertTrue(shp.isSearchGadgetPresented());
        assertTrue(shp.isHolidayTabPresented());
        assertTrue(shp.isFlightTabPresented());
        assertTrue(shp.isHotelsTabPresented());
        assertTrue(shp.isCarHireTabPresented());
        assertTrue(shp.isInsuranceTabPresented());
    }

    @Test(description = "verify flight search", enabled = true)
    public void testFlightSearch() throws ParseException {
        SuperHomePage shp = new SuperHomePage(driver);
        ResultPage result = shp.searchFlights("los angeles", "LAX", "rome", "FCO", "19 Feb 16", "25 Feb 16", false, "1");
        result.waitResultsUploaded();
        assertEquals(result.verifyHeader(), "LAX to FCO");
        result.filterByCost(50, -100);
    }



}
