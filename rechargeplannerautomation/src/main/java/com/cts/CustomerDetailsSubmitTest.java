package com.cts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cts.exceptions.InvalidRechargeDateException;
import com.cts.pageobjects.CustomerDetailsPage;
import com.cts.pageobjects.ErrorPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomerDetailsSubmitTest {
	WebDriver webDriver;
	@BeforeTest
	public void beforeTest()
	{
		WebDriverManager.chromedriver().setup();
		webDriver=new ChromeDriver();
	}
	@Test
	public void checkWhetherThePlanIsNotExpired() {
		webDriver.get("http://localhost:9028");
		CustomerDetailsPage customerDetailsPage=PageFactory.initElements(webDriver, CustomerDetailsPage.class);
		customerDetailsPage.submitCustomerDetails("ksrao", "9505962345", "10-03-2020", "Airtel ABC Plan");
		String msg=customerDetailsPage.getTextFromH1();
		assertEquals(msg, "Your mobile validity is not expired");
		webDriver.navigate().back();
	}
	@Test
	public void testWhetherUserNameIsValid() {
		webDriver.get("http://localhost:9028");
		CustomerDetailsPage customerDetailsPage=PageFactory.initElements(webDriver, CustomerDetailsPage.class);
		customerDetailsPage.submitCustomerDetails(" ", "9505962345", "10-03-2020", "Airtel ABC Plan");
		String nameErrorMsg=customerDetailsPage.getNameErrorText();
		assertEquals(nameErrorMsg, "name is required");
		webDriver.navigate().back();
	}
	@Test
	public void testWhetherMobileNoIsValid() {
		webDriver.get("http://localhost:9028");
		CustomerDetailsPage customerDetailsPage=PageFactory.initElements(webDriver, CustomerDetailsPage.class);
		customerDetailsPage.submitCustomerDetails("ksrao", " ", "10-03-2020", "Airtel ABC Plan");
		String nameErrorMsg=customerDetailsPage.getMobileNoErrorText();
		assertEquals(nameErrorMsg, "mobileNo is required");
		webDriver.navigate().back();
	}
	@Test
	public void testInvalidRechargeDateException() {
		webDriver.get("http://localhost:9028");
		CustomerDetailsPage customerDetailsPage=PageFactory.initElements(webDriver, CustomerDetailsPage.class);
		ErrorPage errorPage=PageFactory.initElements(webDriver, ErrorPage.class);
		customerDetailsPage.submitCustomerDetails("ksrao", "9505962345", "15-03-2020", "Airtel ABC Plan");
		String exceptionMsg=errorPage.getExceptionMessage();
		assertEquals(exceptionMsg, "You selected invalid date Please select valid date");
	}
}
