package com.jgsudhakar.restassured.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.restassured.pojo.Response
 * @Date : 15/07/2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

	private String description;

	private Schema schema;
}
