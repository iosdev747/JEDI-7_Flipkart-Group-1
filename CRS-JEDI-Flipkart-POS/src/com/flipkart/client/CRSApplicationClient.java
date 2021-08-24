package com.flipkart.client;

import java.util.Scanner;

public class CRSApplicationClient {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to CRS");
        System.out.println("Enter your Role");
        System.out.println("Press 1 for Student");
        System.out.println("Press 2 for Professor");
        System.out.println("Press 3 for Admin");
        System.out.println("Press 4 to Exit");

        int choice = in.nextInt();
        while (choice != 4) {
            System.out.println("Enter your Username");
            System.out.println("Enter your Password");
        }
        String userName = in.nextLine();
        String password = in.nextLine();
        switch (choice) {
            case 1:
                verifyStudentCredentials(userName, password);
                break;
            case 2:
                verifyProfessorCredentials(userName, password);
                break;
            case 3:
                verifyAdminCredentials(userName, password);
                break;
            case 4:
                exit();
                break;
            default:
                System.out.println("Invalid Choice");
                break;

        }

    }

    private static void verifyAdminCredentials(String userName, String password) {

    }

    private static void verifyProfessorCredentials(String userName, String password) {

    }

    private static void verifyStudentCredentials(String userName, String password) {

    }

    private static void exit() {
    }

}
