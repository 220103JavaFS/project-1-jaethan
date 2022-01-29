package com.revature.controllers;

import com.revature.models.Reimbursement;
import com.revature.services.EmployeeService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class EmployeeController implements Controller{
    private EmployeeService employeeService = new EmployeeService();


    Handler addrequest = (ctx) -> {
        if(ctx.req.getSession(false) != null){

            Reimbursement request = ctx.bodyAsClass(Reimbursement.class);
            if(employeeService.reimbRequest(request)){
                ctx.status(202);
            }else {
                ctx.status(400);
            }
        }
        else{
            ctx.status(401);
        }
    };

    Handler viewPastRequest = (ctx) -> {
        if(ctx.req.getSession(false) != null){
            String userId = ctx.pathParam("userId");
            int id = Integer.parseInt(userId);
            ctx.json(employeeService.viewPastRequest(id));
            ctx.status(200);
        }else{
            ctx.status(401);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.post("/employee/", addrequest);
        app.get("/employee/{userId}", viewPastRequest);
    }
}
