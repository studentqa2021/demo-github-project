package com.generic;

import org.testng.asserts.SoftAssert;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateFunctionTest {
	
	public static void post() {
		
		JsonObject jo = new JsonObject();
		jo.addProperty("Batch", 99);
		jo.addProperty("Name", "Sarower");
		
		RequestSpecification rs = RestAssured.given();
		rs.body(jo.toString());
		rs.header("Content-Type","application/json");
		
		Response response= rs.post("https://httpbin.org/post");
		System.out.println(response.prettyPrint()); 
		SoftAssert sa = new SoftAssert();
		JsonPath jp =response.jsonPath();
		System.out.println(jp.get("json.Batch").toString());
		sa.assertEquals(jp.get("headers.Host").toString(), "httpbin.org");
		
		//must do one thing for softassert
		sa.assertAll();//*******************
	}
	public static void main(String[] args) {
		post();
	}

}
