package epam.com.tsm.pom;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Irina_Kartun on 12/5/2015.
 */
public class AbstractPage {

    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public void executeJS(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
    }

    public void takeScreenshot(WebDriver driver) {

        File screenshotFolder = new File("./output/screenshots");

        if (!screenshotFolder.exists()) {
            System.out.println("Creating directory: " + screenshotFolder);
            boolean result = false;
            try {
                screenshotFolder.mkdir();
                result = true;
            }
            catch (SecurityException se){
            }
            if(result) {
                System.out.println("Screenshots directory was successfully created");
            }
        }

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy-h-mm-ss-a");
        String formattedDate = sdf.format(date);

        String fileName = "screenshot-" + formattedDate;
        try {
            FileUtils.copyFile(scrFile, new File(String.format("./output/screenshots/%s.png", fileName)));
            System.out.println(String.format("%s.png was successfully taken", fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
