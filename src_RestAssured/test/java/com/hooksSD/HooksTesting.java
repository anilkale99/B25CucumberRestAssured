package com.hooksSD;

import java.io.IOException;

import org.junit.Assert;

import com.lib.PropertiesOperation;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HooksTesting {
	
	
	Response response = null;
	@Before
	public void myBefore() throws IOException {
		System.out.println("connecting to DB");
		System.out.println("opening the browser");
		System.out.println("cleaning some folder and its content.");
		String url = PropertiesOperation.getPropValue("uri");
		response = RestAssured.get(url);
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
	
	@After
	public void myAfter() {
		System.out.println("disconnecting to DB");
		System.out.println("close the browser");
		System.out.println("cleaning some folder and its content.");
	}

}
