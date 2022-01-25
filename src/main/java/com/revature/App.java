package com.revature;

import com.revature.controllers.Controller;
import com.revature.controllers.LoginController;
import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Driver;

public class App {
    private static Logger log = LoggerFactory.getLogger(Driver.class);

    private static Javalin app;

    public static void main(String[] args){

        app = Javalin.create();
        configure(new LoginController());
        app.start();

    }

    private static void configure(Controller... controllers){
        for (Controller c: controllers){
            c.addRoutes(app);
        }
    }
}
