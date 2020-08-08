/**
 * 
 */
package com.jgsudhakar.restassured.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.restassured.pojo.ReportLogger
 * @Date : 08/08/2020
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReportLogger implements Serializable{
	
	/**
	 * Generated Serial ID
	 */
	private static final long serialVersionUID = 7003330530661057620L;
	
	private String requestDetails;
	
	private String requestUrl;

	private String responseDetails;
	
	private String pathParams;

	private String queryParams;
	
	private String errorDetails;

}
