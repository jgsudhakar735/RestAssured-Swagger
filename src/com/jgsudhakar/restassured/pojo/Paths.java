package com.jgsudhakar.restassured.pojo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.models.HttpMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"get", "head", "post", "put", "delete", "options", "patch"})
public class Paths {

	private String paths ="Paths";
	
	  private Operation get;
	  
	  private Operation put;
	  
	  private Operation post;
	  
	  private Operation head;
	  
	  private Operation delete;
	  
	  private Operation patch;
	  
	  private Operation options;
	  
	  private List<Parameter> parameters;
	  
	  @JsonIgnore
	  public List<Operation> getOperations()
	  {
	    List<Operation> allOperations = new ArrayList<>();
	    if (this.get != null) {
	      allOperations.add(this.get);
	    }
	    if (this.put != null) {
	      allOperations.add(this.put);
	    }
	    if (this.head != null) {
	      allOperations.add(this.head);
	    }
	    if (this.post != null) {
	      allOperations.add(this.post);
	    }
	    if (this.delete != null) {
	      allOperations.add(this.delete);
	    }
	    if (this.patch != null) {
	      allOperations.add(this.patch);
	    }
	    if (this.options != null) {
	      allOperations.add(this.options);
	    }
	    return allOperations;
	  }
	  
	  @JsonIgnore
	  public Map<HttpMethod, Operation> getOperationMap()
	  {
	    Map<HttpMethod, Operation> result = new LinkedHashMap<>();
	    if (this.get != null) {
	      result.put(HttpMethod.GET, this.get);
	    }
	    if (this.put != null) {
	      result.put(HttpMethod.PUT, this.put);
	    }
	    if (this.post != null) {
	      result.put(HttpMethod.POST, this.post);
	    }
	    if (this.delete != null) {
	      result.put(HttpMethod.DELETE, this.delete);
	    }
	    if (this.patch != null) {
	      result.put(HttpMethod.PATCH, this.patch);
	    }
	    if (this.head != null) {
	      result.put(HttpMethod.HEAD, this.head);
	    }
	    if (this.options != null) {
	      result.put(HttpMethod.OPTIONS, this.options);
	    }
	    return result;
	  }
}
