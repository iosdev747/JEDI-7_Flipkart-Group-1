package com.flipkart.application;

import java.util.Scanner;
import java.util.*;
import java.sql.SQLException;

import com.flipkart.bean.*;
import com.flipkart.business.*;
import com.flipkart.exception.*;

import org.apache.log4j.Logger;


public class AdminCRSMenu {

    Scanner sc = new Scanner(System.in);

    private static Logger logger = Logger.getLogger(AdminCRSMenu.class);

    public void createMenu(String adminId){

        boolean logginFlag = true;

        while(logginFlag) {

            logger.info("----------Welcome To Admin Menu AdminID : " + adminId + "----------");
            logger.info("1. View Course in Catalog");
            logger.info("2. Add Course to catalog");
            logger.info("3. Delete Course From catalog");
            logger.info("4. Add Professor");
            logger.info("5. Assign Course To Professor");
            logger.info("6. Check All UnApproved");
            logger.info("7. Approve Student");
            logger.info("8. LogOut");
            logger.info("---------------------------------------------");

            int choice = sc.nextInt();

            // It will be given after only 3 is
            switch (choice) {
                case 1:
                    viewCourse();
                    break;
                case 2:
                    addCourse();
                    break;
                case 3:
                    deleteCourse();
                    break;
                case 4:
                    addProfessor();
                    break;
                case 5:
                    assignCourseToProfessor();
                    break;
                case 6:
                    listUnapprovedStudent();
                    break;
                case 7:
                    approveStudent();
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

    private void listUnapprovedStudent(){
        logger.info("-------All Unapproved Student list---------");

        AdminInterface adminInterface = new AdminOperation();

        List<Student> studentList = adminInterface.viewPendingAdmissions();

        for(Student student : studentList){
            String studentId = student.getStudentId();
            String name = student.getName();

            logger.info("StudentID: "+studentId +" , Student Name: "+name);
        }

        logger.info("-------------------------------------------");

    }


    private void approveStudent(){
        try {
            logger.info("-------Approve a Student Registration---------");

            String studentId;

            logger.info("Enter the studentId to Approve: ");
            studentId = sc.next();

            AdminInterface adminInterface = new AdminOperation();

            adminInterface.approveStudent(studentId);

            logger.info("----------------------------------------------");
        }
        catch(StudentNotFoundForApprovalException e){
            logger.error(e.getMessage());
        }
    }


    private void viewCourse(){

        try {
            logger.info("-------All Courses In Catalog---------");

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
        catch(SQLException e){
            logger.error(e.getMessage());
        }
    }

    private void addCourse(){

        try {
            logger.info("-------Add A course to Catalog---------");

            logger.info("Enter The Details of New Course");
            String courseId;
            String courseName;
            int credit;
            String professorEmpId;
            double fee;


            logger.info("Enter the CourseID:");
            courseId = sc.next();
            logger.info("Enter the CourseName:");
            courseName = sc.next();
            logger.info("Enter the CourseCredit:");
            credit = sc.nextInt();
            logger.info("Enter the CourseFee:");
            fee = sc.nextDouble();
            logger.info("Enter the ProfessorId:");
            professorEmpId = sc.next();

            AdminInterface adminInterface = new AdminOperation();
            adminInterface.addCourse(courseId, courseName, credit, professorEmpId, fee);


            logger.info("---------------------------------------");
        }
        catch(CourseFoundException e){
            logger.error(e.getMessage());
        }
    }

    private void deleteCourse(){

        try {

            logger.info("-------Delete Course from Catalog---------");

            String courseId;
            logger.info("Enter the CourseID to Delete:");
            courseId = sc.next();

            AdminInterface adminInterface = new AdminOperation();
            adminInterface.deleteCourse(courseId);

            logger.info("------------------------------------------");
        }
        catch(CourseNotFoundException | CourseNotDeletedException e){
            logger.error(e.getMessage());
        }
    }


    private void addProfessor(){

        try {

            logger.info("-------Add A Professor---------");

            logger.info("Enter The details for the professor");

            int userId;
            String name;
            String password;
            String address;
            String department;
            String professorEmpId;

            logger.info("Enter the UserId for Professor:");
            userId = sc.nextInt();

            logger.info("Enter the Name for Professor:");
            name = sc.next();

            logger.info("Enter the password for Professor:");
            password = sc.next();

            logger.info("Enter the password for Address:");
            address = sc.next();

            logger.info("Enter the Department for Professor:");
            department = sc.next();

            logger.info("Enter the ProfessorId for Professor:");
            professorEmpId = sc.next();

            Professor professor = new Professor(userId, name, password, address, department, professorEmpId);

            AdminInterface adminInterface = new AdminOperation();

            adminInterface.addProfessor(professor);

            logger.info("---------------------------------");
        }
        catch(ProfessorNotAddedException | UserIdAlreadyInUseException e){
            logger.error(e.getMessage());
        }
    }

    private void assignCourseToProfessor(){

        try {
            logger.info("-------Assign Course to Professor---------");

            String courseId;
            String professorId;

            logger.info("Enter the courseId for Professor:");
            courseId = sc.next();

            logger.info("Enter the ProfessorId:");
            professorId = sc.next();

            AdminInterface adminInterface = new AdminOperation();

            adminInterface.assignCourse(courseId, professorId);


            logger.info("------------------------------------------");
        }
        catch(CourseNotFoundException | UserNotFoundException e){
            logger.error(e.getMessage());
        }
    }


}
