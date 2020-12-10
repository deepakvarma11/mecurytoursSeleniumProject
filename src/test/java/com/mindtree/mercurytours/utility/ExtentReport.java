package com.mindtree.mercurytours.utility;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mindtree.mercurytours.reusablecomponents.DataProviderSource;


public class ExtentReport extends TestListenerAdapter {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	static String date = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	static String reportName = "Test-Report-" + date + ".html";
	static String path = System.getProperty("user.dir") + "/extentreports/" + reportName;
	
	
	public ExtentReport() {
		super();
	}

	// creating object of CaptureScreenshot class to capture screenshot of failed
	// cases
	CaptureScreenshot captureobj = new CaptureScreenshot();

	// When the test case is started
	public void onStart(ITestContext testContext) {

		htmlReporter = new ExtentHtmlReporter(path);

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		htmlReporter.config().setDocumentTitle("Let's Work Test");
		htmlReporter.config().setReportName("Let's work report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);

	}

	// When the test case is passed
	public void onTestSuccess(ITestResult testResult) {
		logger = extent.createTest(testResult.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(testResult.getName(), ExtentColor.GREEN));// send the passed
																									// information in
																									// green color
	}

	// When the test case is failed
	public void onTestFailure(ITestResult testResult) {
		logger = extent.createTest(testResult.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(testResult.getName(), ExtentColor.RED));// send the failed
																									// information in
																									// green color
		logger.log(Status.FAIL, "TEST FAILED" + testResult.getThrowable());

		try {
			System.out.println("error");
			logger.fail("Below is the screenshot attached. "
					+ logger.addScreenCaptureFromPath(captureobj.takeScreenshot(DataProviderSource.driver)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// When the test case execution is finished
	public void onFinish(ITestContext testContext) {
		extent.flush();
		try {
			MailSend.send();
		} catch (IOException | MessagingException e) {
			e.printStackTrace();
		}
	}

	public static String sendEmail() {
		Log.info("Sending a mail");
		return path;
	}

}
