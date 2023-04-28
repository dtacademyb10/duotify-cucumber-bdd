package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (

//       "@smoke and @positive", // runs scenarios that have both @smoke and @positive at the same time
//       "@smoke or @positive", // runs scenarios that have either @smoke or @positive
//        tags = "not @smoke", // runs scenarios that have do NOT have @smoke tag
//        you could combine any number or type of tags -> "@positive and @signUp or @smoke"
        // omitting tags entirely will run everything under the given path in features, you could use it to run regression

        tags = "@db_only",
//

        features = "src/test/resources", // the path where all feature files are located
        glue = "stepDefinitions", // path where all step definition classes are located
        stepNotifications = true,  // to display detailed step results
        plugin = {
                "pretty", // adds more detailed output log in the cmd console
               "html:target/basic-report/report.html"  // to generate a basic built-in report
        }

//        ,dryRun = true  // to generate step definition snippets without actually running the scenario

)
public class CucumberRunner {
}
