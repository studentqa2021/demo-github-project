package com.generic;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Update {
	
	public static void put() {
		JsonObject jo = new JsonObject();
		jo.addProperty("Batch", 100);
		jo.addProperty("Name", "Bikash");
		
		RequestSpecification rs = RestAssured.given();
		rs.body(jo.toString());
		rs.header("Content-Type","application/json");
		
		Response response= rs.put("https://httpbin.org/put");
		System.out.println(response.prettyPrint()); 
		
		
	}
	
	public static void main(String[] args) {
		put();
	}

}
