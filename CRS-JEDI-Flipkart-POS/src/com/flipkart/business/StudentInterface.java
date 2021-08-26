package com.flipkart.business;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;

import java.util.*;

public interface StudentInterface {

    public boolean register(int userID, String name, String password, String address, int studentId, int batch, String branch, boolean isApproved);

    public int getStudentId(int userId);
    //  can change return to string if studentId in Db is string

    public List<Grade> getGrade(int studentId);
    // here also change input to String if studentId is String in db

    //public boolean isApproved(int studentId);   // --> this is not present in the database either left it or add to database
    // here also change input to String if studentId is String in db

    public boolean verifyStudent(int userId);

}
