package com.vj.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {

		/*
		 * to read properties file add a class called properties
		 * 
		 * 
		 */

		System.out.println(System.getProperty("user.dir"));

		Properties Config = new Properties();
		Properties OR = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
		Config.load(fis);
		System.out.println(Config.getProperty("browser"));
		fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\ObjectRepositories.properties");
		OR.load(fis);
		/* during runtime -
		 * driver.findElement(By.cssSelector(OR.getProperty("BankManagerLoginButton"))).click();
		 */
		System.out.println(OR.getProperty("BankManagerLoginButton"));

	}

}
