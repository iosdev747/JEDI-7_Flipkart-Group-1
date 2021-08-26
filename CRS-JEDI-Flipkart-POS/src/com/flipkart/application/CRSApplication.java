
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
import com.flipkart.exception.*;

import org.apache.log4j.Logger;

//import org.apache.log4j.Logger;

public class CRSApplication {

    private static Logger logger = Logger.getLogger(CRSApplication.class);

    public static void createMainMenu(){

        logger.info("-----------Welcome to Course Management System--------------");
        logger.info("1. Login as Student");
        logger.info("2. Login as Professor");
        logger.info("3. Login as Admin");
        logger.info("4. Student SignUp");
        logger.info("Enter user input");
    }

    public static void loginStudent(){
        try {
            logger.info("********* Student Login ***********");

            Scanner sc = new Scanner(System.in);

            int userId;
            String password;

            logger.info("Enter the userID: ");
            userId = sc.nextInt();
            logger.info("Enter the password: ");
            password = sc.next();

            StudentInterface studentInterface = new StudentOperation();
            UserInterface userInterface = new UserOperation();

            if (userInterface.verifyCredentials(userId, password) && studentInterface.verifyStudent(userId)) {

                // studentCRSMenu
                String studentId = studentInterface.getStudentId(userId);
                StudentCRSMenu studentCRSMenu = new StudentCRSMenu();
                studentCRSMenu.createMenu(studentId);

            } else {
                logger.error("Wrong Credentials For Student check again");
            }

            logger.info("********* ************ ***********");
        }
        catch(UserNotFoundException e){
            logger.error(e.getMessage());
        }

    }

    public  static void loginProfessor(){

        try {

            logger.info("********* Professor Login ***********");

            Scanner sc = new Scanner(System.in);

            int userId;
            String password;

            logger.info("Enter the userID: ");
            userId = sc.nextInt();
            logger.info("Enter the password: ");
            password = sc.next();

            ProfessorInterface professorInterface = new ProfessorOperation();
            UserInterface userInterface = new UserOperation();

            if (userInterface.verifyCredentials(userId, password) && professorInterface.verifyProfessor(userId)) {

                // studentCRSMenu
                String professorId = professorInterface.getProfessorId(userId);
                ProfessorCRSMenu professorCRSMenu = new ProfessorCRSMenu();
                professorCRSMenu.createMenu(professorId);

            } else {
                logger.error("Wrong Credentials For Professor check again");
            }


            logger.info("********* *************** ***********");
        }
        catch(UserNotFoundException e){
            logger.error(e.getMessage());
        }
    }

    public static void loginAdmin(){

        try {
            logger.info("********* Admin Login ***********");

            Scanner sc = new Scanner(System.in);

            int userId;
            String password;

            logger.info("Enter the userID: ");
            userId = sc.nextInt();
            logger.info("Enter the password: ");
            password = sc.next();

            AdminInterface adminInterface = new AdminOperation();
            UserInterface userInterface = new UserOperation();

            if (userInterface.verifyCredentials(userId, password) && adminInterface.verifyProfessor(userId)) {

                // studentCRSMenu
                String empId = adminInterface.getAdminId(userId);
                AdminCRSMenu adminCRSMenu = new AdminCRSMenu();
                adminCRSMenu.createMenu(empId);

            } else {
                logger.error("Wrong Credentials For Admin check again");
            }


            logger.info("********* *************** ***********");
        }
        catch(UserNotFoundException e){
            logger.error(e.getMessage());
        }
    }

    public static void registerStudent(){

        try {
            logger.info("********* Student Register Window ***********");

            Scanner sc = new Scanner(System.in);
            int userId;
            String name;
            String password;
            String address;
            String studentId;
            int batch;
            String branch;

            logger.info("Enter your the userID: ");
            userId = sc.nextInt();

            logger.info("Enter your the name: ");
            name = sc.next();

            logger.info("Enter your the password: ");
            password = sc.next();

            logger.info("Enter your the address: ");
            address = sc.next();

            logger.info("Enter your the studentID: ");
            studentId = sc.next();

            logger.info("Enter your the batch: ");
            batch = sc.nextInt();

            logger.info("Enter your the branch: ");
            branch = sc.next();

            StudentInterface studentInterface = new StudentOperation();

            boolean success = studentInterface.register(userId, name, password, address, studentId, batch, branch, false);

            if (success) {
                logger.info("You have successfully Login, Wait for Admin Approval!");
            } else {
                logger.info("Student Registration failed");
            }


            logger.info("********* *********************** ***********");
        }
        catch(StudentNotRegisteredException e){
            logger.error(e.getMessage());
        }
    }


    public static void main(String[] args){
        System.out.println("yes");
        logger.debug("Hi");
        logger.info("Hi info");

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
                crsApplication.registerStudent();
                break;
            default:
                //System.out.println("Invalid Input");
                break;
        }

        sc.close();
    }


}
