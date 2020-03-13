package com.cts.exceptions;

public class PlanExpiredException extends RuntimeException {
	public PlanExpiredException(String message)
	{
		super(message);
	}
}
