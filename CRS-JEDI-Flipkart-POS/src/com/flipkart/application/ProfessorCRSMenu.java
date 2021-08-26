package com.flipkart.application;

import java.util.Scanner;
import java.util.*;

import com.flipkart.bean.*;
import com.flipkart.business.*;

public class ProfessorCRSMenu {

    Scanner sc = new Scanner(System.in);

    public void createMenu(int professorId){

        boolean logginFlag = true;

        while(logginFlag) {

            System.out.println("----------Welcome To Professor Menu Professor ID : " + professorId + "----------");
            System.out.println("1. View Course");
            System.out.println("2. View Enrolled Students");
            System.out.println("3. Add grade");
            System.out.println("4 LogOut");
            System.out.println("---------------------------------------------------");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewCourse(professorId);
                    break;
                case 2:
                    viewEnrolledStudent(professorId);
                    break;
                case 3:
                    addGrade();
                    break;
                case 4:
                    logginFlag = false;
                    break;
                default:
                    System.out.println("Wrong Input Given");
                    break;
            }

        }

        System.out.println("You are Logged Out");

    }

    private void viewCourse(int profId){ // profId is professorEmpId

        System.out.println("-------All Courses Professor have----------");

        ProfessorInterface professorInterface = new ProfessorOperation();

        List<Course> courseList = professorInterface.getCoursesByProfessor(profId);

        for(Course course : courseList){
            String courseId = course.getCourseId();
            String courseName = course.getCourseName();
            int credit = course.getCredit();

            System.out.println("Course: " + courseId + " , CourseName : " + courseName + " , credit :" + credit);
        }
        System.out.println("--------------------------------------------");


    }

    private void viewEnrolledStudent(int profId){


        System.out.println("-------All Student Enroll With Professor----------");

        ProfessorInterface professorInterface = new ProfessorOperation();

        List<EnrolledStudent> enrolList = professorInterface.getEnrolledStudent(profId);

        for(EnrolledStudent enrol : enrolList){
            String courseId = enrol.getCourseId();
            int studentId = enrol.getStudentId();
            System.out.println("CourseID : " + courseId + " ----> StudentId : " + studentId);
        }

        System.out.println("----------------------------------------------------");

    }

    private void addGrade(){

        System.out.println("-------- Add the Grade to the Student -----------");

        int studentId;
        String courseId;
        double mark;

        System.out.println("Enter the studentId: ");
        studentId = sc.nextInt();
        System.out.println("Enter the courseId: ");
        courseId = sc.next();
        System.out.println("Enter the Grade To assign: ");
        mark = sc.nextDouble();

        ProfessorInterface professorInterface = new ProfessorOperation();

        boolean success = professorInterface.addGrade(studentId, courseId, mark);

        if(success) System.out.println("Grade Added Succesfully");
        else System.out.println("Grade Added Failed");

        System.out.println("-------- ---------------------------- -----------");
    }


}
