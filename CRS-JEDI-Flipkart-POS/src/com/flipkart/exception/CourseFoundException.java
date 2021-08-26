package com.flipkart.exception;

public class CourseFoundException extends Exception{
	private String courseID;
	
	/***
	 * Constructor
	 * @param courseCode
	 */
	public CourseFoundException(String courseCode) {
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
		return "Course with courseCode: " + courseID + " already present in catalog.";
	}
}
