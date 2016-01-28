package epam.com.tsm.ui;

import epam.com.tsm.webdriver.WebDriverSingleton;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.testng.AssertJUnit.fail;

/**
 * Created by Irina_Kartun on 1/24/2016.
 */
public class UIElementDecorator implements WebElement{

    private Locator locator;

    public UIElementDecorator(Locator loc){
        this.locator = loc;
    }


    public Locator getLocator(){
        return locator;
    }

    @Override
    public void click() {
        WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).click();
    }

    @Override
    public void submit() {
        this.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).clear();
    }

    @Override
    public String getTagName() {
        return WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).isSelected();
    }

    @Override
    public boolean isEnabled() {
        return WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).isEnabled();
    }

    @Override
    public String getText() {
        return WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return this.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        System.out.println("This is an example of WebElement class decoration!");
        return WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).isDisplayed();
    }

    @Override
    public Point getLocation() {
        return this.getLocation();
    }

    @Override
    public Dimension getSize() {
        return WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).getSize();
    }

    @Override
    public Rectangle getRect() {
        return WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return WebDriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return this.getScreenshotAs(target);
    }


}
