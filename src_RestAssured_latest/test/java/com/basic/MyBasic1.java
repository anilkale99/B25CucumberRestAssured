package com.basic;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class MyBasic1 {
	
	@Then("submit buttton check")
	public void submit_buttton_check() {
	    System.out.println("validating submit button");
	}
	
}
