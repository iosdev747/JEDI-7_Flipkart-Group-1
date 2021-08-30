package com.flipkart.restController;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.business.ProfessorInterface;
import com.flipkart.business.ProfessorOperation;
import com.flipkart.utils.UserAuth;

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

    /**
     * /professor/getEnrolledStudents
     * REST-service for getting the List of Students enrolled to a Professor
     *
     * @param token:AuthToken
     * @param userID          :ID of the Professor
     * @return List Of Enrolled Students.
     */
    @GET
    @Path("/getEnrolledStudents")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EnrolledStudent> viewEnrolledStudents(
            @NotNull @HeaderParam("token") String token,
            @NotNull @HeaderParam("userID") int userID,
            @NotNull @QueryParam("profID") String profID) throws ValidationException {
        if (UserAuth.verifyToken(userID, token) && professorHandler.verifyProfessor(userID)) {
            List<EnrolledStudent> students;
            try {
                students = professorHandler.getEnrolledStudent(profID);
            } catch (Exception e) {
                return null;
            }
            return students;
        } else {
            return null;
        }
    }

    /**
     * /professor/getCourses
     * REST-service for getting the List of Courses assigned to a Professor
     *
     * @param token:AuthToken
     * @param userID          :ID of the Professor
     * @return List Of Assigned Courses.
     */
    @GET
    @Path("/getCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getCourses(
            @NotNull @HeaderParam("token") String token,
            @NotNull @HeaderParam("userID") int userID,
            @NotNull @QueryParam("profID") String profID) throws ValidationException {
        if (UserAuth.verifyToken(userID, token) && professorHandler.verifyProfessor(userID)) {

            List<Course> courses;
            try {
                courses = professorHandler.getCoursesByProfessor(profID);
            } catch (Exception e) {
                return null;
            }
            return courses;
        } else {
            return null;
        }
    }

    /**
     * /professor/addGrade
     * REST-service for adding Grade of a Student for a particular Course
     *
     * @param token:AuthToken
     * @param userID          :ID of the Professor
     * @param courseID        : ID of the Course
     * @param studentID       : ID of the student
     * @param grade           : Grade to be added
     * @return List Of Enrolled Students.
     */
    @POST
    @Path("/addGrade")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGrade(
            @NotNull @HeaderParam("token") String token,
            @NotNull @HeaderParam("userID") int userID,
            @NotNull @QueryParam("studentID") String studentID,
            @NotNull @QueryParam("courseID") String courseID,
            @QueryParam("grade") double grade) throws ValidationException {
        if (UserAuth.verifyToken(userID, token) && professorHandler.verifyProfessor(userID)) {
            try {
                professorHandler.addGrade(studentID, courseID, grade);
            } catch (Exception e) {
                return Response.status(500).entity(e.getMessage()).build();
            }
            return Response.status(200).entity("Grade added for student ID: " + studentID + ", course ID: " + courseID + ", marks: " + grade).build();
        } else {
            return Response.status(401).entity("Unauthorised, incorrect userID, token headers").build();
        }
    }
}
