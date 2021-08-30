package com.flipkart.dao;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.exception.StudentNotRegisteredException;

import java.sql.SQLException;
import java.util.List;


public interface StudentDaoInterface {

    boolean addStudent(Student student) throws StudentNotRegisteredException;

    String getStudentId(int userId);
    //  can change return to string if studentId in Db is string

    List<Grade> getGrade(String studentId) throws SQLException;
    // here also change input to String if studentId is String in db

    boolean isApproved(String studentId);   // --> this is not present in the database either left it or add to database
    // here also change input to String if studentId is String in db

    boolean verifyStudent(int userId);
}
