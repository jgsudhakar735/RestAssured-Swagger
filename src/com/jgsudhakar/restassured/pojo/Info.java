package com.jgsudhakar.restassured.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Info {

	private String description;

	private String version;

	private String title;

	private String termsOfService;
	
	private Contact contact;
	
	private License license;
}
