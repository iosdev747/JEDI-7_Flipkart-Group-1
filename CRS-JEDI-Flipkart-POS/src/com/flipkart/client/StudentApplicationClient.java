package com.flipkart.client;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.service.CourseInterface;
import com.flipkart.service.CourseOperation;
import com.flipkart.service.StudentInterface;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentApplicationClient {

    Scanner scanner;
    Student student;
    CourseInterface courseHandler;
    StudentInterface studentHandler;

    public StudentApplicationClient(Student student) {
        this.student = student;
        courseHandler = new CourseOperation();
    }

    void menu() {
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Student Menu: ");
            System.out.println("1. View Course Catalog");
            System.out.println("2. Course Registration");
            System.out.println("3. Drop from Course");
            System.out.println("4. View Registered Courses");
            System.out.println("5. View grade card");
            System.out.println("6. Make Payment");
            System.out.println("7. Logout");
            System.out.print("Enter your choice (1-7): ");
            int mmchoice = scanner.nextInt();
            switch (mmchoice) {
                case 1:
                    viewCourseCatalog();
                    break;
                case 2:
                    registerCourse();
                    break;
                case 3:
                    dropCourse();
                    break;
                case 4:
                    viewRegisteredCourse();
                    break;
                case 5:
                    viewGrades();
                    break;
                case 6:
                    payFee();
                    break;
                case 8:
                    System.out.println("Logging out....");
                    return;
                default:
                    System.out.println("Wrong choice entered. Select from (1-7)");
            }
        }
    }

    private void viewCourseCatalog() {
        ArrayList<Course> courses = courseHandler.getCourseCatalog();
        for (Course course : courses) {
            System.out.println(course.getCourseId() + " : " + course.getCourseName() + "(" + course.getCredits() + ")");
        }
    }

    private void registerCourse() {
        viewCourseCatalog();
        System.out.print("Enter CourseID: ");
        String courseID = scanner.next();
        boolean success = studentHandler.enrollCourse(courseID, student.getStudentId());
        System.out.println((success)? "Successfully registered." : "Failed to register.");
    }

    private void dropCourse() {
        viewCourseCatalog();
        System.out.print("Enter CourseID: ");
        String courseID = scanner.next();
        boolean success = studentHandler.dropCourse(courseID, student.getStudentId());
        System.out.println((success)? "Successfully registered." : "Failed to register.");
    }

    private void viewRegisteredCourse() {
        ArrayList<Course> courses = studentHandler.viewRegisteredCourse(student.getStudentId());
        for (Course course : courses) {
            System.out.println(course.getCourseId() + " : " + course.getCourseName() + "(" + course.getCredits() + ")");
        }
    }

    private void viewGrades() {
        viewCourseCatalog();
        System.out.print("Enter CourseID to view Grade: ");
        String courseID = scanner.next();
        Grade grade = studentHandler.getGrade(student.getStudentId(), courseID);
        System.out.println("Your grade is :" + grade.getGrade());
    }

    private void payFee() {
        System.out.println("Fee payed successfully");
    }

}
