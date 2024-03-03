package com.Get_SD;

import org.junit.Assert;

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
	@Then("validate Git Pocket Guide title present")
	public void validate_git_pocket_guide_title_present() {
		String titleArr[] = {"Git Pocket Guide","Learning JavaScript Design Patterns"};
		String jsonDataString = response.getBody().asString();
		System.out.println("JSON = "+jsonDataString);
		String bookTitle = response.getBody().jsonPath().getString("books[0].title");
		Assert.assertTrue("Title not maching", bookTitle.equals("Git Pocket Guide"));
	}
	@Then("validate Learning JavaScript Design Patterns title present")
	public void validate_Learning_JavaScript_Design_Patterns_title_present() {
		String jsonDataString = response.getBody().asString();
		System.out.println("JSON = "+jsonDataString);
		String bookTitle = response.getBody().jsonPath().getString("books[1].title");
		Assert.assertTrue("Title not maching", bookTitle.equals("Learning JavaScript Design Patterns"));
	}
	
	@Then("validate {string} at jsonpath {string} title present")
	public void validate_title_present(String title, String jsonPath) {
		String jsonDataString = response.getBody().asString();
		System.out.println("JSON = "+jsonDataString);
		String actualbookTitle = response.getBody().jsonPath().getString(jsonPath);
		Assert.assertTrue("PageNumbers not maching", actualbookTitle.equals(title));
	}
	
	@Then("validate {string} at jsonpath {string} pageNumbers present")
	public void validate_pageNumbers_present(String pageNumbers, String jsonPath) {
		int actualPageNum = response.getBody().jsonPath().getInt(jsonPath);
		int expectedPageNum = Integer.parseInt(pageNumbers);
		Assert.assertTrue("Title not maching", actualPageNum == expectedPageNum);
	}
	
	@Then("validate {string} at jsonpath {string} present")
	public void validate_Value_present(String expValue, String jsonPath) {
		String actualValue = response.getBody().jsonPath().getString(jsonPath);
		Assert.assertTrue("Title not maching", expValue.equals(actualValue) );
	}
}
