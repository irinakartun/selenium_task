package epam.com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Irina_Kartun on 12/4/2015.
 */
public class TsmTest {

   @Test
    public void testSuperHomePage(){
       WebDriver driver = new FirefoxDriver();
       driver.get("https://www.travelsupermarket.com/");
       WebElement logo = driver.findElement(By.xpath("//div[@class='site-logo']"));
       WebElement menu = driver.findElement(By.id("navigation-screen-toggle-area"));
       WebElement hero = driver.findElement(By.xpath("//h1[contains(., 'Welcome to our new home')]"));
       WebElement searchGadget = driver.findElement(By.tagName("search-gadget"));
       WebElement holidaysTab = driver.findElement(By.xpath("//button[@class='searchGadgetForm__channelOption ng-binding searchGadgetForm__channelOption--current'][contains(., 'Holidays')]"));
       WebElement flightsTab = driver.findElement(By.xpath("//button[contains(., 'Flights')]"));
       WebElement hotelsTab = driver.findElement(By.xpath("//button[contains(., 'Hotels')]"));
       WebElement carHireTab = driver.findElement(By.xpath("//button[contains(., 'Car Hire')]"));
       WebElement insuranceTab = driver.findElement(By.xpath("//button[contains(., 'Insurance')]"));

       assertTrue(logo.isDisplayed());
       assertTrue(menu.isDisplayed());
       assertTrue(hero.isDisplayed());
       assertTrue(searchGadget.isDisplayed());
       assertTrue(holidaysTab.isDisplayed());
       assertTrue(flightsTab.isDisplayed());
       assertTrue(hotelsTab.isDisplayed());
       assertTrue(carHireTab.isDisplayed());
       assertTrue(insuranceTab.isDisplayed());

       driver.close();
       driver.quit();
    }

    @Test
    public void testFlightsSearch() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.travelsupermarket.com/");
        WebDriverWait wait = new WebDriverWait(driver, 3000);

        String from = "LAX";
        String to = "LHR";

        WebElement flightsTab = driver.findElement(By.xpath("//button[contains(., 'Flights')]"));
        flightsTab.click();
        WebElement flyingFrom = driver.findElement(By.id("flyingFromField_input"));
        flyingFrom.sendKeys("los");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//auto-complete[@id='flyingFromField']/div/div")));
        WebElement airportFrom = driver.findElement(By.xpath("//button[@focus-on='" + from + "']"));
        airportFrom.click();

        WebElement flyingTo = driver.findElement(By.id("flyingToField_input"));
        flyingTo.sendKeys("lon");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//auto-complete[@id='flyingToField']/div/div")));
        WebElement airportTo = driver.findElement(By.xpath("//button[@focus-on='" + to + "']"));
        airportTo.click();

        WebElement departCalendar = driver.findElement(By.id("departureDate"));
        departCalendar.click();
        WebElement departDate = driver.findElement(By.xpath("//table[@id='departureDate_table']//div[@aria-label='23 Dec 15']"));
        departDate.click();

        WebElement returnCalendar = driver.findElement(By.id("returnDate"));
        returnCalendar.click();
        WebElement returnDate = driver.findElement(By.xpath("//table[@id='returnDate_table']//div[@aria-label='31 Dec 15']"));
        returnDate.click();

        WebElement adultsOptions = driver.findElement(By.xpath("//select[@id='flightsAdults']/option[contains(text(), '1')]"));
        adultsOptions.click();

        WebElement directFlights = driver.findElement(By.xpath("//label[contains(text(), 'Direct flights only')]"));
        directFlights.click();

        WebElement searchBtn = driver.findElement(By.xpath("//form[@name='flightsEnquiryForm']//button[@type='submit']"));
        searchBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='results-summary results-summary--complete']")));

        WebElement title = driver.findElement(By.xpath("//div[@class='results-list-wrapper']//h1"));
        assertEquals(title.getText(), from + " to " + to);

        driver.close();
        driver.quit();
    }


}
