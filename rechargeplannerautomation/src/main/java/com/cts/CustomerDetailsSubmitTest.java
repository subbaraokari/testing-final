package com.cts;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.cts.pageobjects.CustomerDetailsPage;
import com.cts.pageobjects.DetailsPage;
import com.cts.pageobjects.ErrorPage;
import com.cts.pageobjects.PackageListPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomerDetailsSubmitTest {
	WebDriver webDriver;

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		webDriver = new ChromeDriver();
		webDriver.get("http://localhost:9028");
	}

	@Test(priority = 2)
	public void checkWhetherThePlanIsNotExpired() {
		//webDriver.get("http://localhost:9028");
		CustomerDetailsPage customerDetailsPage = PageFactory.initElements(webDriver, CustomerDetailsPage.class);
		customerDetailsPage.submitCustomerDetails("ksrao", "9505962345", "2020-03-10", "Airtel Rs.399 30 Days Recharge Plan");
		String msg = customerDetailsPage.getTextFromH1();
		assertEquals(msg, "Your mobile validity is not expired");
	}

	@Test(priority = 3)
	public void testWhetherUserNameIsValid() {
		//webDriver.get("http://localhost:9028");
		CustomerDetailsPage customerDetailsPage = PageFactory.initElements(webDriver, CustomerDetailsPage.class);
		customerDetailsPage.submitCustomerDetails(" ", "9505962345", "10-03-2020", "Airtel Rs.399 30 Days Recharge Plan");
		String nameErrorMsg = customerDetailsPage.getNameErrorText();
		assertEquals(nameErrorMsg, "name is required");

	}

	@Test(priority = 4)
	public void testWhetherMobileNoIsValid() {
		//webDriver.get("http://localhost:9028");
		CustomerDetailsPage customerDetailsPage = PageFactory.initElements(webDriver, CustomerDetailsPage.class);
		customerDetailsPage.submitCustomerDetails("ksrao", " ", "2020-03-10", "Airtel Rs.399 30 Days Recharge Plan");
		String nameErrorMsg = customerDetailsPage.getMobileNoErrorText();
		assertEquals(nameErrorMsg, "mobile no is required");
	}

	@Test(priority = 5)
	public void testInvalidRechargeDateException() {
		//webDriver.get("http://localhost:9028");
		CustomerDetailsPage customerDetailsPage = PageFactory.initElements(webDriver, CustomerDetailsPage.class);
		ErrorPage errorPage = PageFactory.initElements(webDriver, ErrorPage.class);
		customerDetailsPage.submitCustomerDetails("ksrao", "9505962345", "2020-03-15", "Airtel Rs.399 30 Days Recharge Plan");
		String exceptionMsg = errorPage.getExceptionMessage();
		assertEquals(exceptionMsg, "You selected invalid date Please select valid date");
	}

	@Test(priority = 6)
	public void testWhetherLanguageIsEnglish() {
		//webDriver.get("http://localhost:9028");
		CustomerDetailsPage customerDetailsPage = PageFactory.initElements(webDriver, CustomerDetailsPage.class);
		WebElement anchor1 = customerDetailsPage.getEnglishAnchor1();
		anchor1.click();

		String nameLabelTextExpected = customerDetailsPage.getNameLabelText();
		String mobileNoLabelTextExpected = customerDetailsPage.getMobileNoLabelText();
		String previousRechargeLabelTextExpected = customerDetailsPage.getPreviousRechargeLabelText();
		String preciousPackageLabelTextExpected = customerDetailsPage.getPreviousPackageLabelText();
		String submitButtonTextExpected = customerDetailsPage.getSubmitText();
		String anchorTextEnglish = customerDetailsPage.getEnglishAnchorText();
		String anchorTextGerman = customerDetailsPage.getGermanAnchorText();
		String anchorTextFrench = customerDetailsPage.getFrenchAnchorText();
		assertEquals(anchorTextEnglish, "English");
		assertEquals(anchorTextGerman, "German");
		assertEquals(anchorTextFrench, "French");
		assertEquals(nameLabelTextExpected, "Enter your name");
		assertEquals(mobileNoLabelTextExpected, "Enter your mobileno");
		assertEquals(previousRechargeLabelTextExpected, "your previousrechargedate");
		assertEquals(preciousPackageLabelTextExpected, "Your previous package");
		assertEquals(submitButtonTextExpected, "checkStatus");
	}

	@Test(priority = 7)
	public void testWhetherLanguageIsGerman() {
		//webDriver.get("http://localhost:9028");
		CustomerDetailsPage customerDetailsPage = PageFactory.initElements(webDriver, CustomerDetailsPage.class);
		WebElement anchor1 = customerDetailsPage.getGermanAnchor();
		anchor1.click();
		String nameLabelTextExpected = customerDetailsPage.getNameLabelText();
		String mobileNoLabelTextExpected = customerDetailsPage.getMobileNoLabelText();
		String previousRechargeLabelTextExpected = customerDetailsPage.getPreviousRechargeLabelText();
		String preciousPackageLabelTextExpected = customerDetailsPage.getPreviousPackageLabelText();
		String anchorTextEnglish = customerDetailsPage.getEnglishAnchorText();
		String anchorTextGerman = customerDetailsPage.getGermanAnchorText();
		assertEquals(anchorTextEnglish, "Englisch");
		assertEquals(anchorTextGerman, "Deutsche");
		assertEquals(nameLabelTextExpected, "Gib deinen Namen ein");
		assertEquals(mobileNoLabelTextExpected, "Geben Sie Ihr mobilo ein");
		assertEquals(previousRechargeLabelTextExpected, "Ihr vorheriges aufgeladenes Datum");
		assertEquals(preciousPackageLabelTextExpected, "Ihr vorheriges Paket");
	}

	@Test(priority = 8)
	public void testWhetherLanguageIsFrench() {
		//webDriver.get("http://localhost:9028");
		CustomerDetailsPage customerDetailsPage = PageFactory.initElements(webDriver, CustomerDetailsPage.class);
		WebElement anchor1 = customerDetailsPage.getFrenchAnchor();
		anchor1.click();
		String nameLabelTextExpected = customerDetailsPage.getNameLabelText();
		String mobileNoLabelTextExpected = customerDetailsPage.getMobileNoLabelText();
		String previousRechargeLabelTextExpected = customerDetailsPage.getPreviousRechargeLabelText();
		String preciousPackageLabelTextExpected = customerDetailsPage.getPreviousPackageLabelText();
		String anchorTextEnglish = customerDetailsPage.getEnglishAnchorText();
		String anchorTextGerman = customerDetailsPage.getGermanAnchorText();
		assertEquals(anchorTextEnglish, "Anglaise");
		assertEquals(anchorTextGerman, "Allemande");
		assertEquals(nameLabelTextExpected, "Entrez votre nom");
		assertEquals(mobileNoLabelTextExpected, "Entrez votre mobile non");
		assertEquals(previousRechargeLabelTextExpected, "Votre date de recharge pr?c?dente");
		assertEquals(preciousPackageLabelTextExpected, "Votre package s?lectionn? pr?c?dent");
	}

	@Test(priority = 1)
	public void testWhetherAllThePlansAreListedBasedOnPreviosPackageCarrierType() {
		//webDriver.get("http://localhost:9028");
		int carrierCount = 0;
		int rowCount = 0;
		CustomerDetailsPage customerDetailsPage = PageFactory.initElements(webDriver, CustomerDetailsPage.class);
		PackageListPage packageListPage = PageFactory.initElements(webDriver, PackageListPage.class);
		customerDetailsPage.submitCustomerDetails("ksrao", "9505962345", "2020-01-10", "Airtel Rs.399 30 Days Recharge Plan");
		WebElement table = packageListPage.getTableElement();
		int numOfRow = table.findElements(By.tagName("tr")).size();
		// int numOfCol =
		// webDriver.findElements(By.xpath("//*[@id=\"content\"]/table/tbody/tr[2]/td[1]")).size();
		String first_part = "//*[@id=\"content\"]/table/tbody/tr[";
		String second_part = "]/td[";
		String third_part = "]";
		int j = 3;
		List<String> carrierList = new ArrayList<>();
		for (int i = 2; i <= numOfRow; i++) {
			rowCount++;
			String final_xpath = first_part + i + second_part + j + third_part;
			String carrier = webDriver.findElement(By.xpath(final_xpath)).getText();
			carrierList.add(carrier);
			// System.out.println(carrier);
		}
		for (String carrier : carrierList) {
			if (carrier.equalsIgnoreCase("bsnl")) {
				carrierCount++;
			}
		}
		assertEquals(rowCount, carrierCount);
	}

	@Test
	public void testWhetherPlanListIsLoaded() {
		//webDriver.get("http://localhost:9028");
		CustomerDetailsPage customerDetailsPage = PageFactory.initElements(webDriver, CustomerDetailsPage.class);
		PackageListPage packageListPage = PageFactory.initElements(webDriver, PackageListPage.class);
		customerDetailsPage.submitCustomerDetails("ksrao", "9505962345", "2020-01-10", "Airtel Rs.399 30 Days Recharge Plan");
		String headingText = packageListPage.getHeadingText();
		assertEquals(headingText, "List Of Available Packages");
	}
	@AfterTest
	public void afterTest() {
		webDriver.close();
	}
	@Ignore
	@Test
	public void testWhetherSelectedPlanDetailsAreDisplayedInDetailsPage() {
		CustomerDetailsPage customerDetailsPage = PageFactory.initElements(webDriver, CustomerDetailsPage.class);
		PackageListPage packageListPage = PageFactory.initElements(webDriver, PackageListPage.class);
		DetailsPage detailsPage=PageFactory.initElements(webDriver, DetailsPage.class);
		customerDetailsPage.submitCustomerDetails("ksrao", "9505962345", "2020-01-10", "Airtel Rs.399 30 Days Recharge Plan");
		WebElement table = packageListPage.getTableElement();
		int numOfRow = table.findElements(By.tagName("tr")).size();
		// int numOfCol =
		// webDriver.findElements(By.xpath("//*[@id=\"content\"]/table/tbody/tr[2]/td[1]")).size();
		String first_part = "//*[@id=\"content\"]/table/tbody/tr[";
		String second_part = "]/td[";
		String third_part = "]";
		int j = 6;
		int k=2;
		List<WebElement> anchorList = new ArrayList<>();
		List<String> planNames=new ArrayList<>();
		for (int i = 2; i <= numOfRow; i++) {
			String final_xpath = first_part + i + second_part + j + third_part;
			String planName_xpath=first_part+i+second_part+k+third_part;
			WebElement anchor = webDriver.findElement(By.xpath(final_xpath));
			String planName = webDriver.findElement(By.xpath(planName_xpath)).getText();
			System.out.println(anchor.getText());
			anchorList.add(anchor);
			planNames.add(planName);
			System.out.println(planNames);
			anchor.click();
		}
		/*
		 * for(WebElement anchor:anchorList) { anchor.click(); for(String
		 * planName:planNames) { WebDriverWait wait = new WebDriverWait (webDriver, 20);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//*[@id=\"pname\"]"))); String
		 * selectedPlanNameText=detailsPage.getPlanNameText();
		 * assertEquals("The plan Name is : "+planName, selectedPlanNameText); break; }
		 * //System.out.println(anchor.getText()); }
		 */
		
		//String selectedPlanNameText=detailsPage.getPlanNameText();
		//assertEquals(selectedPlanNameText, "The plan Name is : "+planNames.get(1));
	}
}
