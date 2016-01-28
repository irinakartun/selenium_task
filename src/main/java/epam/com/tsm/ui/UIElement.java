package epam.com.tsm.ui;

import epam.com.tsm.webdriver.WebDriverSingleton;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.testng.AssertJUnit.fail;

/**
 * Created by Irina_Kartun on 1/24/2016.
 */
public class UIElement {

    private Locator locator;

    public UIElement(Locator loc){
        this.locator = loc;
    }


    public Locator getLocator(){
        return locator;
    }


    public void click() {
        WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).click();
    }


    public void submit() {
        this.submit();
    }


    public void sendKeys(CharSequence... keysToSend) {
        WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).sendKeys(keysToSend);
    }


    public void clear() {
        WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).clear();
    }


    public String getTagName() {
        return WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).getTagName();
    }


    public String getAttribute(String name) {
        return WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).getAttribute(name);
    }


    public boolean isSelected() {
        return WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).isSelected();
    }


    public boolean isEnabled() {
        return WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).isEnabled();
    }


    public String getText() {
        return WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).getText();
    }

    public boolean isDisplayed() {
        return WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).isDisplayed();
    }


    public Point getLocation() {
        return this.getLocation();
    }


    public Dimension getSize() {
        return WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).getSize();
    }


    public Rectangle getRect() {
        return WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).getRect();
    }


    public String getCssValue(String propertyName) {
        return WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).getCssValue(propertyName);
    }


    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return this.getScreenshotAs(target);
    }


    public void selectAutocompletedValue(String valueToSelect, String abbrValue){
        List<WebElement> elements = WebDriverSingleton.getWebDriverInstance().findElements(this.getLocator().getBy());
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

    public void dragAndDropElement(int valueX, int valueY){
        Actions builder = new Actions(WebDriverSingleton.getWebDriverInstance());
        builder.dragAndDropBy(WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()), valueX, valueY).build().perform();
    }

    public List<WebElement> getList(){
        return WebDriverSingleton.getWebDriverInstance().findElements(this.getLocator().getBy());
    }

    public int getListSize(){
        List<WebElement> located_elements = WebDriverSingleton.getWebDriverInstance().findElements(this.getLocator().getBy());
        int count=0;
        for(WebElement located_element : located_elements){
            count++;
        }
        return count;
    }


}
