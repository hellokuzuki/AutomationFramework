package stepsdefinitions;

import cucumber.api.java.en.When;

public class Login_parameter {
	
	@When("^User input userid as \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void shouldInputCredentialsWithExample(String arg1, String arg2) throws Throwable {
		System.out.println("myFeature email "+ arg1 + " myFeature password " + arg2);
	}


}
