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
//		
//		int statuscode =response.statusCode();
//		System.out.println("Status code ="+statuscode);
//		
		SoftAssert sa = new SoftAssert();
//		sa.assertEquals(statuscode, 200);
//		
//		//response time (long same as int)
//		long responseTime =response.time();
//		System.out.println("Response time ="+responseTime);
//		sa.assertTrue(responseTime <3000);
//		
//		//Data format Json or not
//		String dataformat =response.contentType();
//		System.out.println(dataformat);
//		sa.assertTrue(dataformat.contains("json"));
//		
//		//Body 
//			//Body = null or not null ********
//		boolean bodyDataNotNull=!response.body().equals(null);// not null =true
//		System.out.println(bodyDataNotNull);
//		sa.assertTrue(bodyDataNotNull);
//			// Body >> test data >> specific test data based on requirement ==> employee Name=Sarower
//					// Rest Assured limitation = can not go inside json file ==> JsonPath
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
