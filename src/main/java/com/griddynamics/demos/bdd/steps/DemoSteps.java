package com.griddynamics.demos.bdd.steps;

import com.griddynamics.demos.bdd.model.StepContext;
import com.griddynamics.qa.sprimber.engine.model.action.Actions;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Actions
public class DemoSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoSteps.class);

    private final StepContext stepContext;
    private WebDriver driver;

    public DemoSteps(StepContext stepContext) { this.stepContext = stepContext;}

    @Before
    public void setup(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        //driver = new ChromeDriver(chromeOptions);

    }

    @Given("I am at home page")
    public void givenIamAtHomePage(){
        LOGGER.info("I am at the Given Step");
        LOGGER.info("I am opening the browser");
        //driver.get("https://www.griddynamics.com");
    }

    @When("I click over Services link")
    public void whenIClickOverServicesLink(){LOGGER.info("I am t the When Step");}

    @Then("Services page is displayed")
    public void thenServicesPageIsDisplayed(){LOGGER.info("I am at the Then Step");}

}
