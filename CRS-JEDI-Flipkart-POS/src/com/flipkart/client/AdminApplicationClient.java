package com.flipkart.client;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.service.CourseOperation;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.CourseInterface;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminApplicationClient {
    Admin admin;
    Scanner scanner;
    AdminInterface adminHandler;
    CourseInterface courseHandler;

    public AdminApplicationClient(Admin admin){
        this.admin = admin;
    }
    void menu(){
        generateMenu();
        int choice = scanner.nextInt();
        switch(choice) {
            case 1:
                viewCourses();
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
                verifyStudentProfile();
                break;
            case 6:
                viewProfessorList();
                break;
            case 7:
                System.out.println("Logging out....");
                return;
            default:
                System.out.println("Wrong choice entered. Select from (1-7)");
        }
    }

    void viewProfessorList() {
        ArrayList<Course> courses = courseHandler.getCourseCatalog();
        for(Course c : courses){
            System.out.println(c.getcourseName() +" "+c.getProfessor().getName());
        }
    }

    void verifyStudentProfile() {
        System.out.print("Enter StudentID: ");
        String studentID = scanner.next();
        boolean status = adminHandler.verifyStudentProfile(studentID);
        System.out.println((status)? "verified student" : "unable to verify");
    }

    void addProfessor() {
        Professor p = new Professor();
        boolean status = adminHandler.addProfessor(p);
        System.out.println((status)? "Successfully added professor" : "Failed to add");
    }

    void viewCourses() {
        ArrayList<Course> courses = courseHandler.getCourseCatalog();
        for (Course course : courses) {
            System.out.println(course.getCourseId() + " : " + course.getCourseName() + "(" + course.getCredits() + ")");
        }
    }

    void addCourse(){
        Course cr = new Course("CS50","computer fundamentals", new Professor(), 50);
        boolean status = adminHandler.addCourse(cr);
        System.out.println((status)? "Successfully added course" : "Failed to add course");
    }
    void deleteCourse(){
        System.out.print("Enter CourseCode: ");
        String courseID = scanner.next();
        boolean status = adminHandler.deleteCourse(courseID);
        System.out.println((status)? "Successfully deleted" : "Failed to delete");
    }
    void generateMenu(){
        System.out.println("#########################################################################################");
        System.out.println("Welcome to Admin homepage");
        System.out.println("1 --> view courses");
        System.out.println("2 --> add course");
        System.out.println("3 --> delete course");
        System.out.println("4 --> add professor");
        System.out.print(("5 --> verify student profile");
        System.out.println("6 --> view professor list");
        System.out.println("7 --> logout");
        System.out.println("#########################################################################################");
        System.out.println("Please select your choice");
    }
}

