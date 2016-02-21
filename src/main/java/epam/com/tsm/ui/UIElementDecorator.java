package epam.com.tsm.ui;

import epam.com.tsm.webdriver.WebdriverSingleton;
import org.openqa.selenium.*;

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
        WebdriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).click();
    }

    @Override
    public void submit() {
        this.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        WebdriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        WebdriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).clear();
    }

    @Override
    public String getTagName() {
        return WebdriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return WebdriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return WebdriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).isSelected();
    }

    @Override
    public boolean isEnabled() {
        return WebdriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).isEnabled();
    }

    @Override
    public String getText() {
        return WebdriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return WebdriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return this.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        System.out.println("This is an example of WebElement class decoration!");
        return WebdriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).isDisplayed();
    }

    @Override
    public Point getLocation() {
        return this.getLocation();
    }

    @Override
    public Dimension getSize() {
        return WebdriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).getSize();
    }

    @Override
    public Rectangle getRect() {
        return WebdriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return WebdriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return this.getScreenshotAs(target);
    }


}
