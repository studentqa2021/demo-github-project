package com.generic;

import org.testng.asserts.SoftAssert;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateReview {
	
	public static void post() {
		// convert test data into json
		JsonObject jo = new JsonObject();
		jo.addProperty("Batch", "29");
		// add json data inside body
		RequestSpecification reqSf = RestAssured.given();
		reqSf.body(jo.toString());
		//Header data format
		reqSf.header("Content-Type","application/json");
		// call post method and will get response
		
		 Response resObj=reqSf.post("https://httpbin.org/post");
		// System.out.println(resObj.asString());
		 
		// Test cases
		 //1st
		 SoftAssert sa =new SoftAssert();
		// System.out.println(resObj.getStatusCode());
		 sa.assertEquals(resObj.getStatusCode(), 200);
		 //2nd
		// System.out.println(resObj.time());
		 boolean condition =resObj.time() <2000;
		 sa.assertTrue(condition);
		 //3rd
		// System.out.println(resObj.contentType());
		 condition =resObj.contentType().contains("json");
		 sa.assertTrue(condition);
		 //4th
		// System.out.println(resObj.body().asString());
		 condition = !resObj.body().asString().equals(null);
		 sa.assertTrue(condition);
		//5th
		 //System.out.println(resObj.body().asString().contains("data"));
		 condition = resObj.body().asString().contains("data");
		 sa.assertTrue(condition);
		//6th==> check attribute value ==> need to use JSON parser(read JSON value) = JsonPath
		 JsonPath jp =resObj.jsonPath();
		// System.out.println( jp.get("json.Batch").toString());
		 sa.assertEquals(jp.get("json.Batch").toString(), "29");
		 
		 
		 
		 sa.assertAll();
	}

	public static void main(String[] args) {
		post();
	}
}
