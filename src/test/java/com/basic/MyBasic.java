package com.basic;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class MyBasic {
	
	@Given("Login to HRMS system with valid user")
	public void login_to_hrms_system_with_valid_user() {
	    System.out.println("I am login with user");
	}
	@When("go to PIM tab")
	public void go_to_pim_tab() {
	   System.out.println("performing action");
	}
	
	@Then("delete buttton check")
	public void delete_buttton_check() {
		System.out.println("validating delete button");
	}
	
	@When("go to admin tab")
	public void go_to_admin_tab() {
	   System.out.println("performing action");
	   Assert.assertTrue(true);
	}
	
	@Then("add buttton check")
	public void add_buttton_check() {
	    System.out.println("validating button");
	}
	
	
	
	

}
