package com.jgsudhakar.restassured.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.restassured.pojo.Xml
 * @Date : 15/07/2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Xml {

	private String name;

	private String namespace;

	private String prefix;

	private Boolean attribute;

	private Boolean wrapped;
}
