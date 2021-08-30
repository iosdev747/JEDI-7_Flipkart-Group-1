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

    /**
     * /admin/viewCourse
     * REST-service for viewing Course List
     *
     * @return List of Courses
     */
    @GET
    @Path("/viewCourse")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> viewCourse() {
        return adminHandler.viewCourse();
    }

    /**
     * /admin/addCourse
     * REST-service for adding Course
     *
     * @param token:  AuthToken
     * @param userID: ID of the Admin
     * @return
     */
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

    /**
     * /admin/deleteCourse
     * REST-service for Deleting Course
     *
     * @param token:    AuthToken
     * @param userID:   ID of the Admin
     * @param courseID: ID of Course.
     * @return
     */
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

    /**
     * /admin/assignCourseToProfessor
     * REST-service for assigning course to professor
     *
     * @param token:AuthToken
     * @param userID:         ID of the Admin
     * @param courseID:       ID of the Course
     * @param professorID:    ID of the Professor
     * @return
     */
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

    /**
     * /admin/addProfessor
     * REST-service for addding a new professor
     *
     * @param token:    AuthToken
     * @param userID:   ID of the Admin
     * @param professor : Object containing details of the Professor to be added.
     * @return
     */
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

    /**
     * /admin/viewPendingAdmissions
     * REST-service for getting all pending-approval of students
     *
     * @param token:AuthToken
     * @param userID          :ID of the Admin
     * @return
     */
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

    /**
     * /admin/approveStudent
     * REST-service for approving the student admission
     *
     * @param token:    AuthToken
     * @param userID    : ID of the Admin
     * @param studentID : ID of the student to be approved.
     * @return
     */
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
