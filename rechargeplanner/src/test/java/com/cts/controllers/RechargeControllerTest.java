package com.cts.controllers;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.cts.model.CustomerDetails;
import com.cts.service.RechargeService;
import com.cts.util.DateUtil;

public class RechargeControllerTest {
	@Mock
	RechargeService rechargeService;
	MockMvc mockMvc;
	@Mock
	Model model;
	RechargeController rechargeController;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		rechargeController = new RechargeController();
		mockMvc= MockMvcBuilders.standaloneSetup(rechargeController).build();
	}

	@Test
	public void testMockMVC() throws Exception {
		

		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
	}

	@Test
	public void checkStatusTest() {
		
		Boolean status=true;
		when(rechargeService.checkStatus((CustomerDetails) any(CustomerDetails.class))).thenReturn(status);
		 mockMvc.perform(get("/check"))
         .andExpect(status().isOk())
         .andExpect(view().name("list"))
         .andExpect(MockMvcResultMatchers.model().attributeExists("Your mobile validity is not expired"));
		 verify(rechargeService, times(1).);
	}

	@Test
	public void showTest() {

	}

	@Test
	public void showDetailPageTest() {

	}
}
