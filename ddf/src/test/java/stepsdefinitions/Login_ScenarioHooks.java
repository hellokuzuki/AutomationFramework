package stepsdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Login_ScenarioHooks {
	
	@Before
	public void allSetUp(){
		System.out.println("************** all set up method **************");
	}
	
	@After
	public void allTearDown(){
		System.out.println("************** all tear down method **************");
	}
	
	@Before("@WithHook1")
	public void allSetUpHook1(){
		System.out.println("************** all set up option1 method **************");
	}
	
	@After("@WithHook1")
	public void allTearDownHook1(){
		System.out.println("************** all tear down option1 method **************");
	}
	
	@Before("@WithHook2")
	public void allSetUpHook2(){
		System.out.println("************** all set up option2 method **************");
	}
	
	@After("@WithHook2")
	public void allTearDownHook2(){
		System.out.println("************** all tear down option2 method **************");
	}


}
