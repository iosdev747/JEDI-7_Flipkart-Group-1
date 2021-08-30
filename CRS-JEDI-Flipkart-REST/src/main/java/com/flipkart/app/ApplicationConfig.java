package com.flipkart.app;

import com.flipkart.restController.AdminRestController;
import com.flipkart.restController.ProfessorRestController;
import com.flipkart.restController.StudentRestController;
import com.flipkart.restController.UserRestController;
import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {
    // Register controllers
    public ApplicationConfig() {
        register(AdminRestController.class);
        register(ProfessorRestController.class);
        register(StudentRestController.class);
        register(UserRestController.class);
    }
}
