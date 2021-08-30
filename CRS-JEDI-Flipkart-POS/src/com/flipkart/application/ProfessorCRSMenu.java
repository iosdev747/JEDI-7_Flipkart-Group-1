package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.business.ProfessorInterface;
import com.flipkart.business.ProfessorOperation;
import com.flipkart.exception.GradeNotAddedException;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class ProfessorCRSMenu {

    private static final Logger logger = Logger.getLogger(ProfessorCRSMenu.class);

    Scanner sc = new Scanner(System.in);

    public void createMenu(String professorId) {

        boolean logginFlag = true;

        while (logginFlag) {

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
                    logger.info("Wrong Input Given");
                    break;
            }

        }

        System.out.println("You are Logged Out");

    }

    private void viewCourse(String profId) { // profId is professorEmpId

        System.out.println("-------All Courses Professor have----------");

        ProfessorInterface professorInterface = new ProfessorOperation();

        List<Course> courseList = professorInterface.getCoursesByProfessor(profId);

        System.out.printf("%10s \t %10s \t %10s", "CoureseID", "Credits", "CourseName");
        System.out.printf("\n");
        for (Course course : courseList) {
            String courseId = course.getCourseId();
            String courseName = course.getCourseName();
            int credit = course.getCredit();

            System.out.printf("%10s \t %10s \t %10s \t %10s", courseId, credit, courseName);
            System.out.printf("\n");
        }
        System.out.println("--------------------------------------------");


    }

    private void viewEnrolledStudent(String profId) {

        try {

            System.out.println("-------All Student Enroll With Professor----------");

            ProfessorInterface professorInterface = new ProfessorOperation();

            List<EnrolledStudent> enrolList = professorInterface.getEnrolledStudent(profId);

            System.out.printf("%10s \t %10s", "CoureseID", "Student ID");
            System.out.printf("\n");
            for (EnrolledStudent enrol : enrolList) {
                String courseId = enrol.getCourseId();
                String studentId = enrol.getStudentId();
                System.out.printf("%10s \t %10s", courseId, studentId);
                System.out.printf("\n");
            }

            System.out.println("----------------------------------------------------");
        } catch (SQLException e) {
            logger.error("SQL Exception: " + e.getMessage());
        }
    }

    private void addGrade() {

        try {
            System.out.println("-------- Add the Grade to the Student -----------");

            String studentId;
            String courseId;
            double mark;

            System.out.println("Enter the studentId: ");
            studentId = sc.next();
            System.out.println("Enter the courseId: ");
            courseId = sc.next();
            System.out.println("Enter the Grade To assign: ");
            mark = sc.nextDouble();

            ProfessorInterface professorInterface = new ProfessorOperation();

            boolean success = professorInterface.addGrade(studentId, courseId, mark);

            if (success) System.out.println("Grade Added Succesfully");
            else System.out.println("Grade Added Failed");

            System.out.println("-------- ---------------------------- -----------");
        } catch (GradeNotAddedException e) {
            logger.error(e.getMessage());
        }
    }


}
