package epam.com.tests;

import epam.com.tsm.pom.SuperHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Irina_Kartun on 12/14/2015.
 */
public class BasicTest {

    DesiredCapabilities capability = DesiredCapabilities.firefox();

    WebDriver driver;

    @BeforeMethod(description = "driver setup")
    public void setUp() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
        driver.get(SuperHomePage.SHP_URL);
    }

    @AfterMethod(description = "driver cleanup")
    public void cleanUp(){
        driver.close();
        driver.quit();
    }

}
