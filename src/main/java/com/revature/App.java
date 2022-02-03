package com.revature;

import com.revature.controllers.*;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Driver;

public class App {
    private static Logger log = LoggerFactory.getLogger(Driver.class);

    private static Javalin app;

    public static void main(String[] args){

        /*app = Javalin.create((config)->{//ethan
            config.addStaticFiles("C:\\Users\\Ethan\\Desktop\\Revature\\Labs\\project-1-jaethan\\frontEnd",
                    Location.EXTERNAL);
        });*/
        app = Javalin.create((config)->{//jay
            config.addStaticFiles("C:\\Users\\Jay\\Documents\\Revature\\Week4\\project-1-jaethan\\frontEnd",
                    Location.EXTERNAL);
        });

        configure(new LoginController(), new EmployeeController(), new ManagerController(), new UserController());
        app.start(7000);

    }

    private static void configure(Controller... controllers){
        for(Controller c: controllers){
            c.addRoutes(app);
        }
    }
}
