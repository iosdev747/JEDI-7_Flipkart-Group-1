package com.flipkart.exception;

public class SeatNotAvailableException extends Exception{
	
	private String courseID;

	/**
	 * Constructor
	 * @param courseCode
	 */
	public SeatNotAvailableException(String courseID)
	{	
		this.courseID = courseID;
	}


	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return  "Seats are not available in : " + courseID;
	}


}
