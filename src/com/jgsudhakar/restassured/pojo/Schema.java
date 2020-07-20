package com.jgsudhakar.restassured.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.restassured.pojo.Schema
 * @Date : 15/07/2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schema {

	private String $ref;

	private String originalRef;

	private Items items;
}
