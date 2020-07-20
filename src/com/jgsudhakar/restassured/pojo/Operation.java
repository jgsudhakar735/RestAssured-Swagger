package com.jgsudhakar.restassured.pojo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.swagger.models.ExternalDocs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation {
	
	private Map<String, Object> vendorExtensions = new LinkedHashMap<>();
	
	private List<String> tags;
	
	private String summary;
	
	private String description;
	
	private String operationId;
	
	private List<Schema> schemes;
	
	private List<String> consumes;
	
	private List<String> produces;
	
	private List<Parameter> parameters = new ArrayList<>();
	
	private Map<String, Response> responses;
	
	private List<Map<String, List<String>>> security;
	
	private ExternalDocs externalDocs;
	
	private Boolean deprecated;

	private String operationType;

	private String operationUrl;
}
