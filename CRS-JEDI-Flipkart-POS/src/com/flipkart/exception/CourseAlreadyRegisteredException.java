package com.flipkart.exception;

public class CourseAlreadyRegisteredException extends Exception{
	
	private String courseID;
	
	/**
	 * Constructor
	 * @param courseCode
	 */
	public CourseAlreadyRegisteredException(String courseCode) {
		this.courseID = courseCode;
	}
	
	/**
	 * Getter method
	 * @return course code
	 */
	public String getCourseID() {
		return courseID;
	}
	
	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "You have already registered for " + courseID;
	}

}
