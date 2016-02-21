package epam.com.tests;

import epam.com.tsm.pom.SuperHomePage;
import epam.com.tsm.webdriver.WebdriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

/**
 * Created by Irina_Kartun on 12/14/2015.
 */
public class BasicTest {

//    DesiredCapabilities capability = DesiredCapabilities.firefox();

    WebDriver driver;

    @BeforeMethod(description = "driver setup")
    public void setUp()  {
//        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
//        driver = new FirefoxDriver();
        driver = WebdriverSingleton.getWebDriverInstance();
        driver.get(SuperHomePage.SHP_URL);
    }

    @AfterMethod(description = "driver cleanup")
    public void cleanUp(){
//        driver.close();
//        driver.quit();
        WebdriverSingleton.closeWebDriver();
    }

}
