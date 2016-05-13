package stepsdefinitions;

import cucumber.api.java.en.When;

public class Login_scenarioOutline {

	@When("^User input \"([^\"]*)\" and \"([^\"]*)\" using data table$")
	public void user_input_and_using_data_table(String email, String password) throws Throwable {
		System.out.println("myFeature email "+ email + " myFeature password " + password);
	}
	
}
