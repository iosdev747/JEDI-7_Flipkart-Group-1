package com.flipkart.application;

import java.util.Scanner;
import java.util.*;
import java.sql.*;

import com.flipkart.bean.*;
import com.flipkart.business.*;
import com.flipkart.exception.*;

import org.apache.log4j.Logger;


public class ProfessorCRSMenu {

    private static Logger logger = Logger.getLogger(ProfessorCRSMenu.class);

    Scanner sc = new Scanner(System.in);

    public void createMenu(String professorId){

        boolean logginFlag = true;

        while(logginFlag) {

            logger.info("----------Welcome To Professor Menu Professor ID : " + professorId + "----------");
            logger.info("1. View Course");
            logger.info("2. View Enrolled Students");
            logger.info("3. Add grade");
            logger.info("4 LogOut");
            logger.info("---------------------------------------------------");

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
                    logger.info("Wrong Input Given");
                    break;
            }

        }

        logger.info("You are Logged Out");

    }

    private void viewCourse(String profId){ // profId is professorEmpId

        logger.info("-------All Courses Professor have----------");

        ProfessorInterface professorInterface = new ProfessorOperation();

        List<Course> courseList = professorInterface.getCoursesByProfessor(profId);

        for(Course course : courseList){
            String courseId = course.getCourseId();
            String courseName = course.getCourseName();
            int credit = course.getCredit();

            logger.info("Course: " + courseId + " , CourseName : " + courseName + " , credit :" + credit);
        }
        logger.info("--------------------------------------------");


    }

    private void viewEnrolledStudent(String profId){

        try {

            logger.info("-------All Student Enroll With Professor----------");

            ProfessorInterface professorInterface = new ProfessorOperation();

            List<EnrolledStudent> enrolList = professorInterface.getEnrolledStudent(profId);

            for (EnrolledStudent enrol : enrolList) {
                String courseId = enrol.getCourseId();
                String studentId = enrol.getStudentId();
                logger.info("CourseID : " + courseId + " ----> StudentId : " + studentId);
            }

            logger.info("----------------------------------------------------");
        }
        catch(SQLException e){
            logger.error("SQL Exception: " + e.getMessage());
        }
    }

    private void addGrade() {

        try {
            logger.info("-------- Add the Grade to the Student -----------");

            String studentId;
            String courseId;
            double mark;

            logger.info("Enter the studentId: ");
            studentId = sc.next();
            logger.info("Enter the courseId: ");
            courseId = sc.next();
            logger.info("Enter the Grade To assign: ");
            mark = sc.nextDouble();

            ProfessorInterface professorInterface = new ProfessorOperation();

            boolean success = professorInterface.addGrade(studentId, courseId, mark);

            if (success) logger.info("Grade Added Succesfully");
            else logger.info("Grade Added Failed");

            logger.info("-------- ---------------------------- -----------");
        }
        catch(GradeNotAddedException e){
            logger.error(e.getMessage());
        }
    }


}
