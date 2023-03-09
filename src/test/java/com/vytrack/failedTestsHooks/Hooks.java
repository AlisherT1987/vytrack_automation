package com.vytrack.failedTestsHooks;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public static void setup() {
       // System.out.println("Setting up the project---------->");
    }

    @After
    public void teardownMethod(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/ong", scenario.getName());
        }
        BrowserUtils.sleep(2);
        Driver.closeDriver();
    }
    @Before
    public void setupScenario() throws Exception {
        System.out.println("it starts recording");
        BrowserUtils.startRecording();
    }
    @After
    public void teardownScenario() throws Exception {
        BrowserUtils.stopRecording();
        System.out.println("it stops recording");
    }



}
