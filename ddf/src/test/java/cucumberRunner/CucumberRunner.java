package cucumberRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(

//		format has been deprecated.
//		format = {"pretty", "json:targettest/"},
		
		plugin = {"pretty", "html:targettest/cucumber-html-report", "json:targettest/cucumber-json-report.json" },
		features = {"src/test/resources/features/"},
		glue = {"stepsdefinitions"}
		)
public class CucumberRunner {
	

}
