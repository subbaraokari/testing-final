package com.cts.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ErrorPage {
	private WebDriver webDriver;
	private WebElement exceptionMsg;
	public ErrorPage(WebDriver webDriver) {
		this.webDriver=webDriver;
	}
	public String getExceptionMessage() {
		return exceptionMsg.getText();
	}
	
	
}
