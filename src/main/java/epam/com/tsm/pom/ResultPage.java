package epam.com.tsm.pom;

import epam.com.tsm.businessObjects.CostFilter;
import epam.com.tsm.businessObjects.DragDropFilter;
import epam.com.tsm.controls.Wait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.ParseException;

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
        Wait waitResults = new Wait(driver, uploadedResults);
        waitResults.waitElementIsPresent();
    }

    public String verifyHeader(){
        highlightElements(header);
        return header.getText();
    }

    public void filterByCost(int lowValue, int highValue) throws ParseException {
        DragDropFilter filter = new CostFilter(driver, costLeftFilter, costRightFilter, costLowValue, costHighValue, nextPage);
        filter.setFilter(lowValue, highValue);
        filter.verifyFilter();
    }


/*
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
*/
    public void highlightElements(WebElement elementToHighlight) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='5px groove red'", elementToHighlight);
        takeScreenshot(driver);
    }





}
