package com.flipkart.restController;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.business.AdminInterface;
import com.flipkart.business.AdminOperation;
import com.flipkart.exception.*;
import com.flipkart.utils.UserAuth;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/admin")
public class AdminRestController {

    AdminInterface adminHandler;

    public AdminRestController() {
        this.adminHandler = new AdminOperation();
    }

    @GET
    @Path("/viewCourse")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> viewCourse() {
        return adminHandler.viewCourse();
    }

    @POST
    @Path("/addCourse")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCourse(
            @NotNull @HeaderParam("token") String token,
            @NotNull @HeaderParam("userID") int userID,
            @Valid Course course) throws ValidationException {
        if (UserAuth.verifyToken(userID, token) && adminHandler.verifyAdmin(userID)) {
            try {
                adminHandler.addCourse(course.getCourseId(), course.getCourseName(), course.getCredit(), course.getProfessorEmpId(), course.getFee());
                return Response.status(201).entity("Course ID: " + course.getCourseId() + ", name: " + course.getCourseName() + " added").build();
            } catch (CourseFoundException e) {
                return Response.status(500).entity(e.getMessage()).build();
            }
        } else {
            return Response.status(401).entity("Unauthorised, incorrect userID, token headers").build();
        }
    }

    @DELETE
    @Path("/deleteCourse")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCourse(
            @NotNull @HeaderParam("token") String token,
            @NotNull @HeaderParam("userID") int userID,
            @NotNull @QueryParam("courseID") String courseID) throws ValidationException {
        if (UserAuth.verifyToken(userID, token) && adminHandler.verifyAdmin(userID)) {
            try {
                adminHandler.deleteCourse(courseID);
                return Response.status(201).entity("Course with courseCode: " + courseID + " deleted from catalog").build();
            } catch (CourseNotDeletedException | CourseNotFoundException e) {
                return Response.status(409).entity(e.getMessage()).build();
            }
        } else {
            return Response.status(401).entity("Unauthorised, incorrect userID, token headers").build();
        }
    }

    @POST
    @Path("/assignCourseToProfessor")
    @Produces(MediaType.APPLICATION_JSON)
    public Response assignCourse(
            @NotNull @HeaderParam("token") String token,
            @NotNull @HeaderParam("userID") int userID,
            @NotNull @QueryParam("courseID") String courseID,
            @NotNull @QueryParam("professorID") String professorID) throws ValidationException {
        if (UserAuth.verifyToken(userID, token) && adminHandler.verifyAdmin(userID)) {
            try {
                adminHandler.assignCourse(courseID, professorID);
                return Response.status(201).entity("courseCode: " + courseID + " assigned to professor: " + professorID).build();
            } catch (CourseNotFoundException | UserNotFoundException e) {
                return Response.status(409).entity(e.getMessage()).build();
            }
        } else {
            return Response.status(401).entity("Unauthorised, incorrect userID, token headers").build();
        }
    }

    @POST
    @Path("/addProfessor")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProfessor(
            @NotNull @HeaderParam("token") String token,
            @NotNull @HeaderParam("userID") int userID,
            @Valid Professor professor) throws ValidationException {
        if (UserAuth.verifyToken(userID, token) && adminHandler.verifyAdmin(userID)) {
            try {
                adminHandler.addProfessor(professor);
                return Response.status(201).entity("Professor with professorId: " + professor.getUserID() + " added").build();
            } catch (ProfessorNotAddedException | UserIdAlreadyInUseException e) {
                return Response.status(409).entity(e.getMessage()).build();
            }
        } else {
            return Response.status(401).entity("Unauthorised, incorrect userID, token headers").build();
        }
    }

    @GET
    @Path("/viewPendingAdmissions")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> viewPendingAdmissions(
            @NotNull @HeaderParam("token") String token,
            @NotNull @HeaderParam("userID") int userID) {
        if (UserAuth.verifyToken(userID, token) && adminHandler.verifyAdmin(userID)) {
            return adminHandler.viewPendingAdmissions();
        } else {
            return null;
        }
    }

    @PUT
    @Path("/approveStudent")
    @Produces(MediaType.APPLICATION_JSON)
    public Response approveStudent(
            @NotNull @HeaderParam("token") String token,
            @NotNull @HeaderParam("userID") int userID,
            @NotNull @QueryParam("studentID") String studentID) throws ValidationException {
        if (UserAuth.verifyToken(userID, token) && adminHandler.verifyAdmin(userID)) {
            try {
                adminHandler.approveStudent(studentID);
                return Response.status(201).entity("Student with studentId: " + studentID + " approved").build();
            } catch (StudentNotFoundForApprovalException e) {
                return Response.status(409).entity(e.getMessage()).build();
            }
        } else {
            return Response.status(401).entity("Unauthorised, incorrect userID, token headers").build();
        }
    }
}
