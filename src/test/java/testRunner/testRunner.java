package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features =
                "/Users/soham/Documents/Sky/src/test/resources/Features/test.feature",
        glue = "stepDefinitions"
        //tags = "@test"
)


public class testRunner {

}
