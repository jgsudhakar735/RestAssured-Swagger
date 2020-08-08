package com.jgsudhakar.restassured.reports;

import java.time.ZonedDateTime;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.restassured.reports.ExtentReportManager
 * @Date : 08/08/2020
 */
public class ExtentReportManager implements Cloneable{
	
	/**
	 * Creating private constructor so, object can not be created
	 */
	private ExtentReportManager() {

	}

	/**
	 * This method will return the instance of the {@link ExtentReports} object
	 * @return {@link ExtentReports}
	 */
	public static ExtentReports createExtentReportInstance() {
		ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter("./reports/AdminReport.html");
		extentHtmlReporter.config().setEncoding("utf-8");
		extentHtmlReporter.config().setDocumentTitle("MobeixAdmin");
		extentHtmlReporter.config().setReportName("Admin");
		extentHtmlReporter.config().setTheme(Theme.DARK);
		
		
		ExtentReports extentReports  = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
		// system info
		extentReports.setSystemInfo("Automation Tester", "Sudhakar Tangellapalli");
		extentReports.setSystemInfo("Organization", "Tagit India Pvt Ltd.,");
		extentReports.setSystemInfo("Generated Date", ZonedDateTime.now().toString());
		return extentReports;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("CLONE_NOT_SUPPORTED");
	}
}
