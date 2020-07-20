package com.jgsudhakar.restassured.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.restassured.pojo.Definitions
 * @Date : 15/07/2020
 */
public class Info {

	private String description;

	private String version;

	private String title;

	private String termsOfService;
	
	private Contact contact;
	
	private License license;
}
