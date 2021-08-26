
package com.flipkart.application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.flipkart.business.StudentInterface;
import com.flipkart.business.StudentOperation;
import com.flipkart.business.UserInterface;
import com.flipkart.business.UserOperation;
import com.flipkart.business.ProfessorInterface;
import com.flipkart.business.ProfessorOperation;
import com.flipkart.business.AdminInterface;
import com.flipkart.business.AdminOperation;


public class CRSApplication {



    public static void createMainMenu(){

        System.out.println("-----------Welcome to Course Management System--------------");
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Professor");
        System.out.println("3. Login as Admin");
        System.out.println("4. Student SignUp");
        System.out.println("Enter user input");
    }

    public static void loginStudent(){

        System.out.println("********* Student Login ***********");

        Scanner sc = new Scanner(System.in);

        int userId;
        String password;

        System.out.println("Enter the userID: ");
        userId = sc.nextInt();
        System.out.println("Enter the password: ");
        password = sc.next();

        StudentInterface studentInterface = new StudentOperation();
        UserInterface userInterface = new UserOperation();

        if(userInterface.verifyCredentials(userId,password) && studentInterface.verifyStudent(userId)){

            // studentCRSMenu
            int studentId = studentInterface.getStudentId(userId);
            StudentCRSMenu studentCRSMenu = new StudentCRSMenu();
            studentCRSMenu.createMenu(studentId);

        }
        else{
            System.out.println("Wrong Credentials For Student check again");
        }

        System.out.println("********* ************ ***********");


    }

    public  static void loginProfessor(){
        System.out.println("********* Professor Login ***********");

        Scanner sc = new Scanner(System.in);

        int userId;
        String password;

        System.out.println("Enter the userID: ");
        userId = sc.nextInt();
        System.out.println("Enter the password: ");
        password = sc.next();

        ProfessorInterface professorInterface = new ProfessorOperation();
        UserInterface userInterface = new UserOperation();

        if(userInterface.verifyCredentials(userId,password) && professorInterface.verifyProfessor(userId)){

            // studentCRSMenu
            int professorId = professorInterface.getProfessorId(userId);
            ProfessorCRSMenu professorCRSMenu = new ProfessorCRSMenu();
            professorCRSMenu.createMenu(professorId);

        }
        else{
            System.out.println("Wrong Credentials For Student check again");
        }


        System.out.println("********* *************** ***********");
    }

    public static void loginAdmin(){

        System.out.println("********* Admin Login ***********");

        Scanner sc = new Scanner(System.in);

        int userId;
        String password;

        System.out.println("Enter the userID: ");
        userId = sc.nextInt();
        System.out.println("Enter the password: ");
        password = sc.next();

        AdminInterface adminInterface = new AdminOperation();
        UserInterface userInterface = new UserOperation();

        if(userInterface.verifyCredentials(userId,password) && adminInterface.verifyProfessor(userId)){

            // studentCRSMenu
            int empId = adminInterface.getAdminId(userId);
            AdminCRSMenu adminCRSMenu = new AdminCRSMenu();
            adminCRSMenu.createMenu(empId);

        }
        else{
            System.out.println("Wrong Credentials For Student check again");
        }


        System.out.println("********* *************** ***********");

    }




    public static void main(String[] args){

        CRSApplication crsApplication = new CRSApplication();
        Scanner sc = new Scanner(System.in);

        int userInput;
        //login page
        createMainMenu();
        userInput = sc.nextInt();

        switch(userInput){
            case 1:
                // login for student
                crsApplication.loginStudent();
                break;

            case 2:
                // login as Professor
                crsApplication.loginProfessor();
                break;
            case 3:
                // login as Admin
                crsApplication.loginAdmin();
                break;
            case 4:
                // register Student
                //crsApplication.registerStudent();
                break;
            default:
                //System.out.println("Invalid Input");
                break;
        }

        sc.close();
    }
}
