package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/resources/features",   // путь к .feature-файлам
            glue = {"steps"},                           // путь к шагам (CommonSteps.java)
            plugin = {"pretty", "html:target/report.html"},
            monochrome = true
    )
    public class TestRunner {
    }

