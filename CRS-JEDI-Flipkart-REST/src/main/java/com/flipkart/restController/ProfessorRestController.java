package com.flipkart.restController;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.business.ProfessorInterface;
import com.flipkart.business.ProfessorOperation;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/professor")
public class ProfessorRestController {
    ProfessorInterface professorHandler;

    public ProfessorRestController() {
        this.professorHandler = new ProfessorOperation();
    }

    @GET
    @Path("/getEnrolledStudents")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EnrolledStudent> viewEnrolledStudents(
            @NotNull
            @QueryParam("profID") String profID) throws ValidationException {

        List<EnrolledStudent> students;
        try {
            students = professorHandler.getEnrolledStudent(profID);
        } catch (Exception e) {
            return null;
        }
        return students;
    }

    @GET
    @Path("/getCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getCourses(
            @NotNull
            @QueryParam("profID") String profID) throws ValidationException {

        List<Course> courses;
        try {
            courses = professorHandler.getCoursesByProfessor(profID);
        } catch (Exception e) {
            return null;
        }
        return courses;

    }

    @POST
    @Path("/addGrade")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGrade(
            @NotNull
            @QueryParam("studentID") String studentID,
            @NotNull
            @QueryParam("courseID") String courseID,
            @QueryParam("grade") double grade) throws ValidationException {
        try {
            professorHandler.addGrade(studentID, courseID, grade);
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
        return Response.status(200).entity("Grade added for student ID: " + studentID + ", course ID: " + courseID + ", marks: " + grade).build();
    }
}
