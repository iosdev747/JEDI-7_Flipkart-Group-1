package com.flipkart.business;

import java.util.*;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;

import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.dao.AdminDaoOperation;

public class AdminOperation implements AdminInterface{

    public AdminOperation() {   // In future may be change to private
    }

    @Override
    public void deleteCourse(String courseId){
        AdminDaoInterface adminInterface = new AdminDaoOperation();
        adminInterface.deleteCourse(courseId);
    }

    @Override
    public void addCourse(String courseId, String courseName, int credit, int professorEmpId, double fee){
        Course course = new Course(courseId, courseName, credit, professorEmpId, fee);
        AdminDaoInterface adminInterface = new AdminDaoOperation();
        adminInterface.addCourse(course);
    }


    @Override
    public void addProfessor(Professor professor){
        AdminDaoInterface adminInterface = new AdminDaoOperation();
        adminInterface.addProfessor(professor);
    }


    @Override
    public void addUser(User user){
        AdminDaoInterface adminInterface = new AdminDaoOperation();
        adminInterface.addUser(user);
    }

    @Override
    public void assignCourse(String courseId, String professorEmpId){
        AdminDaoInterface adminInterface = new AdminDaoOperation();
        adminInterface.assignCourse(courseId, professorEmpId);
    }


    @Override
    public List<Professor> viewProfessor(){
        AdminDaoInterface adminInterface = new AdminDaoOperation();
        return adminInterface.viewProfessor();
    }

    @Override
    public boolean verifyProfessor(int userId){
        AdminDaoInterface adminInterface = new AdminDaoOperation();
        return adminInterface.verifyProfessor(userId);
    }

    @Override
    public int getAdminId(int userId){
        AdminDaoInterface adminInterface = new AdminDaoOperation();
        return adminInterface.getAdminId(userId);
    }

}
