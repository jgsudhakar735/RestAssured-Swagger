package com.jgsudhakar.restassured.junit.generated;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jgsudhakar.restassured.junit.BaseTestClass;
import com.jgsudhakar.restassured.reports.ExtentReporterNG;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

@Listeners(value = ExtentReporterNG.class)
public class LanguageCollection extends BaseTestClass {

	@Test(groups = "LanguageCollection")
	public void getIdUsingGET_6() {
		String url = "http://localhost:9898/mobeixadmin/api/language/{id}";
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("X-Request-By", "SUDHAKR");
		headerMap.put("X-Request-ID", "SAMPLE");
		headerMap.put("Content-Type", "application/json");
		Map<String, Object> reqBody = new HashMap<>();
		Response response = GET(reqBody, headerMap, url);
		int resStatusCode = response.getStatusCode();
		ResponseBody responseBody = response.getBody();
		Headers headers = response.getHeaders();
		Assert.assertEquals(resStatusCode, 200);
	}

	@Test(groups = "LanguageCollection")
	public void deleteUsingDELETE_6() {
		String url = "http://localhost:9898/mobeixadmin/api/language/{id}";
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("X-Request-By", "SUDHAKR");
		headerMap.put("X-Request-ID", "SAMPLE");
		headerMap.put("Content-Type", "application/json");
		Map<String, Object> reqBody = new HashMap<>();
		Response response = DELETE(reqBody, headerMap, url);
		int resStatusCode = response.getStatusCode();
		ResponseBody responseBody = response.getBody();
		Headers headers = response.getHeaders();
		Assert.assertEquals(resStatusCode, 200);
	}

	@Test(groups = "LanguageCollection")
	public void getListUsingGET_9() {
		String url = "http://localhost:9898/mobeixadmin/api/language/";
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("X-App-ID", "1");
		headerMap.put("X-Request-By", "SUDHAKR");
		headerMap.put("X-Request-ID", "SAMPLE");
		headerMap.put("X-Tenant-ID", "1");
		headerMap.put("Content-Type", "application/json");
		Map<String, Object> reqBody = new HashMap<>();
		Response response = GET(reqBody, headerMap, url);
		int resStatusCode = response.getStatusCode();
		ResponseBody responseBody = response.getBody();
		Headers headers = response.getHeaders();
		Assert.assertEquals(resStatusCode, 200);
	}

	@Test(groups = "LanguageCollection")
	public void updateUsingPUT_9() {
		String url = "http://localhost:9898/mobeixadmin/api/language/";
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("X-Request-By", "SUDHAKR");
		headerMap.put("X-Request-ID", "SAMPLE");
		headerMap.put("X-Tenant-ID", "1");
		headerMap.put("Content-Type", "application/json");
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("appId", "1");
		reqBody.put("id", "");
		reqBody.put("languageCode", "EN");
		reqBody.put("languageDesc", "ENGLISH");
		reqBody.put("localeTag", "en_US");
		reqBody.put("version", "1");
		reqBody.put("status", "A");
		Response response = PUT(reqBody, headerMap, url);
		int resStatusCode = response.getStatusCode();
		ResponseBody responseBody = response.getBody();
		Headers headers = response.getHeaders();
		Assert.assertEquals(resStatusCode, 200);
	}

	@Test(groups = "LanguageCollection")
	public void saveUsingPOST_9() {
		String url = "http://localhost:9898/mobeixadmin/api/language/";
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("X-Request-By", "SUDHAKR");
		headerMap.put("X-Request-ID", "SAMPLE");
		headerMap.put("X-Tenant-ID", "1");
		headerMap.put("Content-Type", "application/json");
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("appId", "1");
		reqBody.put("id", "");
		reqBody.put("languageCode", "EN");
		reqBody.put("languageDesc", "ENGLISH");
		reqBody.put("localeTag", "en_US");
		reqBody.put("version", "1");
		reqBody.put("status", "A");
		Response response = POST(reqBody, headerMap, url);
		int resStatusCode = response.getStatusCode();
		ResponseBody responseBody = response.getBody();
		Headers headers = response.getHeaders();
		Assert.assertEquals(resStatusCode, 200);
	}

}
