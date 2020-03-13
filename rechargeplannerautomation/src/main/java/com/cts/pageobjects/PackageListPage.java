package com.cts.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PackageListPage {
	@FindBy(xpath = "//*[@id=\"content\"]/table")
	private WebElement tableElement;
	private WebElement chooseBtn;
	@FindBy(id="plan-list")
	private WebElement headingElement;
	public WebElement getTableElement() {
		return tableElement;
	}
	public String getHeadingText() {
		return headingElement.getText().trim();
	}
}
