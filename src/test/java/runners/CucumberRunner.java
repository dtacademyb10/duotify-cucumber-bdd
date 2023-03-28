package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        tags = "@current", // runs scenarios with the given tag only
        features = "src/test/resources", // the path where all feature files are located
        glue = "stepDefinitions" // path where all step definition classes are located

)
public class CucumberRunner {
}
