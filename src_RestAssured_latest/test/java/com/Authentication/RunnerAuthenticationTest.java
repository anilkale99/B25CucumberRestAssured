package com.Authentication;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		monochrome=true,
		dryRun=false,
		features = {"src/test/resources/com/basic/Authentication/"},
		glue ={"com.basic.Authentication"},
		plugin={"pretty",
				"html:target/cucumber-htmlreport",
				"json:target/CucuReport/cucumber-report2.json"
		}

		)

public class RunnerAuthenticationTest {
	
	
}
