package com.flipkart.business;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.exception.*;

import java.util.*;
import java.sql.SQLException;

public interface StudentInterface {

    public boolean register(int userID, String name, String password, String address, String studentId, int batch, String branch, boolean isApproved) throws StudentNotRegisteredException;

    public String getStudentId(int userId);
    //  can change return to string if studentId in Db is string

    public List<Grade> getGrade(String studentId) throws SQLException;
    // here also change input to String if studentId is String in db

    public boolean isApproved(String studentId);   // --> this is not present in the database either left it or add to database

    // here also change input to String if studentId is String in db

    public boolean verifyStudent(int userId);

}
