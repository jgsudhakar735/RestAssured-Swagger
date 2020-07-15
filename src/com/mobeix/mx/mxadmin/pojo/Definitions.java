package com.mobeix.mx.mxadmin.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Definitions {
	
	private String definitions ="Definitions";

	private String title;

	private String type;

	private List<String> required;
	
	private Map<String,Properties> properties = new HashMap<>();
}