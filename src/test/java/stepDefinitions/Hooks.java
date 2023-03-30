package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ConfigReader;
import utils.Driver;

import java.time.Duration;

public class Hooks {



    @Before () // runs before each scenario tagged with @UI
    public void setUpScenario(){
        Driver.getDriver().get(ConfigReader.getProperty("homepage"));
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Driver.getDriver().manage().window().maximize();
    }

//    @Before ("@DB") // runs before each scenario tagged with @UI
//    public void setUpScenarioForDbTests(){
//        //Configuration for DB tests
//    }
//
//    @After ("@DB") // runs before each scenario tagged with @UI
//    public void tearDownScenarioForDbTests(){
//        //Configuration for DB tests
//    }


    @After () // after each scenario
    public void tearDownScenario(Scenario scenario){
        if(scenario.isFailed()){
            scenario.attach(((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES), "image/png", "screenshot");
        }

        Driver.quitDriver();
    }

}
