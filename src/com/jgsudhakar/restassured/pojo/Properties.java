package com.jgsudhakar.restassured.pojo;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.restassured.pojo.Properties
 * @Date : 15/07/2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Properties {
	
	private String type;
	
	private String format;
	
	private String description;
	
	@SerializedName("enum")
	private List<String> enums;
	
	private Schema items;
	
	private Xml xml;

	private String originalRef;

	private String $ref;

	
}
