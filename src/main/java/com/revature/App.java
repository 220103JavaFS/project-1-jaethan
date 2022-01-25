package com.revature;

import com.revature.controllers.Controller;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import io.javalin.Javalin;

import java.sql.Driver;

public class App {
    //private static Logger log = LoggerFactory.getLogger(Driver.class);

    private static Javalin app;

    public static void main(String[] args){

        app = Javalin.create();
        configure();
        app.start();

    }

    private static void configure(Controller... controllers){
        for (Controller c: controllers){
            c.addRoutes(app);
        }
    }
}
