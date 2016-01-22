package epam.com.tsm.businessObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import static com.thoughtworks.selenium.SeleneseTestBase.fail;

/**
 * Created by Irina_Kartun on 1/21/2016.
 */
public class CostFilter extends DragDropFilter {

    WebElement lowValue;
    WebElement highValue;
    WebElement next;

    public CostFilter(WebDriver driver, WebElement leftFilter, WebElement rightFilter, WebElement lowValue, WebElement highValue, WebElement next) {
        super(driver, leftFilter, rightFilter);
        this.lowValue = lowValue;
        this.highValue = highValue;
        this.next = next;
    }


    @Override
    public void verifyFilter() throws ParseException {
        float lowCost = parseCurrencyToNumber(lowValue.getText().trim());
        float highCost = parseCurrencyToNumber(highValue.getText().replace(" - ", "").trim());
        List<WebElement> pricesList = driver.findElements(By.xpath("//*[@class='ng-scope ng-isolate-scope']//*[@class='card__price']"));

        for (int i = 0; i < pricesList.size(); i++) {
            if ( (parseCurrencyToNumber(pricesList.get(i).getText().trim()) >= lowCost) && (parseCurrencyToNumber(pricesList.get(i).getText().trim()) <= highCost) ){
                continue;
            }
            else {
                fail("Cost filter does not work correct!");
            }
        }
        if (next.isDisplayed()){
            next.click();
            verifyFilter();
        }
        else{
            return;
        }
    }


    private float parseCurrencyToNumber(String currencyString) throws ParseException {
        Locale locale = Locale.UK;
        Number number = NumberFormat.getCurrencyInstance(locale).parse(currencyString);
        return number.floatValue();
    }
}
