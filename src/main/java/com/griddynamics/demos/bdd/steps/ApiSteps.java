package com.griddynamics.demos.bdd.steps;

import com.griddynamics.qa.sprimber.engine.model.action.Actions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Actions
public class ApiSteps
{
    private static Logger LOGGER = LoggerFactory.getLogger(ApiSteps.class);

    @Given("I request the weather for <location>")
    public void getWeather(String zipCode){
        LOGGER.info("Executing getting weather via Zip Code");
    }

    @Then("I get the weather")
    public void getWeatherForecast(String city){
        LOGGER.info("");

    }
}
