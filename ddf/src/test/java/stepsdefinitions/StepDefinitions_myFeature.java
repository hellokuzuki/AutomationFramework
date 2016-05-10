package stepsdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions_myFeature {
	
	@Given("^I nagivate to the davidjones website$")
	public void shouldNavigateToWebsite() throws Throwable {
		System.out.println("executed the navigation to davidjohns website");
	}

	@When("^I click on the signin button$")
	public void shouldClickOnSignInButton() throws Throwable {
		System.out.println("executed the click sign in button action");
	}

	@Then("^I check that the page is sign in$")
	public void checkCurrentPageTitle() throws Throwable {
		System.out.println("executed the page title verification");
	}

}
