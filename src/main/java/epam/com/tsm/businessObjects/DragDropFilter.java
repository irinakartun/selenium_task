package epam.com.tsm.businessObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.text.ParseException;

/**
 * Created by Irina_Kartun on 1/17/2016.
 */
public abstract class DragDropFilter {

    WebDriver driver;
    private WebElement leftFilter;
    private WebElement rightFilter;

    public DragDropFilter(WebDriver driver, WebElement leftFilter, WebElement rightFilter){
        this.driver = driver;
        this.leftFilter = leftFilter;
        this.rightFilter = rightFilter;
    }

    public void setFilter(int xLeft, int xRight){
        Actions builder = new Actions(driver);
        builder.dragAndDropBy(leftFilter, xLeft, 0).build().perform();
        builder.dragAndDropBy(rightFilter, xRight, 0).build().perform();
    }

    public abstract void verifyFilter() throws ParseException;    //for different types of filtes
}
