package epam.com.tsm.ui;

import epam.com.tsm.logger.Logging;
import epam.com.tsm.webdriver.WebdriverSingleton;
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
        try {
            WebdriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).click();
            Logging.getLogger().debug("Clicked on the element with locator: " + this.getLocator().getValue());
        }
        catch (Exception e){
            Logging.getLogger().error("Element with locator: " + this.getLocator().getValue() + " not found!");
        }
    }


    public void submit() {
        try {
            this.submit();
            Logging.getLogger().debug("Submitted element with locator: " + this.getLocator().getValue());

        }
        catch (Exception e){
            Logging.getLogger().error("Element with locator: " + this.getLocator().getValue() + " not found!");
        }
    }


    public void sendKeys(CharSequence... keysToSend) {
        try {
            WebdriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).sendKeys(keysToSend);
            Logging.getLogger().debug("Sent keys to the element with locator: " + this.getLocator().getValue());
        }
        catch (Exception e){
            Logging.getLogger().error("Element with locator: " + this.getLocator().getValue() + " not found!");
        }
    }


    public void clear() {
        try {
            WebdriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).clear();
            Logging.getLogger().debug("Cleared element with locator: " + this.getLocator().getValue());
        }
        catch (Exception e){
            Logging.getLogger().error("Element with locator: " + this.getLocator().getValue() + " not found!");
        }
    }


    public String getTagName() {
        try {
            String tagName = WebdriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).getTagName();
            Logging.getLogger().debug("Got tag of element with locator: " + this.getLocator().getValue());
            return tagName;
        }
        catch (Exception e){
            Logging.getLogger().error("Element with locator: " + this.getLocator().getValue() + " not found!");
            return null;
        }
    }


    public String getAttribute(String name) {
        try {
            String attr = WebdriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).getAttribute(name);
            Logging.getLogger().debug("Got attribute of element with locator: " + this.getLocator().getValue());
            return attr;
        }
        catch (Exception e){
            Logging.getLogger().error("Element with locator: " + this.getLocator().getValue() + " not found!");
            return null;
        }
    }


    public boolean isSelected() {
        try {
            boolean selected = WebdriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).isSelected();
            Logging.getLogger().debug("Selected of element with locator: " + this.getLocator().getValue());
            return selected;
        }
        catch (Exception e){
            Logging.getLogger().error("Element with locator: " + this.getLocator().getValue() + " not found!");
            return false;
        }
    }


    public boolean isEnabled() {
        try {
            boolean enabled = WebdriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).isEnabled();
            Logging.getLogger().debug("Defined enabled/disabled state of element with locator: " + this.getLocator().getValue());
            return enabled;
        }
        catch (Exception e){
            Logging.getLogger().error("Element with locator: " + this.getLocator().getValue() + " not found!");
            return false;
        }
    }


    public String getText() {
        try {
            String text = WebdriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).getText();
            Logging.getLogger().debug("Got text of element with locator: " + this.getLocator().getValue());
            return text;
        }
        catch (Exception e){
            Logging.getLogger().error("Element with locator: " + this.getLocator().getValue() + " not found!");
            return null;
        }
    }

    public boolean isDisplayed() {
        try {
            boolean displ = WebdriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).isDisplayed();
            Logging.getLogger().debug("Defined if displayed/hidden element with locator: " + this.getLocator().getValue());
            return displ;
        }
        catch (Exception e){
            Logging.getLogger().error("Element with locator: " + this.getLocator().getValue() + " not found!");
            return false;
        }
    }


    public Point getLocation() {
        try {
            Point location = this.getLocation();
            Logging.getLogger().debug("Got location of element with locator: " + this.getLocator().getValue());
            return location;
        }
        catch (Exception e){
            Logging.getLogger().error("Element with locator: " + this.getLocator().getValue() + " not found!");
            return null;
        }
    }


    public Dimension getSize() {
        try {
            Dimension dim = WebdriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).getSize();
            Logging.getLogger().debug("Got size of element with locator: " + this.getLocator().getValue());
            return dim;
        }
        catch (Exception e){
            Logging.getLogger().error("Element with locator: " + this.getLocator().getValue() + " not found!");
            return null;
        }
    }


    public Rectangle getRect() {
        try {
            Rectangle rect = WebdriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).getRect();
            Logging.getLogger().debug("Got rect of element with locator: " + this.getLocator().getValue());
            return rect;
        }
        catch (Exception e){
            Logging.getLogger().error("Element with locator: " + this.getLocator().getValue() + " not found!");
            return null;
        }
    }


    public String getCssValue(String propertyName) {
        try {
            String css = WebdriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()).getCssValue(propertyName);
            Logging.getLogger().debug("Got CSS vale of element with locator: " + this.getLocator().getValue());
            return css;
        }
        catch (Exception e){
            Logging.getLogger().error("Element with locator: " + this.getLocator().getValue() + " not found!");
            return null;
        }
    }


    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        try {
            Logging.getLogger().debug("Got screenshot of element with locator: " + this.getLocator().getValue());
            return this.getScreenshotAs(target);
        }
        catch (Exception e){
            Logging.getLogger().error("Element with locator: " + this.getLocator().getValue() + " not found!");
            return null;
        }
    }


    public void selectAutocompletedValue(String valueToSelect, String abbrValue){
        List<WebElement> elements = WebdriverSingleton.getWebDriverInstance().findElements(this.getLocator().getBy());
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
            Logging.getLogger().debug("Selecte autocomplete value of element with locator: " + this.getLocator().getValue());
            return;
        }
        else {
            Logging.getLogger().error("Element with locator: " + this.getLocator().getValue() + " not found!");
            fail("Specified value: " + valueToSelect + " was not found!");
        }
    }

    public void dragAndDropElement(int valueX, int valueY){
        try {
            Actions builder = new Actions(WebdriverSingleton.getWebDriverInstance());
            builder.dragAndDropBy(WebdriverSingleton.getWebDriverInstance().findElement(this.getLocator().getBy()), valueX, valueY).build().perform();
            Logging.getLogger().debug("Dragged and dropped element with locator: " + this.getLocator().getValue());
        }
        catch (Exception e){
            Logging.getLogger().error("Element with locator: " + this.getLocator().getValue() + " not found!");
        }
    }

    public List<WebElement> getList(){
        try {
            List<WebElement> list = WebdriverSingleton.getWebDriverInstance().findElements(this.getLocator().getBy());
            Logging.getLogger().debug("Got list of elements with locator: " + this.getLocator().getValue());
            return list;
        }
        catch (Exception e){
            Logging.getLogger().error("Element with locator: " + this.getLocator().getValue() + " not found!");
        }
        return null;
    }

    public int getListSize(){
        try {
            List<WebElement> located_elements = WebdriverSingleton.getWebDriverInstance().findElements(this.getLocator().getBy());
            int count = 0;
            for (WebElement located_element : located_elements) {
                count++;
            }
            Logging.getLogger().debug("Got size of element with locator: " + this.getLocator().getValue());
            return count;
        }
        catch (Exception e){
            Logging.getLogger().error("Element with locator: " + this.getLocator().getValue() + " not found!");
        }
        return 0;
    }


}
