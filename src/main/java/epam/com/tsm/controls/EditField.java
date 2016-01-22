package epam.com.tsm.controls;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.thoughtworks.selenium.SeleneseTestBase.fail;

/**
 * Created by Irina_Kartun on 1/18/2016.
 */
public class EditField {

    private WebElement editForm;
    private WebElement autocompleteForm;
    private List<WebElement> autocompleteList;

    public EditField(WebElement editForm, WebElement autocompleteForm, List<WebElement> autocompleteList) {
        this.editForm = editForm;
        this.autocompleteForm = autocompleteForm;
        this.autocompleteList = autocompleteList;
    }

    public EditField(WebElement editForm){
        this.editForm = editForm;
    }

    public void selectAutocompleteValue(WebDriver driver, String setValue, String abbr){
        editForm.sendKeys(setValue);
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.visibilityOf(autocompleteForm));
        boolean found = false;
        for (int i = 0; i < autocompleteList.size(); i++) {
            autocompleteList.get(i).sendKeys(Keys.DOWN);
            if (autocompleteList.get(i).getAttribute("focus-on").equals(abbr)) {
                autocompleteList.get(i).click();
                found = true;
            }
        }
        if (found) {
            return;
        }
        else {
            fail("Specified value: " + setValue + " was not found!");
        }
    }


    public void setFormValue(WebDriver driver, String setValue){
        editForm.click();
        Actions builder = new Actions(driver);
        builder.sendKeys(setValue).build().perform();
    }

}
