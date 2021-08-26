package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.dao.ProfessorDaoInterface;
import com.flipkart.dao.ProfessorDaoOperation;
import com.flipkart.exception.*;

import org.apache.log4j.Logger;
import java.util.*;
import java.sql.*;

public class ProfessorOperation implements ProfessorInterface{

    public ProfessorOperation() {   // In future may be change to private
    }

    @Override
    public List<Course> getCoursesByProfessor(String professorEmpId){
        Logger logger = Logger.getLogger(ProfessorOperation.class);
        logger.debug("Viewing Courses ");
        ProfessorDaoInterface professorInterface = new ProfessorDaoOperation();

        return professorInterface.getCoursesByProfessor(professorEmpId);
    }

    @Override
    public List<EnrolledStudent> getEnrolledStudent(String professorEmpId) throws SQLException{
        Logger logger = Logger.getLogger(ProfessorOperation.class);
        logger.debug("Viewing List of Enrolled Students ");

        List<EnrolledStudent> enrolledStudents = new ArrayList<EnrolledStudent>();
        ProfessorDaoInterface professorInterface = new ProfessorDaoOperation();

        try{
            enrolledStudents = professorInterface.getEnrolledStudent(professorEmpId);
        }
        catch(Exception e){
            throw e;
        }
        return enrolledStudents;
    }

    @Override
    public boolean addGrade(String studentId, String courseId, double grade) throws GradeNotAddedException{
        Logger logger = Logger.getLogger(ProfessorOperation.class);
        logger.debug("Adding Grade : " + grade + " for Student : " + studentId + " for course : " + courseId);
        ProfessorDaoInterface professorInterface = new ProfessorDaoOperation();

        try{
            professorInterface.addGrade(studentId, courseId, grade);
        }
        catch (Exception e){
            throw new GradeNotAddedException(studentId);
        }

        return true;
    }


    @Override
    public String getProfessorName(String professorEmpId){
        Logger logger = Logger.getLogger(ProfessorOperation.class);
        logger.debug("Professor Name for ID : " + professorEmpId);
        ProfessorDaoInterface professorInterface = new ProfessorDaoOperation();

        return professorInterface.getProfessorName(professorEmpId);
    }

    @Override
    public boolean verifyProfessor(int userId){
        Logger logger = Logger.getLogger(ProfessorOperation.class);
        logger.debug("Verifying Professor with userID : " + Integer.toString(userId));
        ProfessorDaoInterface professorInterface = new ProfessorDaoOperation();

        return professorInterface.verifyProfessor(userId);
    }

    /**
     * Mehtod to get professor
     * @param userId
     * @return
     */
    @Override
    public String getProfessorId(int userId){
        Logger logger = Logger.getLogger(ProfessorOperation.class);
        logger.debug("Viewing Professor with userID : " + Integer.toString(userId));
        ProfessorDaoInterface professorInterface = new ProfessorDaoOperation();

        return professorInterface.getProfessorId(userId);
    }
}
