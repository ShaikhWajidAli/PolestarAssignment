package com.polestar.apitesting.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class RESTApiTesting {

	int id;

	@Test(priority = 1)
	public void getResponseTest() {

		Response res = given()

				.when().get("https://reqres.in/api/users/2");

		System.out.println(res.getStatusCode());
		System.out.println(res.getBody().asPrettyString());
	}

	@Test(priority = 2)
	public void postResponseTest() {

		HashMap<String, String> data = new HashMap<>();

		data.put("name", "john");
		data.put("job", "teacher");

		Response res = given().contentType("application/json").body(data).when().post("https://reqres.in/api/users");

		Assert.assertEquals(res.getStatusCode(), 201);
		id = res.jsonPath().getInt("id");
	}

	@Test(priority = 3, dependsOnMethods = { "postResponseTest" })
	public void putResponseTest() {
		HashMap<String, String> data = new HashMap<>();
		data.put("name", "bob");
		data.put("job", "manager");

		Response res = given().contentType("application/json").body(data).when()
				.put("https://reqres.in/api/users/" + id);

		Assert.assertEquals(res.getStatusCode(), 200);
	}

	@Test(priority = 4)
	public void deleteResponseTest() {

		Response res = given()

				.when().delete("https://reqres.in/api/users/" + id);

		Assert.assertEquals(res.getStatusCode(), 204);
	}

}
