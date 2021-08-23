package src.com.flipkart.service;

import com.flipkart.bean.Student;

public interface courseInterface {
	public Course[] getCourseCatalog();

	public Course getCourseObject(String courseId);

	public Professor getProfessor(String courseId);

	public Student[] getEnrolledStudents(String courseId);

	public boolean isAvailable(String courseId);

}
