package com.cts.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class DetailsPage {
	private WebDriver webDriver;
	@FindBy(xpath = "//*[@id=\"pname\"]")
	private WebElement planNameElement;
	public DetailsPage() {
		
	}
	public DetailsPage(WebDriver webDriver) {
		webDriver.get("http://localhost:9028");
		this.webDriver = webDriver;
	}
	public String getPlanNameText() {
		return planNameElement.getText().trim();
	}	
}
