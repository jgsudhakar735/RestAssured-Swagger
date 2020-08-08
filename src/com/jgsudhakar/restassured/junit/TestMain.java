package com.jgsudhakar.restassured.junit;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jgsudhakar.restassured.reports.BaseTestCaseListner;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

@Listeners(BaseTestCaseListner.class)
public class TestMain {

	@Test(groups = {"Test"}, testName = "RestData",description = "Sample Name")
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

    @Test(groups = {"Test"}, testName = "Rest Data")
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

    @Test(groups = {"Test"}, testName = "Rest Data")
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

    @Test(groups = {"Test"}, testName = "Rest Data")
    void deleteUserTest() {
        RestAssured.baseURI = "https://reqres.in/api/users/";

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.DELETE, "4");
        
        int statusCode = response.getStatusCode();
        
        Assert.assertEquals(statusCode, 204);
    }
	
}
