package com.flipkart.exception;

public class CourseNotFoundException extends Exception{
	private String courseID;
	
	public CourseNotFoundException(String courseCode)
	{	
		this.courseID = courseCode;
	}

	/**
	 * Getter function for course code
	 * @return
	 */
	public String getCourseID()
	{
		return courseID;
	}
	

	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() 
	{
		return "Course with courseCode: " + courseID + " not found.";
	}
}
