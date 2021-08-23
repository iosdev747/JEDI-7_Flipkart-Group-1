package com.flipkart.service;

import com.flipkart.bean.Course;

public interface ProfessorInterface {

	public boolean addGrade(int studentId, String courseCode, String grade);

	public boolean applyCourse(String courseId, int professorId);

	public Course[] viewCourse(int professorId);

	public Professor getProfessorObject(String professorId);

	public Student[] viewEnrolledStudents(String courseId, String professorId);

}
