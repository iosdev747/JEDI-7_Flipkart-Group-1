package com.flipkart.exception;

public class CourseNotAssignedToProfessorException extends Exception{
	private String courseId;
	private String professorId;
	
	public CourseNotAssignedToProfessorException(String courseId, String professorId) {
		this.courseId = courseId;
		this.professorId = professorId;
	}
	
	/**
	 * Get courseCode
	 * @return
	 */
	public String getCourseId() {
		return courseId;
	}
	/**
	 * get Professor id
	 * @return
	 */
	public String getProfessorId() {
		return professorId;
	}

	/**
	 * set professor id
	 * @param professorId
	 */
	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}

	/**
	 * set course code
	 * @param courseId
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}


	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "courseCode: " + courseId + " OR professorId: " + professorId + " does not exist!";
	}
}
