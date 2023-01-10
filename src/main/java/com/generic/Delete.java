package com.generic;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Delete {

	public static void delete() {
		Response response	= RestAssured.delete("https://httpbin.org/delete");
		System.out.println(response.prettyPrint());
		
	}
	public static void main(String[] args) {
		delete();
	}
}
