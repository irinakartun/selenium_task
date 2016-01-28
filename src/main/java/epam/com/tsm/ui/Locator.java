package epam.com.tsm.ui;

import org.openqa.selenium.By;

/**
 * Created by Irina_Kartun on 1/24/2016.
 */
public class Locator {

    private LocatorType type;
    private String value;

    public Locator(LocatorType type, String value){
        this.type = type;
        this.value = value;
    }

    public LocatorType getType(){
        return type;
    }

    public String getValue(){
        return value;
    }


    public By getBy(){
        switch(type){
            case XPATH:
                return new By.ByXPath(value);
            case ID:
                return new By.ById(value);
            case NAME:
                return new By.ByName(value);
            case LINKTEXT:
                return new By.ByLinkText(value);
            case TAG:
                return new By.ByTagName(value);
            default:
                throw new RuntimeException("Specified locator type is not implemented: " + type);
        }
    }

}
