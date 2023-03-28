package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;
import utils.Driver;

import java.time.Duration;

public class Hooks {



    @Before // runs before each scenario
    public void setUpScenario(){
        Driver.getDriver().get(ConfigReader.getProperty("homepage"));
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Driver.getDriver().manage().window().maximize();
    }


    @After  // after each scenario
    public void tearDownScenario(){
        Driver.quitDriver();
    }

}
