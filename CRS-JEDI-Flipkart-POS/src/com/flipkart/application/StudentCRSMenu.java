package com.flipkart.application;

import java.util.Scanner;
import java.util.*;

import com.flipkart.bean.*;
import com.flipkart.business.*;

public class StudentCRSMenu {

    Scanner sc = new Scanner(System.in);



    public void createMenu(int studentId){
        boolean logginFlag = true;

        while(logginFlag) {

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
            switch (choice) {
                case 1:
                    addCourse(studentId);
                    break;
                case 2:
                    dropCourse(studentId);
                    break;
                case 3:
                    viewCourse(studentId);
                    break;
                case 4:
                    viewRegisteredCourse(studentId);
                    break;
                case 5:
                    viewGradeCard(studentId);
                    break;
                case 6:
                    logginFlag = false;
                    break;
                default:
                    System.out.println("Wrong Option selected");
                    break;
            }

        }

        System.out.println("You Are Logged Out");
    }

    private void viewCourse(int studentId){

        System.out.println("-------All Courses Available----------");

        RegistrationInterface registrationInterface = new RegistrationOperation();
        List<Course> courseList = registrationInterface.viewCourse();


        for(Course course : courseList){
            String courseId = course.getCourseId();
            String courseName = course.getCourseName();
            int credit = course.getCredit();
            int professorEmpId = course.getProfessorEmpId();
            double fee = course.getFee();
            System.out.println("CourseId : " + courseId + " , CourseName : " + courseName + " , credit : " + credit + " , ProfessorEmpId: " + professorEmpId + " , fee: "+ fee);
        }

        System.out.println("---------------------------------------");
    }

    private void addCourse(int studentId){

        System.out.println("-----You can Enter Add Course Window------");
        System.out.println("Do you Want to view courses press 1 else 0");

        int choice = sc.nextInt();
        if(choice == 1) viewCourse(studentId);
        System.out.println("Enter the Course you selected: ");

        String courseId = sc.next();

        RegistrationInterface registrationInterface = new RegistrationOperation();

        boolean success = registrationInterface.addCourse(courseId, studentId);

        if(success){
            System.out.println("Course Registration Successful");
        }
        else{
            System.out.println("Course Registration fail");
        }
    }

    private void viewRegisteredCourse(int studentId){

        RegistrationInterface registrationInterface = new RegistrationOperation();

        List<Course> courseList = registrationInterface.viewRegisterCourse(studentId);

        System.out.println("---Your Registered Courses Are----");
        for(Course course : courseList){
            String courseId = course.getCourseId();
            String courseName = course.getCourseName();
            int credit = course.getCredit();
            int professorEmpId = course.getProfessorEmpId();
            double fee = course.getFee();
            System.out.println("CourseId : " + courseId + " , CourseName : " + courseName + " , credit : " + credit);
        }

        System.out.println("----------------------------------");

    }

    private void dropCourse(int studentId){

        System.out.println("-----You can Enter Drop Course Window------");
        System.out.println("To View all your Courses Press 1 else 0 : ");

        int choice = sc.nextInt();

        if(choice == 1) viewRegisteredCourse(studentId);

        System.out.println("Enter The courseID of course to be Dropped:");

        String courseId = sc.next();

        RegistrationInterface registrationInterface = new RegistrationOperation();

        boolean success = registrationInterface.dropCourse(courseId, studentId);

        if(success) System.out.println("Course Drop Successful");
        else{
            System.out.println("Course Drop fail");
        }

        System.out.println("---------------------------------------------");
    }


    private void viewGradeCard(int studentId){

        System.out.println("--------View Your Grade Card----------");

        StudentInterface studentInterface = new StudentOperation();

        List<Grade> gradeList = studentInterface.getGrade(studentId);

        for(Grade grade : gradeList){
            String courseId = grade.getCourseId();
            double mark = grade.getGrade();

            System.out.println("courseId : " + courseId + " ---> " + mark);
        }

        System.out.println("---------------------------------------");
    }

}
