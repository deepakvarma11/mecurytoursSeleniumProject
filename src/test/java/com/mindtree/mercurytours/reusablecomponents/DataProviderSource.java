package com.mindtree.mercurytours.reusablecomponents;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.mindtree.mercurytours.utility.Log;
import com.mindtree.mercurytours.utility.PdfUtility;
import com.mindtree.mercurytours.utility.ReadConfiguration;
import com.mindtree.mercurytours.utility.ReadExcel;


public class DataProviderSource {
	protected List<String> resultList = new ArrayList<String>();
	public static WebDriver driver;
	PdfUtility PdfUtility = new PdfUtility();
	ReadConfiguration readConfiguration = new ReadConfiguration();
	String chromePath = ReadConfiguration.readChromePath();
	String applicationUrl = ReadConfiguration.readApplicatonUrl();
	public DataProviderSource() {

	}

	@BeforeSuite
	public void setBeforeSuite() {
		Log.info("At the start of the class");
	}
	
	@BeforeTest
	public void setBeforeTest() {
		Log.info("inside the before test");
	}
	// This for opening browser
		@BeforeClass
		public void invokeBrowser() {
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(applicationUrl);
		}

	

	// DataProvider to read the excel sheet inputs and sending into the application,
	// this method returns the excelsheet data in two dimensional array

	@DataProvider(name = "ReturnFlightBookingData")
	public Object[][] getData() throws Exception {
		String path = ReadConfiguration.readExcelPath();
		System.out.println(path);
		int rowNum = ReadExcel.getRowCount(path, "FlightDetails");
		int colNum = ReadExcel.getCellCount(path, "FlightDetails", 1);
		Object loginData[][] = new Object[rowNum][colNum];

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				loginData[i - 1][j] = ReadExcel.getCellData(path, "FlightDetails", i, j);
			}
		}

		return loginData;
	}
	
	@AfterClass
	public void setAfterClass() {
		Log.info("Inside the after class");
	}
	
	@AfterTest
	public void savingPdfFile() throws IOException {
		driver.close();
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		// add time stamp to the resultList
		resultList.add("Test Ends: " + timeStamp);
		// write the test result pdf file with file name TestResult
		PdfUtility.writeTestResultsToPdfFile("./pdfreports/TestResult" +timeStamp+ ".pdf", resultList);
		driver.quit();
	}	
	
	@AfterSuite
	public void setAfterSuite() {
		Log.info("At the end of the class");
	}

}
