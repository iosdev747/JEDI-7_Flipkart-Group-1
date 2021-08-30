package com.flipkart.restController;

import com.flipkart.bean.Course;
import com.flipkart.business.AdminInterface;
import com.flipkart.business.AdminOperation;
import com.flipkart.exception.CourseFoundException;

import javax.validation.Valid;
import javax.validation.ValidationException;
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
    public Response addCourse(@Valid Course course) throws ValidationException {
        try {
            adminHandler.addCourse(course.getCourseId(), course.getCourseName(), course.getCredit(), course.getProfessorEmpId(), course.getFee());
            return Response.status(201).entity("Course ID: " + course.getCourseId() + ", name: " + course.getCourseName() + " added").build();
        } catch (CourseFoundException e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

}
