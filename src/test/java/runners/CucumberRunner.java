package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        tags = "@currentTest", // runs scenarios with the given tag only
        features = "src/test/resources", // the path where all feature files are located
        glue = "stepDefinitions", // path where all step definition classes are located
        stepNotifications = true  // to display detailed step results
//        ,dryRun = true  // to generate step definition snippets without actually running the scenario

)
public class CucumberRunner {
}
