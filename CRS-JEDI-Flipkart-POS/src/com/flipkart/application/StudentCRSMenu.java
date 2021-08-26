package com.flipkart.application;

import java.util.Scanner;
import java.util.*;
import java.sql.SQLException;

import com.flipkart.bean.*;
import com.flipkart.business.*;
import com.flipkart.exception.*;
import org.apache.log4j.Logger;

public class StudentCRSMenu {

    private static Logger logger = Logger.getLogger(StudentCRSMenu.class);
    Scanner sc = new Scanner(System.in);



    public void createMenu(String studentId){
        boolean logginFlag = true;

        while(logginFlag) {

            logger.info("----------Welcome To Student Menu StudentID : " + studentId + "----------");
            logger.info("1. Add Course");
            logger.info("2. Drop Course");
            logger.info("3. View Course");
            logger.info("4. View Registered Course");
            logger.info("5. View Grade Card");
            logger.info("6. Check If Approved");
            logger.info("7. Make Payment");
            logger.info("8. LogOut");
            logger.info("---------------------------------------------");

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
                    checkIfApproved(studentId);
                    break;
                case 7:
                    makePayment(studentId);
                    break;
                case 8:
                    logginFlag = false;
                    break;
                default:
                    logger.info("Wrong Option selected");
                    break;
            }

        }

        logger.info("You Are Logged Out");
    }

    private void makePayment(String studentId){

        try {

            logger.info("----------Make Payment ------------");

            RegistrationInterface registrationInterface = new RegistrationOperation();

            double amount = registrationInterface.calculate(studentId);
            //int numOfCourse = registrationInterface.numOfRegisteredCourses(studentId);

            logger.info("Your total amount is : " + amount);

            logger.info("------------------------------------");
        }
        catch (SQLException e){
            logger.error(e.getMessage());
        }
    }

    private void checkIfApproved(String studentId){

        StudentInterface studentInterface = new StudentOperation();

        boolean check = studentInterface.isApproved(studentId);

        if(check){
            logger.info("--------------------------------------");
            logger.info("Your Registration is Approved by Admin");
            logger.info("--------------------------------------");
        }
        else{
            logger.info("------------------------------------------");
            logger.info("Your Registration is Not Approved by Admin");
            logger.info("------------------------------------------");
        }

    }


    private void viewCourse(String studentId){

        try {

            logger.info("-------All Courses Available----------");

            RegistrationInterface registrationInterface = new RegistrationOperation();
            List<Course> courseList = registrationInterface.viewCourse();


            for (Course course : courseList) {
                String courseId = course.getCourseId();
                String courseName = course.getCourseName();
                int credit = course.getCredit();
                String professorEmpId = course.getProfessorEmpId();
                double fee = course.getFee();
                logger.info("CourseId : " + courseId + " , CourseName : " + courseName + " , credit : " + credit + " , ProfessorEmpId: " + professorEmpId + " , fee: " + fee);
            }

            logger.info("---------------------------------------");
        }
        catch (SQLException e){
            logger.error(e.getMessage());
        }
    }

    private void addCourse(String studentId){

        try {

            logger.info("-----You can Enter Add Course Window------");
            logger.info("Do you Want to view courses press 1 else 0");

            int choice = sc.nextInt();
            if (choice == 1) viewCourse(studentId);
            logger.info("Enter the CourseId you selected: ");

            String courseId = sc.next();

            RegistrationInterface registrationInterface = new RegistrationOperation();

            boolean success = registrationInterface.addCourse(courseId, studentId);

            if (success) {
                logger.info("Course Registration Successful");
            } else {
                logger.info("Course Registration fail");
            }
        }
        catch (CourseNotFoundException | SQLException e){
            logger.error(e.getMessage());
        }
    }

    private void viewRegisteredCourse(String studentId){

        try {

            RegistrationInterface registrationInterface = new RegistrationOperation();

            List<Course> courseList = registrationInterface.viewRegisterCourse(studentId);

            logger.info("---Your Registered Courses Are----");
            for (Course course : courseList) {
                String courseId = course.getCourseId();
                String courseName = course.getCourseName();
                int credit = course.getCredit();
                String professorEmpId = course.getProfessorEmpId();
                double fee = course.getFee();
                logger.info("CourseId : " + courseId + " , CourseName : " + courseName + " , credit : " + credit + " : ProfID : " + professorEmpId);
            }

            logger.info("----------------------------------");
        }
        catch(SQLException e){
            logger.error(e.getMessage());
        }

    }

    private void dropCourse(String studentId){

        try {

            logger.info("-----You can Enter Drop Course Window------");
            logger.info("To View all your Courses Press 1 else 0 : ");

            int choice = sc.nextInt();

            if (choice == 1) viewRegisteredCourse(studentId);

            logger.info("Enter The courseID of course to be Dropped:");

            String courseId = sc.next();

            RegistrationInterface registrationInterface = new RegistrationOperation();

            boolean success = registrationInterface.dropCourse(courseId, studentId);

            if (success) System.out.println("Course Drop Successful");
            else {
                logger.info("Course Drop fail");
            }

            logger.info("---------------------------------------------");
        }
        catch(CourseNotFoundException | SQLException e){
            logger.error(e.getMessage());
        }
    }


    private void viewGradeCard(String studentId){

        try {

            logger.info("--------View Your Grade Card----------");

            StudentInterface studentInterface = new StudentOperation();

            List<Grade> gradeList = studentInterface.getGrade(studentId);

            for (Grade grade : gradeList) {
                String courseId = grade.getCourseId();
                double mark = grade.getGrade();

                logger.info("courseId : " + courseId + " ---> " + mark);
            }

            logger.info("---------------------------------------");
        }
        catch (SQLException e){
            logger.error(e.getMessage());
        }
    }

}
