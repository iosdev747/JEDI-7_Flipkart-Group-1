package com.flipkart.application;

import java.util.Scanner;
import java.util.*;

import com.flipkart.bean.*;
import com.flipkart.business.*;

public class StudentCRSMenu {

    Scanner sc = new Scanner(System.in);



    public void createMenu(int studentId){


        System.out.println("----------Welcome To Student Menu StudentID : " + studentId + "----------");
        System.out.println("1. Add Course");
        System.out.println("2. Drop Course");
        System.out.println("3. View Course");
        System.out.println("4. View Registered Course");
        System.out.println("5. View Grade Card");
        System.out.println("6. LogOut");
        System.out.println("---------------------------------------------");

        int choice = sc.nextInt();

        // It will be given after only 3 is
        switch(choice){
            case 1:
                //addCourse(studentId);
                break;
            case 2:
                //dropCourse(studentId);
                break;
            case 3:
                viewCourse(studentId);
                break;
            case 4:
                //viewRegisteredCourse(studentId);
                break;
            case 5:
                //viewGradeCard(studentId);
                break;
            default:
                System.out.println("You are loggedOut");
                break;
        }
    }

    private void viewCourse(int studentId){

        RegistrationInterface registrationInterface = new RegistrationOperation();
        List<Course> courseList = registrationInterface.viewCourse();


        for(Course course : courseList){
            String courseId = course.getCourseId();
            String courseName = course.getCourseName();
            int credit = course.getCredit();
            int professorEmpId = course.getProfessorEmpId();
            double fee = course.getFee();
            System.out.println("CourseId : " + courseId + " , CourseName : " + courseName + " , credit : " + credit);
        }
    }
}
