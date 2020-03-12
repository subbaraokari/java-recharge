package com.cts.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CustomerDetailsPage {
	private WebDriver webDriver;
	@FindBy(id = "name")
	private WebElement name;
	@FindBy(id = "mobileNo")
	private WebElement mobileNo;
	@FindBy(id = "re_date")
	private WebElement previousRechargeDate;
	@FindBy(id = "plan")
	private WebElement selectedPackage;
	@FindBy(id = "submit")
	private WebElement submitButton;
	@FindBy(id = "msg")
	private WebElement h1;
	@FindBy(id="nameErr")
	private WebElement nameError;
	@FindBy(id="mobileNoErr")
	private WebElement mobileNoError;
	public CustomerDetailsPage() {
		super();
	}

	public CustomerDetailsPage(WebDriver webDriver) {
		webDriver.get("http://localhost:9028");
		this.webDriver = webDriver;
	}

	public void enterName(String nameToEnter) {
		name.sendKeys(nameToEnter);
	}

	public void enterMobileNo(String mobileNoToEnter) {
		mobileNo.sendKeys(mobileNoToEnter);
	}

	public void enterPreviousRechargeDate(String dateToEnter) {
		previousRechargeDate.sendKeys(dateToEnter);
	}

	public void selectPreviousPackageByVisibleText(String visibleOption) {
		Select previuosPackageDropDown = new Select(selectedPackage);
		previuosPackageDropDown.selectByVisibleText("Bsnl ABC Plan");
	}

	public void selectPreviousPackageByIndex(int index) {

	}

	public void selectPreviousPackageByValue(String value) {

	}

	public void submit() {
		submitButton.click();
	}
	public String getTextFromH1() {
		return h1.getText();
	}
	public String getNameErrorText() {
		return nameError.getText();
	}
	public String getMobileNoErrorText()
	{
		return mobileNoError.getText();
	}
	public void submitCustomerDetails(String name, String mobileNo, String previousRechargeDate,
			String selectedOption) {
		enterName(name);
		enterMobileNo(mobileNo);
		enterPreviousRechargeDate(previousRechargeDate);
		selectPreviousPackageByVisibleText(selectedOption);
		submit();
	}
}
