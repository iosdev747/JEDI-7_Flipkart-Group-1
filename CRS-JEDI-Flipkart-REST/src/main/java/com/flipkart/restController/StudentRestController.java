package com.flipkart.restController;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.business.RegistrationInterface;
import com.flipkart.business.RegistrationOperation;
import com.flipkart.business.StudentInterface;
import com.flipkart.business.StudentOperation;
import com.flipkart.exception.CourseNotFoundException;
import org.apache.log4j.Logger;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/student")
public class StudentRestController {
    RegistrationInterface registrationHandler;
    StudentInterface studentHandler;

    public StudentRestController() {
        this.registrationHandler = new RegistrationOperation();
        this.studentHandler = new StudentOperation();
    }

    @POST
    @Path("/registerCourse")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerCourses(String courseID, @QueryParam("studentID") String studentID) throws ValidationException {
        try {
            registrationHandler.addCourse(courseID, studentID);
            return Response.status(201).entity("Student ID: " + studentID + " registered with course ID: " + courseID).build();
        } catch (SQLException | CourseNotFoundException e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/dropCourse")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dropCourse(String courseID, @NotNull @QueryParam("studentID") String studentID) throws ValidationException {

        try {
            if (!registrationHandler.isRegistered(courseID, studentID))
                return Response.status(200).entity("Student is not registered").build();
            registrationHandler.dropCourse(courseID, studentID);
            return Response.status(202).entity("You have successfully dropped Course : " + courseID).build();
        } catch (CourseNotFoundException | SQLException e) {
            return Response.status(500).entity(e.getMessage()).build();
        }

    }

    @GET
    @Path("/viewRegisteredCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> viewRegisteredCourse(
            @NotNull
            @QueryParam("studentID") String studentID) throws ValidationException {
        try {
            return registrationHandler.viewRegisterCourse(studentID);
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(RegistrationOperation.class);
            logger.debug(e.getMessage());
        }
        return null;
    }

    @GET
    @Path("/calculateFees")
    public double calculateFee(
            @NotNull
            @QueryParam("studentID") String studentID) throws ValidationException {

        try {
            return registrationHandler.calculate(studentID);
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(RegistrationOperation.class);
            logger.debug(e.getMessage());
        }
        return 0;
    }

    @GET
    @Path("/viewGrades")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Grade> viewGradeCard(
            @NotNull
            @QueryParam("studentID") String studentID) throws ValidationException {

        List<Grade> grades = null;
        try {
            grades = studentHandler.getGrade(studentID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grades;

    }

}
