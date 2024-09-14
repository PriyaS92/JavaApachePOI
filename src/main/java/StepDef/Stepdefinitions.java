package StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;

public class Stepdefinitions {
	
	SearchPage search = new SearchPage();

	@Given("I want to navigate to makemytrip application")
	public void i_want_to_navigate_to_makemytrip_application() {
		search.login_application();
	}

	@When("I search for the flights with {string},{string},{string},{string}")
	public void i_search_for_the_flights_with(String from_city, String to_city, String fromdate, String return_date){
	   search.ticket_booking(from_city, to_city, fromdate, return_date);
	}

	@Then("I verify the search page with {string},{string}")
	public void i_verify_the_search_page_with(String from_place, String to_place) {
	   search.search_page_validation(from_place,to_place);
	}

}
