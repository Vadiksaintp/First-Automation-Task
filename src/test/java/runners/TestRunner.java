package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/resources/features",   // path to .feature files
            glue = {"steps"},                           // path to steps (CommonSteps.java)
            plugin = {"pretty", "html:target/report.html"},
            monochrome = true
    )
    public class TestRunner {
    }

