package com.jgsudhakar.restassured;

import java.io.IOException;
import java.util.*;

import com.jgsudhakar.restassured.pojo.AutoMationDto;
import com.jgsudhakar.restassured.pojo.Definitions;
import com.jgsudhakar.restassured.pojo.Operation;
import com.jgsudhakar.restassured.utils.AutoCodeGenUtil;
import com.jgsudhakar.restassured.utils.RestAssuredConstants;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.restassured.junit.BaseTestClass
 * @Date : 16/07/2020
 */
public class AutoMationCodeGen {

	public static void main(String[] args) {

		AutoCodeGenUtil.reInitialize();

		String swaggerPath =  "D:\\sudhakar\\softwares\\SpringSTS\\sts-4.1.0.RELEASE\\MxAdminNew\\MxAdminAM\\src\\api-docs.json";

		AutoMationDto data = AutoCodeGenUtil.getAutomationObjectFromSwagger(swaggerPath);

		String url ="http://"+data.getHost()+data.getBasePath();

		String codeGenPath = "D:\\sudhakar\\softwares\\SpringSTS\\sts-4.1.0.RELEASE\\MxAdminNew\\MxAdminAM\\src\\com\\jgsudhakar\\restassured\\junit\\generated\\";

		// checking is there any configuration specific for module code generation
		String moduleId = (String)RestAssuredConstants.getMiscValue("ModuleId");


		// Reading complete Definition Data
		Map<String, Definitions> definitions = data.getDefinitions();
		Map<String, com.jgsudhakar.restassured.pojo.Paths> path = data.getPaths();
		path.entrySet().forEach(entry -> {
			com.jgsudhakar.restassured.pojo.Paths paths = entry.getValue();
			List<Operation> operations = paths.getOperations();
			try {
				// enable this below if condition if want to generate for specific Module
				if(StringUtils.isNotBlank(moduleId)) {
					List<String> modulepathList = Arrays.asList(moduleId.split(","));
					modulepathList.stream().forEach(modulePath -> {
						if(entry.getKey().startsWith(modulePath)) {
							String urlData = url + entry.getKey();
							try {
								AutoCodeGenUtil.generateAutomationScript(entry.getKey().replaceAll("/", "").toUpperCase(), operations, definitions, urlData, codeGenPath);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					});
				}else {
					String urlData = url + entry.getKey();
					AutoCodeGenUtil.generateAutomationScript(entry.getKey().replaceAll("/", "").toUpperCase(), operations, definitions, urlData, codeGenPath);
			}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
        AutoCodeGenUtil.printData("");
		AutoCodeGenUtil.printData("Automation Code Generation Completed :) Happy Testing");
	}
}
