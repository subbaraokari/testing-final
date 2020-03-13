package com.cts.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.cts.exceptions.InvalidRechargeDateException;
import com.cts.exceptions.PlanExpiredException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidRechargeDateException.class)
	public ModelAndView handleInvalidDateException(Exception exception) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error");
		modelAndView.addObject("exception", exception);
		return modelAndView;
	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(PlanExpiredException.class)
	public ModelAndView handlePlanExpiredException(Exception exception) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error");
		modelAndView.addObject("exception", exception);
		return modelAndView;
	}
}
