package com.flipkart.dao;

import java.util.*;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.UserNotAddedException;


public interface AdminDaoInterface {

    public void deleteCourse(String courseId);

    public void addCourse(Course course);

    /*
    // this two depend on the isApproved in DB which is not in student
    public List<Student> viewPendingAdmissions();
    public void approveStudent(int studentId);
     */

    public void addProfessor(Professor professor) throws ProfessorNotAddedException;

    public void addUser(User user) throws UserNotAddedException;

    public void assignCourse(String courseId, String professorEmpId);

    public List<Professor> viewProfessor();

    public boolean verifyProfessor(int userId);

    public int getAdminId(int userId);

}