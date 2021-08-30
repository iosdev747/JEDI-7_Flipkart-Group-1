package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.business.RegistrationInterface;
import com.flipkart.business.RegistrationOperation;
import com.flipkart.business.StudentInterface;
import com.flipkart.business.StudentOperation;
import com.flipkart.exception.CourseNotFoundException;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StudentCRSMenu {

    private static final Logger logger = Logger.getLogger(StudentCRSMenu.class);
    Scanner sc = new Scanner(System.in);

    public void createMenu(String studentId) {
        boolean logginFlag = true;

        while (logginFlag) {

            System.out.println("----------Welcome To Student Menu StudentID : " + studentId + "----------");
            System.out.println("1. Add Course");
            System.out.println("2. Drop Course");
            System.out.println("3. View Course");
            System.out.println("4. View Registered Course");
            System.out.println("5. View Grade Card");
            System.out.println("6. Check If Approved");
            System.out.println("7. Make Payment");
            System.out.println("8. LogOut");
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

        System.out.println("You Are Logged Out");
    }

    private void makePayment(String studentId) {

        StudentInterface studentInterface = new StudentOperation();

        if (!studentInterface.isApproved(studentId)) {
            System.out.println("You are Not Approved by Admin");
            logger.info("You are Not Approved by Admin");
            return;
        }

        try {

            System.out.println("----------Make Payment ------------");

            RegistrationInterface registrationInterface = new RegistrationOperation();

            double amount = registrationInterface.calculate(studentId);
            //int numOfCourse = registrationInterface.numOfRegisteredCourses(studentId);

            System.out.println("Your total amount is : " + amount);

            System.out.println("------------------------------------");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    private void checkIfApproved(String studentId) {

        StudentInterface studentInterface = new StudentOperation();

        boolean check = studentInterface.isApproved(studentId);

        if (check) {
            System.out.println("--------------------------------------");
            System.out.println("Your Registration is Approved by Admin");
            System.out.println("--------------------------------------");
        } else {
            System.out.println("------------------------------------------");
            System.out.println("Your Registration is Not Approved by Admin");
            System.out.println("------------------------------------------");
        }

    }


    private void viewCourse(String studentId) {

        try {

            System.out.println("-------All Courses Available----------");

            RegistrationInterface registrationInterface = new RegistrationOperation();
            List<Course> courseList = registrationInterface.viewCourse();

            System.out.printf("%10s \t \t %10s \t \t %10s \t %10s \t %10s", "CoureseID", "Credits", "ProfessiorID", "Fee", "CourseName");
            System.out.printf("\n");

            for (Course course : courseList) {
                String courseId = course.getCourseId();
                String courseName = course.getCourseName();
                int credit = course.getCredit();
                String professorEmpId = course.getProfessorEmpId();
                double fee = course.getFee();
                System.out.printf("%10s \t \t %10s \t \t %10s \t %10s \t %10s", courseId, "" + credit, professorEmpId, fee, courseName);
                System.out.printf("\n");
            }

            System.out.println("---------------------------------------");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    private void addCourse(String studentId) {

        StudentInterface studentInterface = new StudentOperation();

        if (!studentInterface.isApproved(studentId)) {
            System.out.println("You are Not Approved by Admin");
            logger.info("You are Not Approved by Admin");
            return;
        }


        try {

            System.out.println("-----You can Enter Add Course Window------");
            System.out.println("Do you Want to view courses press 1 else 0");

            int choice = sc.nextInt();
            if (choice == 1) viewCourse(studentId);
            System.out.println("Enter the CourseId you selected: ");

            String courseId = sc.next();

            RegistrationInterface registrationInterface = new RegistrationOperation();

            boolean alreadyRegistered = registrationInterface.isRegistered(courseId, studentId);

            if (alreadyRegistered) {
                System.out.println("IsAlready registered For course");
                return;
            }

            boolean success = registrationInterface.addCourse(courseId, studentId);

            if (success) {
                System.out.println("Course Registration Successful");
            } else {
                System.out.println("Course Registration fail");
            }
        } catch (CourseNotFoundException | SQLException e) {
            logger.error(e.getMessage());
        }
    }

    private void viewRegisteredCourse(String studentId) {


        StudentInterface studentInterface = new StudentOperation();

        if (!studentInterface.isApproved(studentId)) {
            System.out.println("You are Not Approved by Admin");
            logger.info("You are Not Approved by Admin");
            return;
        }


        try {

            RegistrationInterface registrationInterface = new RegistrationOperation();

            List<Course> courseList = registrationInterface.viewRegisterCourse(studentId);

            System.out.println("---Your Registered Courses Are----");
            if (courseList.size() == 0) {
                System.out.println("No Course SelectedBy you");
            } else {
                System.out.printf("%10s \t %10s \t %10s \t %10s \t %10s", "CoureseID", "Credits", "ProfessiorID", "Fee", "CourseName");
                System.out.printf("\n");
                for (Course course : courseList) {
                    String courseId = course.getCourseId();
                    String courseName = course.getCourseName();
                    int credit = course.getCredit();
                    String professorEmpId = course.getProfessorEmpId();
                    double fee = course.getFee();
                    System.out.printf("%10s \t %10s \t %10s \t %10s \t %10s", courseId, credit, professorEmpId, fee, courseName);
                    System.out.printf("\n");
                }
            }

            System.out.println("----------------------------------");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

    }

    private void dropCourse(String studentId) {

        StudentInterface studentInterface = new StudentOperation();

        if (!studentInterface.isApproved(studentId)) {
            System.out.println("You are Not Approved by Admin");
            logger.info("You are Not Approved by Admin");
            return;
        }

        try {

            System.out.println("-----You can Enter Drop Course Window------");
            System.out.println("To View all your Courses Press 1 else 0 : ");

            int choice = sc.nextInt();

            if (choice == 1) viewRegisteredCourse(studentId);

            System.out.println("Enter The courseID of course to be Dropped:");

            String courseId = sc.next();

            RegistrationInterface registrationInterface = new RegistrationOperation();

            boolean success = registrationInterface.dropCourse(courseId, studentId);

            if (success) System.out.println("Course Drop Successful");
            else {
                System.out.println("Course Drop fail");
            }

            System.out.println("---------------------------------------------");
        } catch (CourseNotFoundException | SQLException e) {
            logger.error(e.getMessage());
        }
    }


    private void viewGradeCard(String studentId) {

        StudentInterface studentInterface = new StudentOperation();

        if (!studentInterface.isApproved(studentId)) {
            System.out.println("You are Not Approved by Admin");
            logger.info("You are Not Approved by Admin");
            return;
        }

        try {

            System.out.println("--------View Your Grade Card----------");

            studentInterface = new StudentOperation();

            List<Grade> gradeList = studentInterface.getGrade(studentId);
            System.out.printf("%10s \t %10s", "CourseID", "Grade In Course");
            System.out.printf("\n");
            for (Grade grade : gradeList) {
                String courseId = grade.getCourseId();
                double mark = grade.getGrade();

                System.out.printf("%10s \t %10s", courseId, mark);
                System.out.printf("\n");
            }

            System.out.println("---------------------------------------");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

}
