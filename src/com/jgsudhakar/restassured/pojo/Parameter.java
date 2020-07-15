package com.jgsudhakar.restassured.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parameter {

	private String name;

	private String in;

	private String description;

	private String required;
	
	private String type;

	private String format;
}
