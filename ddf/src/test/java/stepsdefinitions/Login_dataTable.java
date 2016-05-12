package stepsdefinitions;

import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;

public class Login_dataTable {
	
	@When("^User input userid and password using data table$")
	public void user_input_userid_and_password_using_data_table(DataTable table) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
//		System.out.println(table);
		List<List<String>> data = table.raw();
		
		System.out.println(data.get(0).get(0) + " / " + data.get(0).get(1));
		System.out.println(data.get(1).get(0) + " / " + data.get(1).get(1));
		System.out.println(data.get(2).get(0) + " / " + data.get(2).get(1));
		System.out.println(data.get(3).get(0) + " / " + data.get(3).get(1));
	}

}
