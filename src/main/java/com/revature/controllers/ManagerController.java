package com.revature.controllers;

import com.revature.models.Reimbursement;
import com.revature.services.ManagerService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ManagerController implements Controller{
    private ManagerService managerService = new ManagerService();
    Handler getRequest = (ctx) ->{
        if(ctx.req.getSession(false) != null) {
            ctx.json(managerService.viewAllRequest());
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };
    Handler getUpdates = (ctx) ->{
        if(ctx.req.getSession(false) != null) {
            ctx.json(managerService.viewUpdatedStatus());
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    Handler updateRequest = (ctx) ->{
        if(ctx.req.getSession(false) != null){
            Reimbursement updates = ctx.bodyAsClass(Reimbursement.class);
            if(managerService.updateRequest(updates)){
                ctx.status(202);
            }else{
                ctx.status(400);
            }
        }
        else{
            ctx.status(401);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.get("/manager/allRequest", getRequest);
        app.get("/manager/viewUpdate", getUpdates);
        app.get("/manager/update", updateRequest);

    }
}
