package epam.com.tsm.pom;

import org.openqa.selenium.WebDriver;

/**
 * Created by Irina_Kartun on 12/5/2015.
 */
public class AbstractPage {

    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }


}
