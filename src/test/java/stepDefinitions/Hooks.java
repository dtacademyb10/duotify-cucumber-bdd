package stepDefinitions;

import io.cucumber.java.*;
import io.restassured.RestAssured;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ApiUtils;
import utils.ConfigReader;
import utils.DBUtils;
import utils.Driver;

import java.time.Duration;

public class Hooks {




    @Before ("not @db_only and not @api")
    public void setUpScenario(){

        String environment = System.getProperty("env");

        if(environment != null){
            switch (environment){
                case "QA":
                    Driver.getDriver().get(ConfigReader.getProperty("QA"));
                    break;
                case "STAGING":
                    Driver.getDriver().get(ConfigReader.getProperty("STAGING"));
                    break;
                case "DEV":
                    Driver.getDriver().get(ConfigReader.getProperty("DEV"));
                    break;
                default:
                    throw new RuntimeException("Not a valid environment.");

            }
        }else{
            Driver.getDriver().get(ConfigReader.getProperty("QA"));
        }

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Driver.getDriver().manage().window().maximize();



    }


    @Before ("@api")
    public void setUpScenarioForApiTests(){
        ApiUtils.prepareAPI();
    }


    @After ("@api")
    public void tearDownScenarioForApiTests(Scenario scenario){

        if(scenario.isFailed()){
            scenario.attach( ApiUtils.getResponse().asPrettyString(), "text/plain", "responseBody");
        }
    }



    @Before ("@DB")
    public void setUpScenarioForDbTests(){
        DBUtils.createConnection();
    }

    @After ("@DB")
    public void tearDownScenarioForDbTests(){
       DBUtils.close();
    }


    @After ("not @db_only and not @api")
    public void tearDownScenario(Scenario scenario){
        if(scenario.isFailed()){
            scenario.attach(((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES), "image/png", "screenshot");
        }

        Driver.quitDriver();

    }

}
