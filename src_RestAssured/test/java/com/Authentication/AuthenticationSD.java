package com.Authentication;


import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AuthenticationSD {
	String url = null; 
	String tokenURL = "https://demoqa.com/Account/v1/GenerateToken";
	String authURL = "https://demoqa.com/Account/v1/Authorized";
	String createUserURL = "https://demoqa.com/Account/v1/User";
	String addBookURL = "https://demoqa.com/BookStore/v1/Books";
	String deleteUser = "https://demoqa.com/Account/v1/User/";
	
	String addBookJsonPath= "src/test/java/com/Authentication/addBook.json";
	
	Response res = null;
	Response userRes = null;
	//userIDValue = 
	
	@Given("User login with username and pwd")
	public void User_login_with_username_and_pwd() throws Throwable {
		
//		//BASIC Auth
//		res = RestAssured.given()
//						.contentType("application/json; charset=UTF-8")
//						.relaxedHTTPSValidation()
//						.auth()
//						.basic("anilkale", "Welcome@123")
//						.relaxedHTTPSValidation()
//						.when()
//						.get(tokenURL);
//		String token1 = res.body().jsonPath().getString("token");
//		System.out.println("Token details - 1 = "+token1);
//		
//		//create User
//		userRes = RestAssured
//					.given()
//					.contentType("application/json; charset=UTF-8")
//					.relaxedHTTPSValidation()
//					.when()
//					.body("{\"userName\":\"Test93545\",\"password\":\"Welcome@123\"}")
//					.post(createUserURL);
//		
//		System.out.println(" userRes Response = "+userRes.asString());
//		System.out.println("User Response = "+userRes.asString());
//		String userIDValue = userRes.body().jsonPath().getString("userID");
//		System.out.println("userID= "+userIDValue);
			
		System.out.println("========================================");
		//To login as new user get the token
		res = RestAssured
				.given()
				.contentType("application/json; charset=UTF-8")
				.relaxedHTTPSValidation()
				.when()
				.body("{\"userName\":\"Test1212\",\"password\":\"Welcome@123\"}")
				.post(tokenURL);
		System.out.println("Response = "+res.asString());
		String token = res.body().jsonPath().getString("token");
		System.out.println("token = "+token );
		
		//Add book with newly created user
		String data = new String(Files.readAllBytes(Paths.get(addBookJsonPath))); 
	    System.out.println("json in String ==== " +data);
		
		//Update the data
	    JSONObject object=new JSONObject(data);
	    object.put("userId", "d3a7c866-a7b0-4d85-a23f-793454ef446");
	    object.put("username", "Test1212");
	    String addBookStr = object.toString();
	    System.out.println("json in after replace ==== " +addBookStr);
	    
	    //Add the book
	    Response addBookRes = RestAssured
				.given()
				.auth().basic("Test1212", "Welcome@123")
				.header("Authorization",token)
				.header("authorization","Basic VGVzdDkzNTQ1OldlbGNvbWVAMTIz")
				.header("contentType","application/json; charset=UTF-8")
				.header("server","nginx/1.17.10 (Ubuntu)")
				.relaxedHTTPSValidation()
				.when()
				.body(addBookStr)
				.post(addBookURL);
	    System.out.println("Add Book Response = "+addBookRes.asString());
	    
	   
	}


}
