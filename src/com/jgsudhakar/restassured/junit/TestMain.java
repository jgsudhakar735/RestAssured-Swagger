package com.jgsudhakar.restassured.junit;
import io.restassured.http.Headers;
import io.restassured.response.ResponseBody;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestMain {

	@Test
	 public void makeSureThatGoogleIsUp() {
		//The base URI to be used
        RestAssured.baseURI = "https://www.google.com/";
 
        //Define the specification of request. Server is specified by baseURI above.
        RequestSpecification httpRequest = RestAssured.given();
 
        //Makes calls to the server using Method type.
        Response response = httpRequest.request(Method.GET);
 
        //Checks the Status Code
        int statusCode = response.getStatusCode();
        ResponseBody  responseBody = response.getBody();
        Headers headers = response.getHeaders();
        Assert.assertEquals(statusCode, 200);
	 }
	
	@Test
    void saveUserDetailsTest() {
		
        RestAssured.baseURI = "https://reqres.in/api/users/";
 
        RequestSpecification httpRequest = RestAssured.given();
 
        JSONObject updateData = new JSONObject();
        updateData.put("name", "Aarna");
 
        httpRequest.header("Content-Type", "application/json");
 
        httpRequest.body(updateData.toJSONString());
        Response response = httpRequest.request(Method.POST, "4");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
 
        JsonPath newData = response.jsonPath();
        String name = newData.get("name");
        Assert.assertEquals(name, "Aarna");
    }
	
	@Test
    void updateUserDetailsTest() {
        RestAssured.baseURI = "https://reqres.in/api/users/";
 
        RequestSpecification httpRequest = RestAssured.given();
 
        //Passing the data to be updated
        JSONObject updateData = new JSONObject();
        updateData.put("name", "Aarna");
 
        httpRequest.header("Content-Type", "application/json");
 
        httpRequest.body(updateData.toJSONString());
        Response response = httpRequest.request(Method.PUT, "4");
 
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
 
        //Checking in response if data is updated
        JsonPath newData = response.jsonPath();
        String name = newData.get("name");
        Assert.assertEquals(name, "Aarna");
    }
	
	@Test
    void deleteUserTest() {
        RestAssured.baseURI = "https://reqres.in/api/users/";

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.DELETE, "4");
        
        int statusCode = response.getStatusCode();
        
        Assert.assertEquals(statusCode, 204);
    }
	
}
