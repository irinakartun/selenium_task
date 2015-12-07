package epam.com.tsm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Irina_Kartun on 12/5/2015.
 */
public class ResultPage extends AbstractPage {

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='results-summary results-summary--complete']")
    private WebElement uploadedResults;

    @FindBy(xpath = "//div[@class='results-list-wrapper']//h1")
    private WebElement header;

    public ResultPage waitResultsUploaded(){
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.visibilityOf(uploadedResults));
        return this;
    }

    public String verifyHeader(){
        return header.getText();
    }



}
