package com.cydeo.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

/*
In the class we will be able to pass pre- & post- conditions to
 each scenario and each step
 */
public class Hooks {
    //import from io.cucumber.java not from junit
    //@Before (order = 1)
    @Before(order = 0)
    public void setUp(){
        System.out.println("====Setting up browser using cucumber @Before");
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
    public void tearDown(){
        System.out.println("=====Closing browser using Cucumber After ");
    }
    // @BeforeStep
    public void setupStep(){
        System.out.println("--------> applying setup using @BeforeStep");
    }

    //@AfterStep
    public void afterStep(){
        System.out.println("--------> applying tearDown using @AfterStep");
    }


}
