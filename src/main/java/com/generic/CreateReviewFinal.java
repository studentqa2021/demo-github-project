package com.generic;

import org.testng.asserts.SoftAssert;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateReviewFinal {

	static Response response;
	public static void  post() {
		
		JsonObject jo = new JsonObject();
		jo.addProperty("Batch", "29");
		
		RequestSpecification rs = RestAssured.given();
		rs.body(jo.toString());
		rs.header("Content-Type","application/json");
		
		 response=rs.post("https://httpbin.org/post");
		System.out.println(response.asString());
		 
		 
	}
	
	public static void postTestcases() {
		SoftAssert sa =new SoftAssert();
		//status code check
		sa.assertTrue(response.statusCode()==200);
		//response time
		sa.assertTrue(response.time()<3000);
		// content type = json
		sa.assertTrue(response.contentType().contains("json"));
		//Body >>data null or not
		sa.assertTrue(! response.body().asString().equals(null));
		//check attribute or locator present or not
		sa.assertTrue(response.body().asString().contains("Batch"));
		// check Batch value check= 29 ==>jason parser =JsonPath
		JsonPath jp =response.jsonPath();
		System.out.println(jp.get("json.Batch").toString());
		sa.assertTrue(jp.get("json.Batch").toString().contains("29"));
		
		sa.assertAll();
	}
	

}
