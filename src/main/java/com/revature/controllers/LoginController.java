package com.revature.controllers;

import com.revature.models.LoginDTO;
import com.revature.services.LoginService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class LoginController implements Controller{
    private LoginService loginService = new LoginService();

    private Handler login = (ctx) -> {
        LoginDTO user = ctx.bodyAsClass(LoginDTO.class); // A DTO (Data transfer object) is a tempory object used just to communicate information.

        if(loginService.login(user.username, user.password)){
            ctx.req.getSession();
            ctx.status(200);
        }else {
            ctx.req.getSession().invalidate();
            ctx.status(401);
        }
    };

    private Handler logout = ctx -> {
        if (ctx.req.getSession(false) != null) {
            ctx.req.getSession().invalidate();
            ctx.status(200);
        } else {
            ctx.status(401);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.post("/login", this.login);
        app.post("/logout", this.logout);
    }
}
