package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseTestClass;
import com.qa.utilities.WebElementsList;

import excelutils.ExcelUtils;

public class OpenBrowserFillForm {

	WebDriver driver;
	ExcelUtils obj = new ExcelUtils();

	// Creating object to access web elements
	WebElementsList webElements = new WebElementsList();

	@BeforeClass
	public void intantiateDriver() {
		BaseTestClass baseTest = new BaseTestClass();// creating object for BaseTestClass, where our driver
														// initialization done
		driver = baseTest.instantiateDriver();// assigning driver object
	}

	@Test(dataProvider = "get-url")
	public void formFilling(String url) {

		driver.manage().window().maximize();// maximizing window

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// enter first name
		driver.findElement(webElements.firstNameId).sendKeys(webElements.firstName);

		// enter last name
		driver.findElement(webElements.lastNameId).sendKeys(webElements.lastName);

		// enter emailID
		driver.findElement(webElements.emailId).sendKeys(webElements.email);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByClassName(\"custom-control-label\")[0].click()" + ";");

		// enter mobile number
		driver.findElement(webElements.mobileNumber).sendKeys(webElements.mobileNo);

		js.executeScript("document.getElementById(\"dateOfBirthInput\").click()" + ";");

		Select val;
		val = new Select(driver.findElement(By.className("react-datepicker__month-select")));

		val.selectByVisibleText("May");

		val = new Select(driver.findElement(By.className("react-datepicker__year-select")));

		val.selectByVisibleText("2011");

		js.executeScript(
				"document.getElementsByClassName(\"react-datepicker__day react-datepicker__day--004\")[0].click()"
						+ ";");

		js.executeScript(
				"document.getElementsByClassName(\"custom-control custom-checkbox custom-control-inline\")[0].getElementsByClassName(\"custom-control-label\")[0].click()"
						+ ";");

		js.executeScript("document.getElementsByTagName(\"textarea\")[0].value = \"Hyderabad,Telangana\"");

		driver.findElement(By.id("uploadPicture")).sendKeys("D:\\image\\kora logo.png");
		
		
		//auto complete is pending

	}

	@AfterClass
	public void closeDriver() {
		// driver.close();
	}

	@DataProvider(name = "get-url")
	public String[] dataProviderfunc() throws IOException {

		String[] url = new String[1];
		url[0] = ExcelUtils.cellData();
		return url;
	}

}
