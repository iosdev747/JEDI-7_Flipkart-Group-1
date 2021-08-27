
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

        System.out.println("-----------Welcome to Course Management System--------------");
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Professor");
        System.out.println("3. Login as Admin");
        System.out.println("4. Student SignUp");
        System.out.println("5. Update Password");
        System.out.println("6. Exit");
        System.out.println("Enter user input");
    }

    public static void loginStudent(){
        try {
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

            if (userInterface.verifyCredentials(userId, password) && studentInterface.verifyStudent(userId)) {

                // studentCRSMenu
                String studentId = studentInterface.getStudentId(userId);
                StudentCRSMenu studentCRSMenu = new StudentCRSMenu();
                studentCRSMenu.createMenu(studentId);

            } else {
                System.out.println("Wrong Credentials For Student check again");
            }

            System.out.println("********* ************ ***********");
        }
        catch(UserNotFoundException e){
            logger.error(e.getMessage());
        }

    }

    public  static void loginProfessor(){

        try {

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

            if (userInterface.verifyCredentials(userId, password) && professorInterface.verifyProfessor(userId)) {

                // studentCRSMenu
                String professorId = professorInterface.getProfessorId(userId);
                ProfessorCRSMenu professorCRSMenu = new ProfessorCRSMenu();
                professorCRSMenu.createMenu(professorId);

            } else {
                System.out.println("Wrong Credentials For Professor check again");
            }


            System.out.println("********* *************** ***********");
        }
        catch(UserNotFoundException e){
            logger.error(e.getMessage());
        }
    }

    public static void loginAdmin(){

        try {
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

            if (userInterface.verifyCredentials(userId, password) && adminInterface.verifyAdmin(userId)) {

                // studentCRSMenu
                String empId = adminInterface.getAdminId(userId);
                AdminCRSMenu adminCRSMenu = new AdminCRSMenu();
                adminCRSMenu.createMenu(empId);

            } else {
                System.out.println("Wrong Credentials For Admin check again");
            }


            System.out.println("********* *************** ***********");
        }
        catch(UserNotFoundException e){
            logger.error(e.getMessage());
        }
    }

    public static void registerStudent(){

        try {
            System.out.println("********* Student Register Window ***********");

            Scanner sc = new Scanner(System.in);
            int userId;
            String name;
            String password;
            String address;
            String studentId;
            int batch;
            String branch;

            System.out.println("Enter your the userID: ");
            userId = sc.nextInt();

            System.out.println("Enter your the name: ");
            name = sc.next();

            System.out.println("Enter your the password: ");
            password = sc.next();

            System.out.println("Enter your the address: ");
            address = sc.next();

            System.out.println("Enter your the studentID: ");
            studentId = sc.next();

            System.out.println("Enter your the batch: ");
            batch = sc.nextInt();

            System.out.println("Enter your the branch: ");
            branch = sc.next();

            StudentInterface studentInterface = new StudentOperation();

            boolean success = studentInterface.register(userId, name, password, address, studentId, batch, branch, false);

            if (success) {
                System.out.println("You have successfully Login, Wait for Admin Approval!");
            } else {
                System.out.println("Student Registration failed");
            }


            System.out.println("********* *********************** ***********");
        }
        catch(StudentNotRegisteredException e){
            logger.error(e.getMessage());
        }
    }


    public static void updatePassword(){

        try {
            System.out.println("********* Change Password ***********");

            Scanner sc = new Scanner(System.in);

            int userId;
            String password;

            System.out.println("Enter the userID: ");
            userId = sc.nextInt();
            System.out.println("Enter the Current Password: ");
            password = sc.next();

            UserInterface userInterface = new UserOperation();

            if (userInterface.verifyCredentials(userId, password)) {

                logger.info("Credentials Verified Now password can be changed");
                // studentCRSMenu
                String newPassword;
                System.out.println("Enter New Password");
                newPassword = sc.next();
                boolean success = userInterface.updatePassword(userId,newPassword);

                if(success){
                    System.out.println("Password Change SuccessFull");
                }
                else{
                    System.out.println("Password Change UnSuccessFull");
                }


            } else {
                System.out.println("Wrong Credentials");
            }


            System.out.println("********* *************** ***********");
        }
        catch(UserNotFoundException e){
            logger.error(e.getMessage());
        }

    }

    public static void main(String[] args){

        boolean inside = true;

        CRSApplication crsApplication = new CRSApplication();
        Scanner sc = new Scanner(System.in);

        int userInput;

        //login page
        while(inside) {
            createMainMenu();
            userInput = sc.nextInt();
            switch (userInput) {
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
                case 5:
                    //update password
                    crsApplication.updatePassword();
                    break;
                default:
                    inside = false;
                    //System.out.println("Invalid Input");
                    break;
            }
        }
        sc.close();
    }


}
