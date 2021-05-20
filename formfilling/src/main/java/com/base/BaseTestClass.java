package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTestClass {

	public WebDriver instantiateDriver() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/googlechrome/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		return driver;
	}
}
