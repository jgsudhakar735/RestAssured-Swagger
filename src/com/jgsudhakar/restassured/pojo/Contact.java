package com.jgsudhakar.restassured.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.restassured.pojo.Contact
 * @Date : 15/07/2020
 */
public class Contact {

	private String name;
	
	private String url;
	
	private String email;
}
