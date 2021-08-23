package com.flipkart.service;

public interface AdminInterface {

	public boolean deleteCourse(String courseId);

	public boolean addCourse(Course course);

	public boolean verifyStudentProfile(String studentId);

	public boolean addProfessor(Professor professor);

	public List<Course> viewCourses(int catalogId);

	public List<Professor> viewProfessors();
}
