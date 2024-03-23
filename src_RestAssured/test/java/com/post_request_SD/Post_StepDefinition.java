package com.post_request_SD;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Post_StepDefinition {
	Response response;
	
	@Given("Create User with data")
	public void create_user_with_data() {
		response = RestAssured
					.given()
					.relaxedHTTPSValidation()
					.accept(ContentType.JSON)
					.body("{\r\n"
							+ "\"name\" : \"anilkale\",\r\n"
							+ "\"job\" : \"Manager\" ,\r\n"
							+ "\"dept\" : \"QA automation\",\r\n"
							+ "\"mob\" : \"111\"\r\n"
							+ "}")
					.post("https://reqres.in/api/users");
	}
	@Then("validate user created.")
	public void validate_user_created() {
	    String allResp =  response.asString();
	    System.out.println("all details = "+allResp);
	    System.out.println("status code = "+response.getStatusCode());
	    Assert.assertTrue( response.getStatusCode() == 201);
	}
	@Then("validate user ID have non null value")
	public void validate_user_ID_have_non_null_value() {
		String actID = response.body().jsonPath().getString("id");
		Assert.assertTrue( Integer.parseInt(actID) > 0 );
		Assert.assertTrue( actID != null );
	}
	
	@Given("Create User {string} with data from file")
	public void create_user_with_data_from_file(String userName) throws IOException {
		String jsonData  = new String (Files.readAllBytes(Paths.get("src/test/resources/com/post_request_FF/User.json")));
		JSONObject jsonObj = new JSONObject(jsonData);
		jsonObj.put("name", userName);
		jsonObj.put("mob", "333");
		String actJson = jsonObj.toString();
		System.out.println("Json before POST = "+actJson);
		response = RestAssured
				.given()
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.body(actJson)
				.post("https://reqres.in/api/users");
	}
	
	@Then ("validate all headers")
	public void validate_headers() {
		Headers allHeaders = response.getHeaders();
		List<Header> listHeaders = allHeaders.asList();
		
		for (Iterator iterator = listHeaders.iterator(); iterator.hasNext();) {
			Header header = (Header) iterator.next();
			System.out.println(header.toString());
		}
	}
}
