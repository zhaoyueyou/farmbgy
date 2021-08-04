package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Feature"},
        plugin = {"html:target/cucumber-reports/html",
                "json:target/cucumber-reports/cucumber03.json",
                "junit:target/cucumber-reports/cucumber.xml",
                "pretty"},
        glue = {"Setprecision"},
        tags = {"@facilities_cp03"}
)

public class RunCukesTest03 {
    static {
        System.out.println("********** 01");
    }
}
