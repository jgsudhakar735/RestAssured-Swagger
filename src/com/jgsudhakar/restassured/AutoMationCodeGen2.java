package com.jgsudhakar.restassured;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.jgsudhakar.restassured.pojo.AutoMationDto;
import com.jgsudhakar.restassured.pojo.Operation;

import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;

public class AutoMationCodeGen2 {

	public static void main(String[] args) {
		System.out.println("Code Generating for Automation");
		StringBuilder dataa = new StringBuilder();
		Swagger swagger = new SwaggerParser().read("api-docs.json");
		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get("D:\\sudhakar\\softwares\\SpringSTS\\sts-4.1.0.RELEASE\\MxAdminNew\\MxAdminAM\\src\\api-docs.json"))) {
			stream.forEach(data-> {
				dataa.append(data);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(dataa.toString());
		AutoMationDto data = new Gson().fromJson(dataa.toString(), AutoMationDto.class);
		
		System.out.println("Base Path ==>"+data.getBasePath());
		System.out.println("Host ==>"+data.getHost());
		System.out.println("Description ===> "+data.getInfo().getDescription());
		
		Map<String, com.jgsudhakar.restassured.pojo.Paths> path = data.getPaths();
		path.entrySet().forEach(entry -> {
			com.jgsudhakar.restassured.pojo.Paths paths = entry.getValue();
			List<Operation> operations = paths.getOperations();
			operations.forEach(operationData-> {
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
		});
		});
		
//		Map<String, Path> paths = swagger.getPaths();
//		paths.entrySet().forEach(entry -> {
//			System.out.println("http://"+swagger.getHost()+swagger.getBasePath()+entry.getKey());
//			Path path = entry.getValue();
//			List<Operation> operations = path.getOperations();
//			operations.forEach(data-> {
//				System.out.println(data.getTags());
//				System.out.println(data.getSummary());
//				System.out.println(data.getOperationId());
//				System.out.println(data.getDescription());
//				System.out.println("--------------------------------");
//				data.getParameters().forEach(parameter -> {
//					System.out.println(parameter.getName());
//					System.out.println(parameter.getIn());
//					System.out.println(parameter.getRequired());
//					System.out.println(parameter.getVendorExtensions().get("type"));
//				});
//			});
//		});
		
	}

}
