package com.revature;

import com.revature.controller.RequestHandler;

import io.javalin.Javalin;

public class MainDriver {
	
	public static void main(String[ args) {
		
		Javalin app = Javalin.create(config -> config.addStaticFiles(
				staticFiles ->
				{
					staticFiles.directory = "/public";
				}
				)).start(8000);
		
//		app.get("$\\{name}", ctx -> { // the {} syntax does not allow slashes ('/') as part of the parameter
//		    ctx.result("Hello: " + ctx.pathParam("name"));
//		});
		
//		RequestHandler rq = new RequestHandler();
		
		RequestHandler.setUpEndpoints(app);
		
	}

}
