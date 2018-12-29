package restapi.test.automation;

import static org.junit.Assert.*;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

import org.hamcrest.Matchers;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Test_Tiger {

	@Test
	public void test() {
		String ROOT_URI = "http://localhost:7000/employees";
		Response response = get(ROOT_URI + "/list");
		System.out.println(response.asString());
		response.then().body("id", hasItems(1, 2));
		response.then().body("name", hasItems("Pankaj"));

		
	}

}
