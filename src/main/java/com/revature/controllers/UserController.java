package com.revature.controllers;

import com.revature.models.Users;
import com.revature.services.UserService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class UserController implements Controller{
    private UserService userService = new UserService();
    Handler getUser = (ctx) -> {
        if(ctx.req.getSession(false) != null){
            String name = ctx.pathParam("name");
            Users user = userService.findbyName(name);
            ctx.json(user);
            ctx.status(200);
        }else{
            ctx.status(401);
        }
    };
    @Override
    public void addRoutes(Javalin app) {
        app.get("/users/{name}", getUser);
    }
}
