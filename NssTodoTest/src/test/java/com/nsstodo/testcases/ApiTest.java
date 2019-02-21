package com.nsstodo.testcases;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApiTest {

	public static JsonPath rawToJson(Response r) {
		String respon = r.asString();
		JsonPath x = new JsonPath(respon);
		return x;
	}

	@Test
	public void validatedServiceStatus() {

		RestAssured.baseURI = "http://localhost/nss-todo-automation";
		given().port(80).when().get("/fake-API-call.php").then().assertThat().statusCode(200);

	}

	@Test
	public void getCountUnassignedCategory() {
		RestAssured.baseURI = "http://localhost/nss-todo-automation";
		Response res = given().port(80).when().get("/fake-API-call.php").then().extract().response();
		JsonPath jsonResponse = rawToJson(res);
		ArrayList<String> categoryList = new ArrayList<String>();
		categoryList = jsonResponse.get("category");
		int count = 0;
		for (int i = 0; i < categoryList.size(); i++) {
			if (categoryList.get(i).trim().toString().isEmpty()) {
				count++;
			}
		}
		System.out.println("Total Unasigned Category Tasks: " + count);

	}

	@Test
	public void getAllTaskName() {
		RestAssured.baseURI = "http://localhost/nss-todo-automation";
		Response res = given().port(80).when().get("/fake-API-call.php").then().extract().response();

		JsonPath jsonResponse = rawToJson(res);

		List<String> taskList = jsonResponse.getList("'task name'");

		for (String taskName : taskList) {
			System.out.println(taskName);
		}
	}

	//@Test
	public void descendingOrderTaskList() {
		RestAssured.baseURI = "http://localhost/nss-todo-automation";
		Response res = given().port(80).when().get("/fake-API-call.php").then().extract().response();

		JsonPath jsonResponse = rawToJson(res);
		String taskList = jsonResponse.getString("'task name'");
		String dueDates = jsonResponse.getString("'due date'");

		StringTokenizer taskList_str = new StringTokenizer(taskList, ",");
		StringTokenizer date_str = new StringTokenizer(dueDates, ",");

		HashMap map = new HashMap();
		int i = 0;
		String temp;
		Date d1;
		while (date_str.hasMoreTokens()) {

			temp = date_str.nextToken();
			if (temp != "")
				d1 = new Date(new Long(temp.replaceAll("\\r\\n", "")).longValue());
			else
				d1 = new Date();

			map.put(taskList_str.nextToken(), d1);
		}

	}

	@Test
	public void validateNoOfTask() {
		RestAssured.baseURI = "http://localhost/nss-todo-automation";
		Response res = given().port(80).when().get("/fake-API-call.php").then().extract().response();

		JsonPath jsonResponse = rawToJson(res);
		List<String> taskList = jsonResponse.getList("'task name'");
		int taskCount = taskList.size();

		Assert.assertEquals(taskCount, 8);

	}

}
