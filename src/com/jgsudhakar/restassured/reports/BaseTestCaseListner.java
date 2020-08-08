package com.jgsudhakar.restassured.reports;

import java.io.PrintStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.output.WriterOutputStream;
import org.apache.commons.lang3.StringUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.jgsudhakar.restassured.pojo.ReportLogger;
import com.jgsudhakar.restassured.utils.RestAssuredConstants;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.restassured.reports.BaseTestCaseListner
 * @Date : 08/08/2020
 */
public class BaseTestCaseListner implements ITestListener {
	
	public static Map<String, ReportLogger> loggerInfo = new HashMap<>();
	
	// Request Logging helper object per method/tests
	public static StringWriter requestWriter;
	public static PrintStream requestCapture;
	
	// Response Logging helper object per method/tests
	public static StringWriter responseWriter;
	public static PrintStream responseCapture;
	
	// Error Logging helper object per method/tests
	public static StringWriter errorWriter;
	public static PrintStream errorCapture;
	
	static ZonedDateTime dateTime = ZonedDateTime.now();
	private static ExtentReports extent = ExtentReportManager.createExtentReportInstance();
	private ExtentTest extentTest;
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<>();
	
	@Override
	public void onStart(ITestContext context) {
		ITestListener.super.onStart(context);
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		requestWriter = new StringWriter();
		requestCapture = new PrintStream(new WriterOutputStream(requestWriter, Charset.defaultCharset()),true);

		responseWriter = new StringWriter();
		responseCapture = new PrintStream(new WriterOutputStream(responseWriter, Charset.defaultCharset()),true);

		errorWriter = new StringWriter();
		errorCapture = new PrintStream(new WriterOutputStream(errorWriter, Charset.defaultCharset()),true);
		
		
		extentTest = extent.createTest(result.getMethod().getDescription());
		extentTest.log(Status.INFO, result.getMethod().getDescription() +"   Test Started");
		testReport.set(extentTest);
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		// checking whether to Audit the request information or not. To Enable this change in the constant.properties file.
		String miscValue = (String)RestAssuredConstants.getMiscValue("logAuditDetails");
		
		if(StringUtils.isNotBlank(miscValue) && miscValue.equalsIgnoreCase("Y")) {
			ReportLogger logger = loggerInfo.get(result.getMethod().getMethodName());
			if(null != logger) {
				
				String request = logger.getRequestDetails();
				extentTest.info(":: URL :: "+logger.getRequestUrl());
				extentTest.info(":: Query Parameters :: "+logger.getQueryParams());
				extentTest.info(":: Path  Parameters :: "+logger.getPathParams());
				extentTest.info(request);
				
				
				String response = logger.getResponseDetails();
				extentTest.info(response);
			}
		}
		
		
		ITestListener.super.onTestSuccess(result);
		extentTest.log(Status.PASS, result.getMethod().getDescription() +"   Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL, result.getMethod().getDescription() +"   Test Failed");
		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onFinish(ITestContext context) {
		extentTest.log(Status.INFO, "Test Case Execution Finised");
		if(null != extent)
			extent.flush();

		ITestListener.super.onFinish(context);
	}

}
