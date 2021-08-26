package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.dao.ProfessorDaoInterface;
import com.flipkart.dao.ProfessorDaoOperation;


import java.util.*;

public class ProfessorOperation implements ProfessorInterface{

    public ProfessorOperation() {   // In future may be change to private
    }

    @Override
    public List<Course> getCoursesByProfessor(int professorEmpId){
        ProfessorDaoInterface professorInterface = new ProfessorDaoOperation();

        return professorInterface.getCoursesByProfessor(professorEmpId);
    }

    @Override
    public List<EnrolledStudent> getEnrolledStudent(int professorEmpId){
        ProfessorDaoInterface professorInterface = new ProfessorDaoOperation();

        return professorInterface.getEnrolledStudent(professorEmpId);
    }

    @Override
    public boolean addGrade(int studentId, String courseId, double grade){
        ProfessorDaoInterface professorInterface = new ProfessorDaoOperation();

        return professorInterface.addGrade(studentId, courseId, grade);
    }


    @Override
    public String getProfessorName(int professorEmpId){
        ProfessorDaoInterface professorInterface = new ProfessorDaoOperation();

        return professorInterface.getProfessorName(professorEmpId);
    }

    @Override
    public boolean verifyProfessor(int userId){
        ProfessorDaoInterface professorInterface = new ProfessorDaoOperation();

        return professorInterface.verifyProfessor(userId);
    }

    @Override
    public int getProfessorId(int userId){
        ProfessorDaoInterface professorInterface = new ProfessorDaoOperation();

        return professorInterface.getProfessorId(userId);
    }
}
