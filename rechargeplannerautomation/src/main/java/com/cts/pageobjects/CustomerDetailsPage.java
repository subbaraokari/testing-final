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
	@FindBy(id="nameError")
	private WebElement nameError;
	@FindBy(id="mobileNoError")
	private WebElement mobileNoError;
	@FindBy(id = "namelbl")
	private WebElement nameLabel;
	@FindBy(id="mobileNoLbl")
	private WebElement mobileNoLabel;
	@FindBy(id="previousRechargeLbl")
	private WebElement prevoiusRechargeLabel;
	@FindBy(id="previousPackageLbl")
	private WebElement previousPackageLabel;
	@FindBy(xpath = "/html/body/div[1]/a[1]")
	private WebElement anchor1;
	@FindBy(xpath = "/html/body/div[1]/a[2]")
	private WebElement anchor2;
	@FindBy(xpath = "/html/body/div[1]/a[3]")
	private WebElement anchor3;
	
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
		previousRechargeDate.clear();
		previousRechargeDate.sendKeys(dateToEnter);
	}

	public void selectPreviousPackageByVisibleText(String visibleOption) {
		Select previuosPackageDropDown = new Select(selectedPackage);
		previuosPackageDropDown.selectByVisibleText("Bsnl ABC Plan");
	}

	public void submit() {
		submitButton.click();
	}
	public String getTextFromH1() {
		return h1.getText().trim();
	}
	public String getNameErrorText() {
		return nameError.getText().trim();
	}
	public String getMobileNoErrorText()
	{
		return mobileNoError.getText().trim();
	}
	public String getNameLabelText()
	{
		return nameLabel.getText().trim();
	}
	public String getMobileNoLabelText() {
		return mobileNoLabel.getText().trim();
	}
	public String getPreviousRechargeLabelText()
	{
		return prevoiusRechargeLabel.getText().trim();
	}
	public String getPreviousPackageLabelText() {
		return previousPackageLabel.getText().trim();
	}
	public String getSubmitText() {
		return submitButton.getText().trim();
	}
	public WebElement getEnglishAnchor1()
	{
		return anchor1;
	}
	public WebElement getGermanAnchor() {
		return anchor2;
	}
	public WebElement getFrenchAnchor()
	{
		return anchor3;
	}
	public String getEnglishAnchorText() {
		return anchor1.getText().trim();
	}
	public String getGermanAnchorText() {
		return anchor2.getText().trim();
	}
	public String getFrenchAnchorText()
	{
		return anchor3.getText().toString();
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
