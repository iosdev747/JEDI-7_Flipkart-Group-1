package com.flipkart.dao;

import java.sql.*;
import java.util.*;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;


public interface StudentDaoInterface {

    public boolean addStudent(Student student);

    public int getStudentId(int userId);
    //  can change return to string if studentId in Db is string

    public List<Grade> getGrade(int studentId);
    // here also change input to String if studentId is String in db

    //public boolean isApproved(int studentId);   // --> this is not present in the database either left it or add to database
    // here also change input to String if studentId is String in db

    public boolean verifyStudent(int userId);
}
