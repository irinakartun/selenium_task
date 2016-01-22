package epam.com.tsm.controls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Irina_Kartun on 1/21/2016.
 */
public class Wait {

    private WebDriver driver;
    private WebElement loader;

    public Wait(WebDriver driver, WebElement loader){
        this.driver = driver;
        this.loader = loader;
    }

    public void waitElementIsPresent (){
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.visibilityOf(loader));
    }
}
