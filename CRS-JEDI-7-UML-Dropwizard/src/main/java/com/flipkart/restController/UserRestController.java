package com.flipkart.restController;

import com.flipkart.business.StudentInterface;
import com.flipkart.business.StudentOperation;
import com.flipkart.business.UserInterface;
import com.flipkart.business.UserOperation;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.utils.UserAuth;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserRestController {

    StudentInterface studentHandler;
    UserInterface userHandler;

    public UserRestController() {
        this.studentHandler = new StudentOperation();
        this.userHandler = new UserOperation();
    }

    @POST
    @Path("/signup")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(@NotNull @QueryParam("userID") int userID,
                             @NotNull @QueryParam("name") String name,
                             @NotNull @QueryParam("password") String password,
                             @NotNull @QueryParam("address") String address,
                             @NotNull @QueryParam("studentID") String studentID,
                             @NotNull @QueryParam("batch") int batch,
                             @NotNull @QueryParam("branch") String branch) {
        try {
            if (!studentHandler.register(userID, name, password, address, studentID, batch, branch, false)) {
                return Response.status(500).entity("Something went wrong! Please try again.").build();
            }
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
        return Response.status(201).entity("User (" + name + ") registered successfully").build();
    }

    @POST
    @Path("/login")
    public Response verifyCredentials(
            @NotNull
            @QueryParam("userID") int userID,
            @NotNull
            @QueryParam("password") String password) throws ValidationException {
        try {
            boolean isVerified = userHandler.verifyCredentials(userID, password);
            if (isVerified) {
                String token = UserAuth.getToken(userID);
                return Response.status(200).entity("Login successfully, token = " + token).build();
            } else {
                return Response.status(400).entity("wrong userID/password").build();
            }
        } catch (UserNotFoundException e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/updatePassword")
    public Response updatePassword(
            @NotNull
            @QueryParam("userID") int userID,
            @NotNull
            @QueryParam("newPassword") String newPassword) throws ValidationException {
        if (userHandler.updatePassword(userID, newPassword)) {
            return Response.status(201).entity("Password updated").build();
        } else {
            return Response.status(500).entity("unable to change password").build();
        }

    }
}
