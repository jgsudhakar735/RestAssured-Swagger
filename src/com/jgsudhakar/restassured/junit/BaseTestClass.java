package com.jgsudhakar.restassured.junit;

import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.collections.CollectionUtils;

import com.jgsudhakar.restassured.pojo.ReportLogger;
import com.jgsudhakar.restassured.reports.BaseTestCaseListner;

import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.restassured.junit.BaseTestClass
 * @Date : 15/07/2020
 */
public class BaseTestClass {
	
	
    private RequestSpecification setBaseRequest(String url,Map<String, String> pathParam,Map<String, String> queryParam) {
    	
    	// To set the path parameters and Query parameters , we need to set the  
    	// base url and then need to add that path parameters URL to actual method
    	
    	String baseUrl = url;
    	if(url.contains("{")) {
    		int index = url.indexOf("/{");
    		baseUrl = url.substring(0,index);
    	}
        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = RestAssured.given();
        if(CollectionUtils.hasElements(pathParam)) {
        	pathParam.entrySet().forEach(pathParamData->
        		httpRequest.pathParam(pathParamData.getKey(),pathParamData.getValue())
        	);
        }
        if(CollectionUtils.hasElements(queryParam)) {
        	queryParam.entrySet().forEach(pathParamData->
            		httpRequest.queryParam(pathParamData.getKey(),pathParamData.getValue())
            	);
        }

        return httpRequest;
    }

    /**
     * This method will be used to set the Request Body which required for POST or PUT methods.
     * */
    @SuppressWarnings("unchecked")
	private JSONObject setRequestBody(Map<String, Object> reqBody) {
        JSONObject jsonObject = new JSONObject();
        if(null != reqBody && reqBody.size() > 0)
            reqBody.entrySet().forEach(data -> 
                jsonObject.put(data.getKey(),data.getValue())
            );
        return jsonObject;
    }

    private void setHeaderParameter(Map<String,String> headerParameter, RequestSpecification specification) {
        if(null != headerParameter && headerParameter.size() > 0)
            headerParameter.entrySet().forEach(headerData -> {
                specification.header(headerData.getKey(),headerData.getValue());
            });
    }

    public Response POST(Map<String,Object> reqBody, Map<String,String> headerParameter,String url,Map<String, String> pathParam,Map<String, String> queryParam, String methodName){
        RequestSpecification httpRequest = setBaseRequest(url,pathParam,queryParam);
        setHeaderParameter(headerParameter, httpRequest);
        JSONObject requestBody = setRequestBody(reqBody);
        httpRequest.body(requestBody.toJSONString());
        String pathUrl = "";
    	if(url.contains("{")) {
    		int index = url.indexOf("/{");
    		pathUrl = url.substring(index,url.length());
    	}
    	Response response =  httpRequest.
    			filter(new RequestLoggingFilter(BaseTestCaseListner.requestCapture)).
    			filter(new ResponseLoggingFilter(BaseTestCaseListner.responseCapture)).
    			filter(new ErrorLoggingFilter(BaseTestCaseListner.errorCapture)).
    			post(pathUrl);
    	
    	storeLogInfoInMemory(url, pathParam, queryParam, methodName);
    	
    	return response;
    }

    public Response GET(Map<String,Object> reqBody, Map<String,String> headerParameter,String url,Map<String, String> pathParam,Map<String, String> queryParam, String methodName){
        RequestSpecification httpRequest = setBaseRequest(url,pathParam,queryParam);
        setHeaderParameter(headerParameter, httpRequest);
        JSONObject requestBody = setRequestBody(reqBody);
        httpRequest.body(requestBody.toJSONString());
        String pathUrl = "";
    	if(url.contains("{")) {
    		int index = url.indexOf("/{");
    		pathUrl = url.substring(index,url.length());
    	}
    	Response response =  httpRequest.
    			filter(new RequestLoggingFilter(BaseTestCaseListner.requestCapture)).
    			filter(new ResponseLoggingFilter(BaseTestCaseListner.responseCapture)).
    			filter(new ErrorLoggingFilter(BaseTestCaseListner.errorCapture)).
    			get(pathUrl);
    	
    	storeLogInfoInMemory(url, pathParam, queryParam, methodName);
    	return response;
    }

    public Response PUT(Map<String,Object> reqBody, Map<String,String> headerParameter,String url,Map<String, String> pathParam,Map<String, String> queryParam, String methodName){
        RequestSpecification httpRequest =setBaseRequest(url,pathParam,queryParam);
        setHeaderParameter(headerParameter, httpRequest);
        JSONObject requestBody = setRequestBody(reqBody);
        httpRequest.body(requestBody.toJSONString());
        String pathUrl = "";
    	if(url.contains("{")) {
    		int index = url.indexOf("/{");
    		pathUrl = url.substring(index,url.length());
    	}
    	Response response =  httpRequest.
    			filter(new RequestLoggingFilter(BaseTestCaseListner.requestCapture)).
    			filter(new ResponseLoggingFilter(BaseTestCaseListner.responseCapture)).
    			filter(new ErrorLoggingFilter(BaseTestCaseListner.errorCapture)).
    			put(pathUrl);
    	
    	storeLogInfoInMemory(url, pathParam, queryParam, methodName);
    	return response;
    }

    public Response DELETE(Map<String,Object> reqBody, Map<String,String> headerParameter,String url,Map<String, String> pathParam,Map<String, String> queryParam, String methodName){
        RequestSpecification httpRequest = setBaseRequest(url,pathParam,queryParam);
        setHeaderParameter(headerParameter, httpRequest);
        JSONObject requestBody = setRequestBody(reqBody);
        httpRequest.body(requestBody.toJSONString());
        String pathUrl = "";
    	if(url.contains("{")) {
    		int index = url.indexOf("/{");
    		pathUrl = url.substring(index,url.length());
    	}
    	Response response =  httpRequest.
    			filter(new RequestLoggingFilter(BaseTestCaseListner.requestCapture)).
    			filter(new ResponseLoggingFilter(BaseTestCaseListner.responseCapture)).
    			filter(new ErrorLoggingFilter(BaseTestCaseListner.errorCapture)).
    			delete(pathUrl);
    	
    	// storing the request and Response in the 
    	storeLogInfoInMemory(url, pathParam, queryParam, methodName);
    	return response;
    }

	/**
	 * This method will store the request, response,error details, url, path parameters, and Query parameters in the memory. The same
	 * we will be using it in the further reporting purpose. 
	 * @param url
	 * @param pathParam
	 * @param queryParam
	 * @param methodName
	 */
	private void storeLogInfoInMemory(String url, Map<String, String> pathParam, Map<String, String> queryParam,
			String methodName) {
		ReportLogger loggerBuilder = ReportLogger.
    			builder().
    			requestDetails(BaseTestCaseListner.requestWriter.toString()).
    			responseDetails(BaseTestCaseListner.responseWriter.toString()).
    			errorDetails(BaseTestCaseListner.errorWriter.toString()).
    			requestUrl(url).
    			pathParams(pathParam.toString()).
    			queryParams(queryParam.toString()).
    			build();
    	
    	BaseTestCaseListner.loggerInfo.putIfAbsent(methodName, loggerBuilder);
	}
    
}
