package com.jgsudhakar.restassured;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.jgsudhakar.restassured.pojo.AutoMationDto;
import com.jgsudhakar.restassured.pojo.Definitions;
import com.jgsudhakar.restassured.pojo.Properties;
import com.jgsudhakar.restassured.pojo.Operation;
import com.jgsudhakar.restassured.pojo.Response;

public class AutoMationCodeGen {

	public static void main(String[] args) {
		System.out.println("Code Generating for Automation");
		StringBuilder dataa = new StringBuilder();
		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get("D:\\sudhakar\\softwares\\SpringSTS\\sts-4.1.0.RELEASE\\MxAdminNew\\MxAdminAM\\src\\api-docs.json"))) {
			stream.forEach(data-> {
				dataa.append(data);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		AutoMationDto data = new Gson().fromJson(dataa.toString(), AutoMationDto.class);
		System.out.println("Base Path ==>"+data.getBasePath());
		System.out.println("Host ==>"+data.getHost());
		System.out.println("Description ===> "+data.getInfo().getDescription());
		
		Map<String, com.jgsudhakar.restassured.pojo.Paths> path = data.getPaths();
		path.entrySet().forEach(entry -> {
			
//			System.out.println(entry.getKey());
			
			com.jgsudhakar.restassured.pojo.Paths paths = entry.getValue();
			List<Operation> operations = paths.getOperations();
			operations.forEach(operationData-> {
				if(operationData.getTags().contains("IpTable Controller")) {
					System.out.println(operationData.getTags());
					System.out.println(operationData.getSummary());
					System.out.println(operationData.getOperationId());
					System.out.println(operationData.getDescription());
					System.out.println("--------------------------------");
					operationData.getParameters().forEach(parameter -> {
						System.out.println(parameter.getName());
						System.out.println(parameter.getIn());
						System.out.println(parameter.getRequired());
						System.out.println(parameter.getType());
						System.out.println(parameter.getFormat());
						
					});
				}
			
			// Response Data
			Map<String, Response> responses = operationData.getResponses();
			responses.entrySet().forEach(resData -> {
//				System.out.println(resData.getKey());
			});
		});
	});
		
		// Reading complete Definition Data
		Map<String, Definitions> definitions = data.getDefinitions();
		definitions.entrySet().forEach(definition -> {
//			System.out.println("Definition Name ==> "+definition.getKey());
			Definitions value = definition.getValue();
//			System.out.println("Definition Title ==> "+value.getTitle());
			Map<String, Properties> properties = value.getProperties();
			properties.entrySet().forEach(property -> {
//				System.out.println(property.getKey());
			});
		});
		
	}

}
