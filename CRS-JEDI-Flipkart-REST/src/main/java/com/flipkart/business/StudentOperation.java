package com.flipkart.business;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.dao.StudentDaoOperation;
import com.flipkart.exception.*;

import org.apache.log4j.Logger;

import java.util.*;
import java.sql.SQLException;




public class StudentOperation  implements StudentInterface{

    /**
     * Constructor
     */
    public StudentOperation() { // In future may be change to private
    }

    /**
     * Registration
     * @param userID
     * @param name
     * @param password
     * @param address
     * @param studentId
     * @param batch
     * @param branch
     * @param isApproved
     * @return
     * @throws StudentNotRegisteredException
     */
    @Override
    public boolean register(int userID, String name, String password, String address, String studentId, int batch, String branch, boolean isApproved) throws StudentNotRegisteredException {
        Logger logger = Logger.getLogger(StudentOperation.class);
        logger.debug("Initiating Registration for Student with ID : " + studentId);
        boolean flag = false;
        try {
            Student student = new Student(userID, name, password, address, studentId, batch, branch, isApproved);
            StudentDaoInterface studentDaoInterface = new StudentDaoOperation();
            studentDaoInterface.addStudent(student);
            flag = true;
        } catch (StudentNotRegisteredException e) {
            throw e;
        }

        return flag;
    }

    /**
     * get student id
     * @param userId
     * @return
     */
    @Override
    public String getStudentId(int userId){
        Logger logger = Logger.getLogger(StudentOperation.class);
        logger.debug("Getting Student ID for user ID: " + Integer.toString(userId));
        StudentDaoInterface studentDaoInterface = new StudentDaoOperation();
        return studentDaoInterface.getStudentId(userId);
    }

    /**
     * view grade card
     * @param studentId
     * @return
     * @throws SQLException
     */
    @Override
    public List<Grade> getGrade(String studentId) throws SQLException{
        Logger logger = Logger.getLogger(StudentOperation.class);
        logger.debug("Grade Card for Student with ID : " + studentId);
        StudentDaoInterface studentDaoInterface = new StudentDaoOperation();

        List<Grade> gradeList = new ArrayList<Grade>();

        try {
            gradeList = studentDaoInterface.getGrade(studentId);
        }
        catch(SQLException e){
            throw e;
        }
        return gradeList;
    }


    /**
     * is student approved?
     * @param studentId
     * @return
     */
    @Override
    public boolean isApproved(String studentId){

        StudentDaoInterface studentDaoInterface = new StudentDaoOperation();
        return studentDaoInterface.isApproved(studentId);

    }

    /**
     * verify student
     * @param userId
     * @return
     */
    @Override
    public boolean verifyStudent(int userId){
        Logger logger = Logger.getLogger(StudentOperation.class);
        logger.debug("Verifying Student with ID : " + userId);
        StudentDaoInterface studentDaoInterface = new StudentDaoOperation();
        return studentDaoInterface.verifyStudent(userId);
    }

}
