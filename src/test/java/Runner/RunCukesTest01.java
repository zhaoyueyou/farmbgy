package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Feature"},
        plugin = {"html:target/cucumber-reports/html",
                "json:target/cucumber-reports/cucumber01.json",
                "junit:target/cucumber-reports/cucumber.xml",
                "pretty"},
        glue = {"Setprecision"},
        tags = {"@login_cp01"}
)

public class RunCukesTest01 {
    static {
        System.out.println("********** 01");
    }
}
