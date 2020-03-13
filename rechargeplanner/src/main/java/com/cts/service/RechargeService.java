package com.cts.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.exceptions.InvalidRechargeDateException;
import com.cts.exceptions.PlanExpiredException;
import com.cts.model.CustomerDetails;
import com.cts.model.RechargePackage;

@Service
public class RechargeService {
	private List<RechargePackage> packages;

	public RechargeService() {
		packages = new ArrayList<RechargePackage>();
		packages.add(new RechargePackage(1, "Airtel Rs.399 30 Days Recharge Plan", "airtel", 30, 399));
		packages.add(new RechargePackage(2, "Airtel Rs.500 45 Days Recharge Plan", "airtel", 45, 500));
		packages.add(new RechargePackage(3, "Airtel Rs.420 69 Days Recharge Plan", "airtel", 69, 420));
		packages.add(new RechargePackage(4, "Bsnl Rs.299 30 Days Recharge Plan", "bsnl", 30, 299));
		packages.add(new RechargePackage(5, "Bsnl Rs.500 60 Days Recharge Plan", "bsnl", 60, 500));
		packages.add(new RechargePackage(6, "Bsnl Rs.198 30 Days Recharge Plan", "bsnl", 30, 198));
		packages.add(new RechargePackage(7, "Cellone Rs.350 30 Days Recharge Plan", "cellone", 30, 350));
		packages.add(new RechargePackage(8, "Cellone Rs.500 45 Days Recharge Plan", "cellone", 45, 500));
		packages.add(new RechargePackage(9, "Cellone Rs.666 66 Days Recharge Plan", "cellone", 66, 666));
	}

	public boolean checkStatus(CustomerDetails customerDetails) {
		List<RechargePackage> packages;
		boolean active = false;
		Date previousReachargeDate = customerDetails.getPreviousRechargeDate();
		String previousSelectedPackage = customerDetails.getPreviousSelectedPackage();
		packages=getAllPackages();
		System.out.println(packages);
		int validity = getValidity(packages, previousSelectedPackage);
		System.out.println(validity);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(previousReachargeDate);
		calendar.add(Calendar.DATE, validity);
		Date nextRechargeDate = calendar.getTime();
		Date currentDate = new Date();
		System.out.println(previousReachargeDate);
		System.out.println(nextRechargeDate);
		if (nextRechargeDate.compareTo(currentDate) > 0) {
			active = true;
		}
		if (previousReachargeDate.compareTo(currentDate) > 0) {
			throw new InvalidRechargeDateException("You selected invalid date Please select valid date");
		}
		/*
		 * if(nextRechargeDate.compareTo(currentDate)<0) { throw new
		 * PlanExpiredException("Your Plan is Expired"); }
		 */
		return active;
	}
	private int getValidity(List<RechargePackage> packages, String previousSelectedPackage) {
		int validity=0;
		for (RechargePackage rechargePackage : packages) {
			if (rechargePackage.getPackageName().equalsIgnoreCase(previousSelectedPackage)) {
				System.out.println(rechargePackage.getPackageName());
				System.out.println(rechargePackage.getValidity());
				validity =rechargePackage.getValidity();
			}
		}
		return validity;
	}

	public List<RechargePackage> getAllPackagesByPlanName(String packageName) {
		List<RechargePackage> packs;
		String carrier = null;
		for (RechargePackage pack : packages) {
			if (pack.getPackageName().equalsIgnoreCase(packageName)) {
				carrier = pack.getCarrierType();
			}
		}
		packs = getAllPackages(carrier);
		return packs;

	}
	public List<RechargePackage> getAllPackages()
	{
		return packages;
	}
	public List<RechargePackage> getAllPackages(String carrierType) {
		List<RechargePackage> packs = new ArrayList<RechargePackage>();
		for (RechargePackage pack : packages) {
			if (pack.getCarrierType().equalsIgnoreCase(carrierType)) {
				packs.add(pack);
			}
		}
		return packs;
	}

	public LinkedHashMap<String, String> getPackageNames() {
		LinkedHashMap<String, String> packageNames = new LinkedHashMap<String, String>();
		for (RechargePackage pack : packages) {
			packageNames.put(pack.getPackageName(), pack.getPackageName());
		}
		return packageNames;
	}

	public RechargePackage getPackage(int pid) {
		RechargePackage selectedPackage = null;
		for (RechargePackage pack : packages) {
			if (pack.getId() == pid)
				selectedPackage = pack;
		}
		return selectedPackage;
	}

}
