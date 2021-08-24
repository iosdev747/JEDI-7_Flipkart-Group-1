package com.flipkart.client;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.bean.Grade;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.bean.Professor;
import com.flipkart.service.CourseInterface;
import com.flipkart.service.CourseOperation;

import java.util.Scanner;
import java.util.ArrayList;

public class ProfessorApplicationClient {
    Scanner scanner;
    Professor prof;
    ProfessorInterface profHandler;
    public ProfessorApplicationClient(Professor prof){
        this.prof = prof;
    }
    void menu(){
        while(true){
            generateMenu();
            int choice = scanner.nextInt();
            switch(choice){
                case 1: viewCourses();
                        break;
                case 2: viewEnrolledStudents();
                        break;
                case 3: addGrade();
                        break;
                case 4: System.out.println("you have successfully logged out");
                        return;
                default: System.out.println("That's an  invalid option")
            }
        }
    }
    void viewCourses(){
        Course[] courses = profHandler.viewCourse(prof.getEmpId());
        for (Course course : courses) {
            System.out.println(course.getCourseId() + " : " + course.getCourseName() + "(" + course.getCredits() + ")");
        }
    }
    void viewEnrolledStudents(){
        System.out.println("Enter the courseID to view enrolled students");
        String id = scanner.next();
        Student[] students = profHandler.viewEnrolledStudents(id,prof.getEmpId());
        for(Student s: students){
            System.out.println(s.getStudentId() + "   " + s.getStudentName() + "    " + s.getDepartment())
        }
    }
    void addGrade(){
        System.out.print("Enter CourseCode: ");
        String courseID = scanner.next();
        System.out.println("Enter student ID: ");
        String studentID = scanner.next();
        boolean status = profHandler.addGrade(studentID,courseID,prof.getEmpId());
        System.out.println((status)? "Successfully added grade" : "Failed to add grade");
    }
    void generateMenu(){
        System.out.println("#########################################################################################");
        System.out.println("Welcome to professor homepage");
        System.out.println("1 --> view your courses");
        System.out.println("2 --> view enrolled students");
        System.out.println("3 --> add grade");
        System.out.println("4 --> logout");
        System.out.println("#########################################################################################");
        System.out.println("Please select your choice");
    }
}
