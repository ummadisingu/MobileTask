package com.mobileProgramming.test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APITest {
	
	
	RequestSpecification res;
	Response response ;
	@Given("user enter baseURI and header details")
	public void user_enter_base_uri_and_header_details() {
		
		RestAssured.baseURI="https://coinmap.org/api/v1/venues/";
		
	}

	@When("user perform get call")
	public void user_perform_get_call() {
		
		 res = RestAssured.given();
		 response = res.request(Method.GET,"");
		
	}

	@Then("user verify response code")
	public void user_verify_response_code() {
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(200, statusCode);
	}

	@Then("user verify response data")
	public void user_verify_response_data() {
		
		String x = response.getBody().print();
		
		System.out.println(x);
		
		JSONObject j=new JSONObject(x);
		
		JSONArray jsonArray = j.getJSONArray("venues");
		
	int length = jsonArray.length();
	
	System.out.println("Catagories Count: "+length);
	
	
	for (int i = 0; i < jsonArray.length(); i++) {
		
		if(jsonArray.getJSONObject(i).get("category").equals("food")) {
			System.out.println(jsonArray.getJSONObject(i).get("name"));
		}
		
	}
	
				
		
		
	}


}
