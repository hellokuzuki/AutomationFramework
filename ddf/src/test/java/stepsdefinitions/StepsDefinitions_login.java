package stepsdefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepsDefinitions_login {
	
	WebDriver driver = null;
	
	@Given("^User in the home page\\.$")
	public void shouldNavigateToHomePage() throws Throwable {
		driver = new FirefoxDriver();
		driver.get("http://www.davidjones.com.au");
	}

	@When("^User click on Sign in button$")
	public void ShouldClickOnSignInButton() throws Throwable {
		driver.findElement(By.linkText("Sign In")).click();
	}

	@And("^User input userid and password$")
	public void shouldInputCredentials() throws Throwable {
		driver.findElement(By.name("logonId")).sendKeys("testuser@yopmail.com");
		driver.findElement(By.name("logonPassword")).sendKeys("111111");
		driver.findElement(By.xpath("//*[@id=\"Logon\"]/fieldset/ul/li[5]/div/input")).submit();
	}

	@Then("^login to the web site$")
	public void pageTitleValidation() throws Throwable {
		assertEquals("My Account",driver.getTitle());
	}


}
