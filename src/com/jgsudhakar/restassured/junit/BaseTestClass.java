package com.jgsudhakar.restassured.junit;

import java.util.Map;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.restassured.junit.BaseTestClass
 * @Date : 15/07/2020
 */
public class BaseTestClass {

    private RequestSpecification setBaseUrl(String url) {
        RestAssured.baseURI = url;
        RequestSpecification httpRequest = RestAssured.given();
        return httpRequest;
    }

    /**
     * This method will be used to set the Request Body which required for POST or PUT methods.
     * */
    private JSONObject setRequestBody(Map<String, Object> reqBody) {
        JSONObject jsonObject = new JSONObject();
        if(null != reqBody && reqBody.size() > 0)
            reqBody.entrySet().forEach(data -> {
                jsonObject.put(data.getKey(),data.getValue());
            });
        return jsonObject;
    }

    private void setHeaderParameter(Map<String,String> headerParameter, RequestSpecification specification) {
        if(null != headerParameter && headerParameter.size() > 0)
            headerParameter.entrySet().forEach(headerData -> {
                specification.header(headerData.getKey(),headerData.getValue());
            });
    }

    public Response POST(Map<String,Object> reqBody, Map<String,String> headerParameter,String url){
        RequestSpecification httpRequest = setBaseUrl(url);
        setHeaderParameter(headerParameter, httpRequest);
        JSONObject requestBody = setRequestBody(reqBody);
        httpRequest.body(requestBody.toJSONString());
        return httpRequest.post();
    }

    public Response GET(Map<String,Object> reqBody, Map<String,String> headerParameter,String url){
        RequestSpecification httpRequest = setBaseUrl(url);
        setHeaderParameter(headerParameter, httpRequest);
        JSONObject requestBody = setRequestBody(reqBody);
        httpRequest.body(requestBody.toJSONString());
        return httpRequest.get();
    }

    public Response PUT(Map<String,Object> reqBody, Map<String,String> headerParameter,String url){
        RequestSpecification httpRequest = setBaseUrl(url);
        setHeaderParameter(headerParameter, httpRequest);
        JSONObject requestBody = setRequestBody(reqBody);
        httpRequest.body(requestBody.toJSONString());
        return httpRequest.put();
    }

    public Response DELETE(Map<String,Object> reqBody, Map<String,String> headerParameter,String url){
        RequestSpecification httpRequest = setBaseUrl(url);
        setHeaderParameter(headerParameter, httpRequest);
        JSONObject requestBody = setRequestBody(reqBody);
        httpRequest.body(requestBody.toJSONString());
        return httpRequest.delete();
    }

}
