package com.jgsudhakar.restassured.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.restassured.pojo.AutoMationDto
 * @Date : 15/07/2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutoMationDto {
	
	private Info info;
	
	private String swagger;
	
	private String host;

	private String basePath;
	
	private List<Tags> tags = new ArrayList<Tags>();

	private Map<String, Paths> paths;

	private Map<String, Definitions> definitions;
}
