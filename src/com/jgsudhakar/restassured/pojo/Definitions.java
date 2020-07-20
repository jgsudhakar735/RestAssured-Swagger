package com.jgsudhakar.restassured.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class Definitions {
	
	private String definitions ="Definitions";

	private String title;

	private String type;

	private List<String> required = new ArrayList<>();
	
	private Map<String,Properties> properties = new HashMap<>();
}
