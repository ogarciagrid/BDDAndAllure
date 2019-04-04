package com.griddynamics.demos.bdd.steps;

import com.griddynamics.demos.bdd.model.StepContext;
import com.griddynamics.qa.sprimber.engine.model.action.Actions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;


@Actions
public class DemoSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoSteps.class);

    private final StepContext stepContext;
    private WebDriver driver;

    public DemoSteps(StepContext stepContext) { this.stepContext = stepContext;}

    @Before
    public void setup() throws MalformedURLException {
//        ChromeOptions options = new ChromeOptions();
        FirefoxOptions options = new FirefoxOptions();

        options.addArguments("headless");
        options.addArguments("whitelisted-ips");
        options.addArguments("no-sandbox");
        options.addArguments("disable-extensions");




        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),options);

    }

    @Given("I am at home page")
    public void givenIamAtHomePage(){
        LOGGER.info("I am at the Given Step");
        LOGGER.info("I am opening the browser");
        driver.get("https://www.griddynamics.com");
    }

    @When("I click over Services link")
    public void whenIClickOverServicesLink(){LOGGER.info("I am t the When Step");}

    @Then("Services page is displayed")
    public void thenServicesPageIsDisplayed(){LOGGER.info("I am at the Then Step");}

    @After
    public void terminate(){
        if (driver !=null)
            driver.quit();
    }

}
