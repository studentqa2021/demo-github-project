package com.generic;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Read {
	
	public static void get() {
		Response response	= RestAssured.get("https://httpbin.org/get");
		System.out.println(response.prettyPrint());
		
	}
	public static void main(String[] args) {
		get();
	}

}
