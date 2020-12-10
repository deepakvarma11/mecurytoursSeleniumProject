package com.mindtree.mercurytours.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot {
	public static Date date = new Date();
	public static DateFormat dateformat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	File myFile;

	public CaptureScreenshot() {
		super();
	}

	public String takeScreenshot(WebDriver driver) {

		myFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotName = "screenshot-" + dateformat.format(date) + ".png";

		try {
			System.out.println("error");
			FileUtils.copyFile(myFile, new File(System.getProperty("user.dir") + "/screenshot/" + screenshotName));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String currentScreenshotPath = System.getProperty("user.dir") + "/screenshot/" + screenshotName;
		System.out.println(currentScreenshotPath);
		return currentScreenshotPath;
	}

}
