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

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.restassured.pojo.Paths
 * @Date : 15/07/2020
 */
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
			Operation get = this.get;
			get.setOperationType("GET");
			allOperations.add(get);
	    }
	    if (this.put != null) {
			Operation get = this.put;
			get.setOperationType("PUT");
	       allOperations.add(this.put);
	    }
	    if (this.head != null) {
			Operation get = this.head;
			get.setOperationType("HEAD");
	      allOperations.add(this.head);
	    }
	    if (this.post != null) {
			Operation get = this.post;
			get.setOperationType("POST");
	      allOperations.add(this.post);
	    }
	    if (this.delete != null) {
			Operation get = this.delete;
			get.setOperationType("DELETE");
	      allOperations.add(this.delete);
	    }
	    if (this.patch != null) {
			Operation get = this.patch;
			get.setOperationType("PATCH");
	      allOperations.add(this.patch);
	    }
	    if (this.options != null) {
			Operation get = this.options;
			get.setOperationType("OPTIONS");
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
