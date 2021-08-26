package com.flipkart.business;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.dao.StudentDaoOperation;

import java.util.*;

public class StudentOperation  implements StudentInterface{

    public StudentOperation() { // In future may be change to private
    }

    @Override
    public boolean register(int userID, String name, String password, String address, int studentId, int batch, String branch, boolean isApproved){

        try {
            Student student = new Student(userID,name,password,address,studentId,batch,branch,isApproved);
            StudentDaoInterface studentDaoInterface = new StudentDaoOperation();
            studentDaoInterface.addStudent(student);
            return true;
        }
        catch (Exception e){
            System.out.println("There is an Error : "+ e.getMessage());
        }

        return false;
    }

    @Override
    public int getStudentId(int userId){
        StudentDaoInterface studentDaoInterface = new StudentDaoOperation();
        return studentDaoInterface.getStudentId(userId);
    }

    @Override
    public List<Grade> getGrade(int studentId){
        StudentDaoInterface studentDaoInterface = new StudentDaoOperation();
        return studentDaoInterface.getGrade(studentId);
    }

    @Override
    public boolean verifyStudent(int userId){
        StudentDaoInterface studentDaoInterface = new StudentDaoOperation();
        return studentDaoInterface.verifyStudent(userId);
    }

}
