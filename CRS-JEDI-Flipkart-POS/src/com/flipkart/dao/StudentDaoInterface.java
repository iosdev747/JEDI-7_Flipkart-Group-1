package com.flipkart.dao;

import java.util.*;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.exception.*;

import java.sql.SQLException;


public interface StudentDaoInterface {

    public boolean addStudent(Student student) throws StudentNotRegisteredException;

    public String getStudentId(int userId);
    //  can change return to string if studentId in Db is string

    public List<Grade> getGrade(String studentId) throws SQLException ;
    // here also change input to String if studentId is String in db

    public boolean isApproved(String studentId);   // --> this is not present in the database either left it or add to database
    // here also change input to String if studentId is String in db

    public boolean verifyStudent(int userId);
}
