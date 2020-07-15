package com.mobeix.mx.mxadmin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
