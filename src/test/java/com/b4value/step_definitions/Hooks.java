package com.b4value.step_definitions;

import com.b4value.utilities.ConfigurationReader;
import com.b4value.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;


public class Hooks {

    @Before("@ui")
    public void setUp(){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigurationReader.getProperty("b4valueURL"));

    }



    @After("@ui")
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        Driver.closeDriver();

    }


    }




