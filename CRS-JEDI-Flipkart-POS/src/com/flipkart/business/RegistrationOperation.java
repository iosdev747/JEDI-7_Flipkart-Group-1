package com.flipkart.business;

import java.util.*;

import com.flipkart.bean.Course;
import com.flipkart.dao.RegistrationDaoInterface;
import com.flipkart.dao.RegistrationDaoOperation;

public class RegistrationOperation implements RegistrationInterface{

    public RegistrationOperation() {   // In future may be change to private
    }

    @Override
    public boolean addCourse(String courseId, int studentId){
        RegistrationDaoInterface registrationInterface = new RegistrationDaoOperation();
        return registrationInterface.addCourse(courseId, studentId);
    }

    @Override
    public boolean dropCourse(String courseId, int studentId){
        RegistrationDaoInterface registrationInterface = new RegistrationDaoOperation();
        return registrationInterface.dropCourse(courseId, studentId);
    }

    @Override
    public List<Course> viewCourse(){
        RegistrationDaoInterface registrationInterface = new RegistrationDaoOperation();
        return registrationInterface.viewCourse();
    }


    @Override
    public List<Course> viewRegisterCourse(int studentId){
        RegistrationDaoInterface registrationInterface = new RegistrationDaoOperation();
        return registrationInterface.viewRegisterCourse(studentId);
    }

    @Override
    public double calculate(int studentId){
        RegistrationDaoInterface registrationInterface = new RegistrationDaoOperation();
        return registrationInterface.calculate(studentId);
    }

    @Override
    public int numOfRegisteredCourses(int studentId){
        RegistrationDaoInterface registrationInterface = new RegistrationDaoOperation();
        return registrationInterface.numOfRegisteredCourses(studentId);
    }

    @Override
    public boolean isRegistered(String courseId, int studentId){
        RegistrationDaoInterface registrationInterface = new RegistrationDaoOperation();
        return registrationInterface.isRegistered(courseId, studentId);
    }
}
