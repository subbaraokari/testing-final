package com.cts.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cts.exceptions.InvalidRechargeDateException;
import com.cts.model.CustomerDetails;
import com.cts.model.RechargePackage;
import com.cts.service.RechargeService;
import com.cts.util.DateUtil;

class RechargeServiceTest {
	
	RechargeService rechargeService;
	
	public RechargeServiceTest() {
		super();
		this.rechargeService = new RechargeService();
	}
	@Test
	public void testWhetherTheRechargeStatusIsActive() {
		CustomerDetails customerDetails=new CustomerDetails("ksrao", "9505962345", "Airtel", DateUtil.convertToDate("2020-03-12"),"Airtel Rs.399 30 Days Recharge Plan");
		boolean status=rechargeService.checkStatus(customerDetails);
		System.out.println(status);
		assertTrue(status);
	}
	@Test
	public void testWhetherTheRechargeStatusIsNotActive() {
		CustomerDetails customerDetails=new CustomerDetails("ksrao", "9505962345", "Airtel", DateUtil.convertToDate("2020-01-12"),"Airtel Rs.399 30 Days Recharge Plan");
		boolean status=rechargeService.checkStatus(customerDetails);
		System.out.println(status);
		assertFalse(status);
	}
	@Test
	public void testWhetherCheckStatusMethodThrowsException() throws InvalidRechargeDateException {
		CustomerDetails customerDetails=new CustomerDetails("ksrao", "9505962345", "Airtel", DateUtil.convertToDate("2020-03-17"),"Airtel Rs.399 30 Days Recharge Plan");
		Assertions.assertThrows(InvalidRechargeDateException.class, ()->{
			rechargeService.checkStatus(customerDetails);
		});		
	}
	@Test
	public void testGetAllPackagesByPlanName() {
		String planName="Airtel Rs.399 30 Days Recharge Plan";
		List<RechargePackage> packages=rechargeService.getAllPackagesByPlanName(planName);
		assertNotNull(packages);
	}
	
	@Test
	public void testGetAllPackages() {
		List<RechargePackage> packages=rechargeService.getAllPackages();
		assertNotNull(packages);
	}

	@Test
	public void testGetPackageNames() {
		HashMap<String, String> packageNames=rechargeService.getPackageNames();
		assertNotNull(packageNames);
	}

}
