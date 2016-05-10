package stepsdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions_myFeature2 {
	
	@When("^I click on the signup button$")
	public void shouldClickOnSignUpButton() throws Throwable {
		System.out.println("executed the click sign up button action");
	}

	@Then("^I check that the page is sign up$")
	public void checkCurrentPageTitleAsSignUp() throws Throwable {
		System.out.println("executed the page title verification as sign up");
	}

}
