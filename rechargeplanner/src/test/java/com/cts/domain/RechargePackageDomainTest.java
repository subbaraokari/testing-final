package com.cts.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cts.model.RechargePackage;

public class RechargePackageDomainTest {

	static RechargePackage rechargePackage;

	@BeforeAll
	public static void setUp() {
		rechargePackage = new RechargePackage();
	}
	@Test
	void testExpectedId() {
		int id = 2;
		rechargePackage.setId(id);
		assertNotNull(id);
		assertEquals(id, rechargePackage.getId());
	}
	@Test
	public void testShoudReturnCorrectPackage() {
		String packageName = "Airtel ABC Plan";
		rechargePackage.setPackageName(packageName);
		assertEquals(packageName, rechargePackage.getPackageName());
	}
	@Test
	public void testShouldReturnCorrectCarrierType() {
		String carrierType = "Airtel";
		rechargePackage.setCarrierType(carrierType);
		assertEquals(carrierType, rechargePackage.getCarrierType());

	}
	@Test
	public void testShouldReturnCorrectValidity() {
		int validity = 3;
		rechargePackage.setValidity(validity);
		assertEquals(validity, rechargePackage.getValidity());
	}
	@Test
	public void testShouldReturnCorrectPrice() {
		int price = 399;
		rechargePackage.setPrice(price);
		assertEquals(price, rechargePackage.getPrice());
	}
	@AfterAll
	public static void tearDown()
	{
		rechargePackage=null;
	}

}
