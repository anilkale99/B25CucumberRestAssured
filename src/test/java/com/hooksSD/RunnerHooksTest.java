package com.hooksSD;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/com/hooksFF/hooksConcept.feature"},
		glue={"com.hooksSD"},
		plugin={"pretty",
				"html:target/cucumber-htmlreport.html",
				"json:target/cucumber-report10.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/ExtentReport1.html"
		}
		)
public class RunnerHooksTest {

}
