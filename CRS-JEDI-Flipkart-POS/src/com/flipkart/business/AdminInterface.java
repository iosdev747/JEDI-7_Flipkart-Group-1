package com.flipkart.business;

import java.util.*;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.exception.*;

public interface AdminInterface {

    public void deleteCourse(String courseId) throws CourseNotFoundException, CourseNotDeletedException;

    public void addCourse(String courseId, String courseName, int credit, String professorEmpId, double fee) throws CourseFoundException;


    // this two depend on the isApproved in DB which is not in student
    public List<Student> viewPendingAdmissions();

    public void approveStudent(String studentId) throws StudentNotFoundForApprovalException;


    public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException;

    public void addUser(User user) throws UserNotAddedException, UserIdAlreadyInUseException;

    public void assignCourse(String courseId, String professorEmpId) throws CourseNotFoundException, UserNotFoundException;

    public List<Professor> viewProfessor();

    public boolean verifyProfessor(int userId);

    public String getAdminId(int userId);

}
