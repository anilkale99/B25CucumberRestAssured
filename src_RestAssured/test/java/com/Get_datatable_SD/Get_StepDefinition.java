package com.Get_datatable_SD;

import java.util.List;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_StepDefinition {
	
	Response response  = null;
	
	@Given("Hit the bookstore api")
	public void hit_the_bookstore_api() {
		response = RestAssured.get("https://demoqa.com/BookStore/v1/Books");
	}
	@Then("validate as status code")
	public void validate_statusCod_present() {
		int statusCode=  response.getStatusCode();
		Assert.assertTrue("Status code not matching", statusCode == 200);
	}
	@Then("validate data from response")
	public void validate_Value_present(DataTable allData) {
		List<List <String>> allListItemsList = allData.asLists();
		for(int i = 0; i<allListItemsList.size(); i++) {
			String expValue  = allListItemsList.get(i).get(0);
			String actualValue = response.getBody().jsonPath().getString(allListItemsList.get(i).get(1));
			Assert.assertTrue("Value not maching", expValue.equals(actualValue) );
		}
	}
}
