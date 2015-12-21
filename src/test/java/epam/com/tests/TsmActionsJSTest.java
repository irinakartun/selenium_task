package epam.com.tests;

import epam.com.tsm.pom.ResultPage;
import epam.com.tsm.pom.SuperHomePage;
import org.testng.annotations.Test;

import java.text.ParseException;

import static org.testng.Assert.assertEquals;

/**
 * Created by Irina_Kartun on 12/16/2015.
 */
public class TsmActionsJSTest extends BasicTest{

    @Test(description = "test with actions and java script execution")
    public void actionsPlusJavaScriptTest() throws ParseException {
        SuperHomePage shp = new SuperHomePage(driver);
        shp.goToFlightsTab();
        shp.typeFromAirport("London - All Airports (LON)");
        shp.typeToAirport("Barcelona - El Prat Apt (BCN), Barcelona, Catalonia, Spain");
        shp.execJSFromDate("23 Dec 15");
        shp.execJSToDate("31 Dec 15");
        shp.checkDirectOnly();
        shp.selectAdults("1");
        ResultPage result = shp.clickSearch();
        result.waitResultsUploaded();
        assertEquals(result.verifyHeader(), "LON to BCN");
        result.changeCostFilter(50, -100);
        result.verifyFilterByCost();
    }

}
