package epam.com.tsm.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import static com.thoughtworks.selenium.SeleneseTestBase.fail;

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

    @FindBy(xpath = ".//*[@tracking-label='Cost']//*[@class='noUi-handle noUi-handle-lower']")
    private WebElement costLeftFilter;

    @FindBy(xpath = ".//*[@tracking-label='Cost']//*[@class='noUi-handle noUi-handle-upper']")
    private WebElement costRightFilter;

    @FindBy(xpath = ".//*[@tracking-label='Cost']//*[@class='filter-slider__value filter-slider__value--low ng-binding']")
    private WebElement costLowValue;

    @FindBy(xpath = ".//*[@tracking-label='Cost']//*[@class='filter-slider__value filter-slider__value--high ng-binding']")
    private WebElement costHighValue;

    @FindBy(linkText = "Reset filters")
    private WebElement resetFilter;

    @FindBy(xpath = "//*[@role='navigation']//button[contains(., 'Next')]")
    private WebElement nextPage;



    public void waitResultsUploaded(){
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.visibilityOf(uploadedResults));
    }

    public String verifyHeader(){
        highlightElements(header);
        return header.getText();
    }

    public void changeCostFilter(int xLeft, int xRight){
 //       if (resetFilter.isDisplayed()){
 //           resetFilter.click();
 //       }
        Actions builder = new Actions(driver);
        builder.dragAndDropBy(costLeftFilter, xLeft, 0).build().perform();
        builder.dragAndDropBy(costRightFilter, xRight, 0).build().perform();
    }

    private float parseCurrencyToNumber(String currencyString) throws ParseException {
        Locale locale = Locale.UK;
        Number number = NumberFormat.getCurrencyInstance(locale).parse(currencyString);
        return number.floatValue();
    }

    public void verifyFilterByCost() throws ParseException {

        float lowCost = parseCurrencyToNumber(costLowValue.getText().trim());
        float highCost = parseCurrencyToNumber(costHighValue.getText().replace(" - ", "").trim());
        List<WebElement> pricesList = driver.findElements(By.xpath("//*[@class='ng-scope ng-isolate-scope']//*[@class='card__price']"));

        for (int i = 0; i < pricesList.size(); i++) {
            if ( (parseCurrencyToNumber(pricesList.get(i).getText().trim()) >= lowCost) && (parseCurrencyToNumber(pricesList.get(i).getText().trim()) <= highCost) ){
                continue;
            }
            else {
                fail("Cost filter does not work correct!");
            }
        }
        if (nextPage.isDisplayed()){
            nextPage.click();
            verifyFilterByCost();
        }
        else{
            return;
        }

    }

    public void highlightElements(WebElement elementToHighlight) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='5px groove red'", elementToHighlight);
        takeScreenshot(driver);
    }





}
