package com.flipkart.service;

public interface StudentInterface {

	public Grade getGrade(String studentId, String courseId);

	public Course[] viewCourse(String studentId);

	public boolean enrollCourse(String courseId, String studentId);

	public boolean dropCourse(String courseId, String studentId);

	public Student getStudentObject(String userId);

}
