package com.cts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cts.pageobjects.CustomerDetailsPage;

public class Test {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		WebDriver webDriver=new ChromeDriver();
		CustomerDetailsPage detailsPage=new CustomerDetailsPage(webDriver);
		detailsPage.submitCustomerDetails("ksrao", "9505962345", "2020-03-10", "Airtel ABC Plan");
		
	}

}
