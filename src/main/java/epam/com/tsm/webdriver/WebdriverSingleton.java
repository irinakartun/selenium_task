package epam.com.tsm.webdriver;

import epam.com.tsm.logger.Logging;
import epam.com.tsm.ui.UIElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.testng.AssertJUnit.fail;

/**
 * Created by Irina_Kartun on 1/23/2016.
 */
public class WebdriverSingleton {

    private static WebDriver driver;

    private WebdriverSingleton() {}

    public static WebDriver getWebDriverInstance() {
        if (null == driver) {
            driver = new FirefoxDriver();
            Logging.getLogger().info("Driver initialization");
//            driver = new WebDriverDecorator(driver);
        }
        return driver;
    }

    public static void closeWebDriver(){
        driver.close();
        driver.quit();
        driver = null;
        Logging.getLogger().info("Driver is closed");
    }

    public static void waitElementIsPresented (UIElement element){
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(element.getLocator().getBy()));
    }

    public static void takeScreenshot(WebDriver driver) {
        File screenshotFolder = new File("./output/screenshots");
        if (!screenshotFolder.exists()) {
            System.out.println("Creating directory: " + screenshotFolder);
            boolean result = false;
            try {
                screenshotFolder.mkdir();
                result = true;
            }
            catch (SecurityException se){
            }
            if(result) {
                System.out.println("Screenshots directory was successfully created");
            }
        }
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy-h-mm-ss-a");
        String formattedDate = sdf.format(date);
        String fileName = "screenshot-" + formattedDate;
        try {
            FileUtils.copyFile(scrFile, new File(String.format("./output/screenshots/%s.png", fileName)));
            System.out.println(String.format("%s.png was successfully taken", fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void highlightElement(UIElement elementToHighlight) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='5px groove red'", getWebElement(elementToHighlight));
    }

    private static WebElement getWebElement(UIElement element){
        return driver.findElement(element.getLocator().getBy());
    }

}
