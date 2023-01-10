package com.cucmber.test;

import com.generic.CreateReviewFinal;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class Stepdef {
	
	@Given ("setup test data into jason & use post method")
	public void setup() {
		CreateReviewFinal.post();
	}
	
	
    @Then("validate test cases")
    public void postTestcasesValidation() {
    	CreateReviewFinal.postTestcases();
    }
  

}
