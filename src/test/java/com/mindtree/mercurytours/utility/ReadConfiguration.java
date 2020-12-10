package com.mindtree.mercurytours.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author M1049027 Purpose: Method to read the configuration properties file,
 *         using Object Repository
 *
 */
public class ReadConfiguration {

	static Properties prop;

	public ReadConfiguration() {
		File src = new File("./configuration.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String readChromePath() {
		String path = prop.getProperty("chromeUrl");
		return path;
	}

	public static String readApplicatonUrl() {
		String appurl = prop.getProperty("webUrl");
		return appurl;
	}

	public static String readExcelPath() {
		String excelPath = prop.getProperty("excelPath");
		return excelPath;
	}

	public String readUserName() {
		String userName = prop.getProperty("userName");
		return userName;
	}

	public String readPassword() {
		String password = prop.getProperty("password");
		return password;
	}

}
