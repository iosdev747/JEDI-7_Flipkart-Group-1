package com.flipkart.constant;

public class SQLConstant {

    // User Queries
    public static final String VERIFY_CREDENTIAL = "SELECT paswrd FROM UserDetail WHERE userID = ?";
    public static final String UPDATE_PASSWORD = "UPDATE UserDetail SET paswrd=? WHERE userId = ?";
    public static final String ADD_USER = "INSERT INTO UserDetail(userID, userName, paswrd,address) VALUES (? , ? , ? ,?)";


    // Student Queries
    public static final String ADD_STUDENT = "INSERT INTO Student (studentID, department, currentYear, userID) values (?, ?, ? ,?)";
    public static final String GET_STUDENT_ID ="SELECT studentID FROM Student WHERE userID = ?";
    public static final String GET_STUDENT_GRADE = "SELECT studentID, studentID, grade FROM Grade WHERE studentID = ?";
    public static final String IS_APPROVED = "SELECT isApproved FROM Student WHERE studentID = ?";
    public static final String VERIFY_STUDENT = "SELECT COUNT(studentID) FROM Student WHERE userID = ?";

    // Professor
    public static final String GET_PROF_COURSE = "SELECT courseID, courseName, credit, professorEmpID, fee FROM Course WHERE professorEmpID = ?";
    public static final String GET_ENROL_STUDENT = "SELECT e.courseID, e.studentID FROM Course c, EnrolledStudent e WHERE c.professorEmpID = ? AND c.courseID = e.courseID";
    public static final String ADD_GRADE = "UPDATE Grade SET grade = ? WHERE courseID = ? AND studentID = ?";
    public static final String GET_PROF_NAME = "SELECT u.userName FROM UserDetail u, Professor p WHERE p.professorEmpId = ? AND p.userID = u.userID";
    public static final String DELETE_COURSE = "DELETE FROM Course WHERE courseID = ?";
    public static final String ADD_COURSE = "INSERT INTO Course (courseID, courseName, credit, professorEmpID, fee) VALUES (?, ?, ?, ?, ?)";
    public static final String ADD_PROFESSOR = "INSERT INTO Professor (userID, professorID, department) VALUES (?, ?, ?)";
    public static final String ASSIGN_COURSE = "UPDATE Course SET professorEmpID = ? WHERE courseID = ?";
    public static final String VIEW_PROFESSOR = "SELECT p.userID, p.professorEmpID, p.department, u.userName, u.paswrd, u.address FROM Professor p, user u WHERE p.userID = u.userID";
    public static final String VERIFY_PROFESSOR = "SELECT COUNT(professorEmpID) FROM Professor WHERE userID = ?";
    public static final String GET_PROFESSOR_ID ="SELECT professorEmpID FROM Professor WHERE userID = ?";

    // Registration
    public static final String REGISTER_COURSE = "INSERT INTO EnrolledStudent (courseID, studentID) values (?, ?)";
    public static final String DROP_REGISTER_COURSE = "DELETE FROM EnrolledStudent WHERE courseID = ? AND studentID = ?";
    public static final String VIEW_ALL_COURSES = "SELECT courseID, courseName, credit, professorEmpID, fee FROM Course";
    public static final String VIEW_REGISTER_COURSES = "SELECT c.courseID, c.courseName, c.credit, c.professorEmpID, c.fee FROM EnrolledStudent e, Course c WHERE e.studentID = ? AND e.courseID = c.courseID";
    public static final String CALCULATE_FEE = "SELECT SUM(c.fee) FROM EnrolledStudent e, course c WHERE e.studentID = ? AND e.courseID = c.courseID";
    public static final String CALCULATE_NO_OF_COURSE = "SELECT COUNT(courseID) FROM EnrolledStudent WHERE studentID = ?";
    public static final String REGISTER_IN_ENROLL = "SELECT * FROM EnrolledStudent WHERE studentID = ? AND courseID = ?";


    // Admin
    public static final String VERIFY_ADMIN = "SELECT COUNT(empID) FROM Admin WHERE userID = ?";
    public static final String GET_ADMIN_ID ="SELECT empID FROM Admin WHERE userID = ?";
}
