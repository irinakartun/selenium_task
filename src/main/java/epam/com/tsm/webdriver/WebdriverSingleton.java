package epam.com.tsm.webdriver;

import epam.com.tsm.ui.UIElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.AssertJUnit.fail;

/**
 * Created by Irina_Kartun on 1/23/2016.
 */
public class WebDriverSingleton {

    private static WebDriver driver;

    private WebDriverSingleton() {}

    public static WebDriver getWebDriverInstance() {
        if (null == driver) {
            driver = new FirefoxDriver();
//            driver = new WebDriverDecorator(driver);
        }
        return driver;
    }

    public static void closeWebDriver(){
        driver.close();
        driver.quit();
        driver = null;
    }

    public static void waitElementIsPresented (UIElement element){
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(element.getLocator().getBy()));
    }

    /*
    public static void highlightElement(UIElement elementToHighlight) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='5px groove red'", elementToHighlight.getLocator().getBy());
    }


    public static WebElement locate(UIElement element){
        return driver.findElement(element.getLocator().getBy());
    }

    public static void click(UIElement element){
        locate(element).click();
    }

    public static void submit(UIElement element){
        locate(element).submit();
    }

    public static void sendKeys(UIElement element){
        locate(element).submit();
    }

    public static String getText(UIElement element) {
        return locate(element).getText();
    }

    public static void setText(UIElement element, String valueToSet) {
        locate(element).sendKeys(valueToSet);
    }

    public static String getAttribute(UIElement element, String attributeName){
        return locate(element).getAttribute(attributeName);
    }

    public static boolean isVisible(UIElement element) {
        return locate(element).isDisplayed();
    }

    public static boolean isSelected(UIElement element) {
        return locate(element).isSelected();
    }

    public static void selectValueFromTheList(UIElement element, String text){
        Select selectElement = new Select(locate(element));
        selectElement.selectByVisibleText(text);
    }
/*
    public static void selectAutocompletedValue(UIElement element, String valueToSelect, String abbrValue){
        List<WebElement> elements = driver.findElements(element.getLocator().getBy());
        boolean found = false;
        for (int i = 0; i < elements.size(); i++) {
            elements.get(i).sendKeys(Keys.DOWN);
            if (elements.get(i).getAttribute("focus-on").equals(abbrValue)) {
                elements.get(i).click();
                found = true;
                break;
            }
        }
        if (found) {
            return;
        }
        else {
            fail("Specified value: " + valueToSelect + " was not found!");
        }
    }

    public static List<WebElement> getList(UIElement element){
        return driver.findElements(element.getLocator().getBy());
    }

    public static int getSize(UIElement element){
        List<WebElement> located_elements = driver.findElements(element.getLocator().getBy());
        int count=0;
        for(WebElement located_element : located_elements){
            count++;
        }
        return count;
    }


    public static void highlightElement(UIElement elementToHighlight) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='5px groove red'", elementToHighlight.getLocator().getBy());
    }
/*
    public static JavascriptExecutor initJS(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }
*/

}
