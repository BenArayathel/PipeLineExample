package com.revature.controller;

import io.javalin.http.Context;

public class AuthenticateController {
	
	
	
	//What should happen if I fail to login?
	// 	If it fails I should be renavigated back to the login page
	
	//IF it succeeds what should happen?
	//  We will go the planetsLanding page. 
	public String authenticate(Context ctx) {
		
		//My information is all stored within the request! 
		//ctx will have the information I need. 
		
		/*p
		 * The browser can send information on the URL e.g. Planets/1
		 * Query Parameters (Through the form) e.g. login?username=Bob&pass=p4ss
		 * JSON: infomration can be sent via the request body, in the format of JSON
		 */
		
		System.out.println(ctx.formParam("username"));
		System.out.println(ctx.formParam("password"));
		String page = "";
		if(ctx.formParam("username").equals("user") 
				&& ctx.formParam("password").equals("p4ss")){
			
					ctx.sessionAttribute("access", true); //we're now giving them access!
//					page = "PlanetsLandingPage.html";
					page = "/PlanetPage";
					
					ctx.redirect("http://localhost:8000/home");
				}else {
					ctx.sessionAttribute("access",false);
//					page = "failedLogin.html";
					page = "/failedLogin";
					ctx.redirect("http://localhost:8000/failedLogin");
				}
		
//		if(service.authenticate(ctx.queryParam(username))) What we would do in a full stack. 
		
		return page;
		
	}
	
	public void logout(Context ctx) {
		ctx.consumeSessionAttribute("access");
		
	}

}
