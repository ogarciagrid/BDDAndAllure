package com.griddynamics.demos.bdd.steps;

import com.griddynamics.demos.bdd.model.StepContext;
import com.griddynamics.demos.bdd.utilities.ResourcesManager;
import com.griddynamics.qa.sprimber.engine.model.action.Actions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


@Actions
public class DemoSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoSteps.class);

    private final StepContext stepContext;
    private static ChromeDriverService service;
    private WebDriver driver;
    private ResourcesManager resourcesManager = new ResourcesManager();

    public DemoSteps(StepContext stepContext) { this.stepContext = stepContext;}



    @Before
    public void setup() throws MalformedURLException {
        // Path to driver
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(resourcesManager.getFilePath("chromedriver")))
                .usingAnyFreePort()
                .build();
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


        ChromeOptions options = new ChromeOptions();
        //FirefoxOptions options = new FirefoxOptions();

        //options.addArguments("headless");

        options.addArguments("whitelisted-ips");
        options.addArguments("no-sandbox");
        options.addArguments("disable-extensions");

        driver = new RemoteWebDriver(service.getUrl(),options);

    }

    @Given("I am at home page")
    public void givenIamAtHomePage(){
        LOGGER.info("I am at the Given Step");
        LOGGER.info("I am opening the browser");
        driver.get("https://www.griddynamics.com");
    }

    @When("I click over Services link")
    public void whenIClickOverServicesLink(){
        LOGGER.info("I am t the When Step");
        driver.findElement(By.xpath("//a[@href='/services']")).click();
    }

    @Then("Services page is displayed")
    public void thenServicesPageIsDisplayed(){
        LOGGER.info("I am at the Then Step");
        Assert.isTrue("Both experience and culture matter".contentEquals(driver.findElement(By.tagName("h2")).getText()),"The text does not match");
    }

    @After
    public void terminate(){
        if (driver !=null)
            driver.quit();
    }

}
