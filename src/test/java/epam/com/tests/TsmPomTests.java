package epam.com.tests;

import epam.com.tsm.pom.ResultPage;
import epam.com.tsm.pom.SuperHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Irina_Kartun on 12/5/2015.
 */
public class TsmPomTests {

    WebDriver driver;

    @BeforeMethod(description = "driver setup")
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get(SuperHomePage.SHP_URL);
    }

    @Test(description = "verify superHomePage")
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

    @Test(description = "verify flight search")
    public void testFlightSearch(){
        SuperHomePage shp = new SuperHomePage(driver);
        shp.goToFlightsTab();
        shp.setFromAirport("los angeles", "LAX");
        shp.setToAirport("rome", "FCO");
        shp.setFromDate("23 Dec 15");
        shp.setToDate("31 Dec 15");
        shp.checkDirectOnly();
        shp.selectAdults("1");
        ResultPage result = shp.clickSearch();
        result.waitResultsUploaded();
        assertEquals(result.verifyHeader(), "LAX to FCO");
    }

    @AfterMethod(description = "driver cleanup")
    public void cleanUp(){
        driver.close();
        driver.quit();
    }

}
