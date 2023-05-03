package com.cydeo.step_definitions;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

/*
In the class we will be able to pass pre- & post- conditions to
 each scenario and each step
 */
public class Hooks {
    //import from io.cucumber.java not from junit
    //@Before (order = 1)
    @Before(order = 0)
    public void setUp(){
        System.out.println("Before Method");
    }

    //@Before (value = "@login", order = 2)
    public void setupScenarioForLogins(){
        System.out.println("====this will only apply to scenarios with @login tag");
    }

    //@Before (value = "@db", order = 0)
    public void setupForDatabaseScenarios(){
        System.out.println("====this will only apply to scenarios with @db tag");
    }


    @After
    public void tearDownScenario(Scenario scenario){
        //scenario.isFailed() --> if scenario fails this method will return TRUE boolean value


       if (scenario.isFailed()) {

           byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
           scenario.attach(screenshot, "image/png", scenario.getName());

       }
         BrowserUtils.sleep(5);
        Driver.closeDriver();
    }
     @BeforeStep
    public void setupStep(){
        System.out.println("--------> applying setup using @BeforeStep");
    }

    @AfterStep
    public void afterStep(){
        System.out.println("--------> applying tearDown using @AfterStep");
    }


}
