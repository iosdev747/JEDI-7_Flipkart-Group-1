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

            System.out.println("----------Welcome To Admin Menu AdminID : " + adminId + "----------");
            System.out.println("1. View Course in Catalog");
            System.out.println("2. Add Course to catalog");
            System.out.println("3. Delete Course From catalog");
            System.out.println("4. Add Professor");
            System.out.println("5. Assign Course To Professor");
            System.out.println("6. Check All UnApproved");
            System.out.println("7. Approve Student");
            System.out.println("8. LogOut");
            System.out.println("---------------------------------------------");

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
                    System.out.println("Wrong Option selected");
                    break;
            }

        }

        System.out.println("You Are Logged Out");
    }

    private void listUnapprovedStudent(){
        System.out.println("-------All Unapproved Student list---------");

        AdminInterface adminInterface = new AdminOperation();

        List<Student> studentList = adminInterface.viewPendingAdmissions();

        for(Student student : studentList){
            String studentId = student.getStudentId();
            String name = student.getName();

            System.out.println("StudentID: "+studentId +" , Student Name: "+name);
        }

        System.out.println("-------------------------------------------");

    }


    private void approveStudent(){
        try {
            System.out.println("-------Approve a Student Registration---------");

            String studentId;

            System.out.println("Enter the studentId to Approve: ");
            studentId = sc.next();

            AdminInterface adminInterface = new AdminOperation();

            adminInterface.approveStudent(studentId);

            System.out.println("----------------------------------------------");
        }
        catch(StudentNotFoundForApprovalException e){
            logger.error(e.getMessage());
        }
    }


    private void viewCourse(){

        try {
            System.out.println("-------All Courses In Catalog---------");

            RegistrationInterface registrationInterface = new RegistrationOperation();
            List<Course> courseList = registrationInterface.viewCourse();


            for (Course course : courseList) {
                String courseId = course.getCourseId();
                String courseName = course.getCourseName();
                int credit = course.getCredit();
                String professorEmpId = course.getProfessorEmpId();
                double fee = course.getFee();
                System.out.println("CourseId : " + courseId + " , CourseName : " + courseName + " , credit : " + credit + " , ProfessorEmpId: " + professorEmpId + " , fee: " + fee);
            }

            System.out.println("---------------------------------------");
        }
        catch(SQLException e){
            logger.error(e.getMessage());
        }
    }

    private void addCourse(){

        try {
            System.out.println("-------Add A course to Catalog---------");

            System.out.println("Enter The Details of New Course");
            String courseId;
            String courseName;
            int credit;
            String professorEmpId;
            double fee;


            System.out.println("Enter the CourseID:");
            courseId = sc.next();
            System.out.println("Enter the CourseName:");
            courseName = sc.next();
            System.out.println("Enter the CourseCredit:");
            credit = sc.nextInt();
            System.out.println("Enter the CourseFee:");
            fee = sc.nextDouble();
            System.out.println("Enter the ProfessorId:");
            professorEmpId = sc.next();

            AdminInterface adminInterface = new AdminOperation();
            adminInterface.addCourse(courseId, courseName, credit, professorEmpId, fee);


            System.out.println("---------------------------------------");
        }
        catch(CourseFoundException e){
            logger.error(e.getMessage());
        }
    }

    private void deleteCourse(){

        try {

            System.out.println("-------Delete Course from Catalog---------");

            String courseId;
            System.out.println("Enter the CourseID to Delete:");
            courseId = sc.next();

            AdminInterface adminInterface = new AdminOperation();
            adminInterface.deleteCourse(courseId);

            System.out.println("------------------------------------------");
        }
        catch(CourseNotFoundException | CourseNotDeletedException e){
            logger.error(e.getMessage());
        }
    }


    private void addProfessor(){

        try {

            System.out.println("-------Add A Professor---------");

            System.out.println("Enter The details for the professor");

            int userId;
            String name;
            String password;
            String address;
            String department;
            String professorEmpId;

            System.out.println("Enter the UserId for Professor:");
            userId = sc.nextInt();

            System.out.println("Enter the Name for Professor:");
            name = sc.next();

            System.out.println("Enter the password for Professor:");
            password = sc.next();

            System.out.println("Enter the password for Address:");
            address = sc.next();

            System.out.println("Enter the Department for Professor:");
            department = sc.next();

            System.out.println("Enter the ProfessorId for Professor:");
            professorEmpId = sc.next();

            Professor professor = new Professor(userId, name, password, address, department, professorEmpId);

            AdminInterface adminInterface = new AdminOperation();

            adminInterface.addProfessor(professor);

            System.out.println("---------------------------------");
        }
        catch(ProfessorNotAddedException | UserIdAlreadyInUseException e){
            logger.error(e.getMessage());
        }
    }

    private void assignCourseToProfessor(){

        try {
            System.out.println("-------Assign Course to Professor---------");

            String courseId;
            String professorId;

            System.out.println("Enter the courseId for Professor:");
            courseId = sc.next();

            System.out.println("Enter the ProfessorId:");
            professorId = sc.next();

            AdminInterface adminInterface = new AdminOperation();

            adminInterface.assignCourse(courseId, professorId);


            System.out.println("------------------------------------------");
        }
        catch(CourseNotFoundException | UserNotFoundException e){
            logger.error(e.getMessage());
        }
    }


}
