package com.mobeix.mx.mxadmin.pojo;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	
	
}
