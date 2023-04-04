package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {
public static void verifyURLContains(String expectedInUrl){
    Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInUrl));
}

    /**
     * This method will accept a dropdown as a WebElement
     * and return all the options' text in a List of String.
     * @param dropdownElement
     * @return List<String> actualOptionsAsString
     */
    public static List<String> dropdownOptionsAsString(WebElement dropdownElement){
        Select select = new Select(dropdownElement);

        //List of all ACTUAL month <options> as a web element
        List<WebElement> actualOptionsAsWebElement = select.getOptions();

        //List of all ACTUAL month <options> as a string
        List<String> actualOptionsAsString= new ArrayList<>();

        for (WebElement each : actualOptionsAsWebElement) {
            actualOptionsAsString.add(each.getText());
        }

        return  actualOptionsAsString;

    }

}
