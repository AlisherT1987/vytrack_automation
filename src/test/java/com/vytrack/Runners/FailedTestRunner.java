package com.vytrack.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="@target/rerun.txt",
        glue = {"com/vytrack/step_definitions",
            "com/vytrack/failedTestsHooks"}
)
public class FailedTestRunner {
}
