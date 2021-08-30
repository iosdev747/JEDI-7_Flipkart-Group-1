package com.flipkart.exception;

public class CourseNotDeletedException extends Exception{
	private String courseCode;

	/**
	 * Constructor
	 */
	public CourseNotDeletedException(String courseID)
	{	
		this.courseCode = courseID;
	}

	/**
	 * Getter function for course code
	 * @return
	 */
	public String getCourseCode()
	{
		return courseCode;
	}
	
	/**
	 * Message thrown by exception
	 */
	@Override
	public String getMessage() 
	{
		return "Course with courseCode: " + courseCode + " can not be deleted.";
	}
}
