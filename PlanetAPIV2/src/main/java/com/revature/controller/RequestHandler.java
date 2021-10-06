package com.revature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Planet;
import com.revature.service.PlanetService;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class RequestHandler {
	
	//This is going to be used to map our endpoints to our controllers
	
	public static boolean checkAccess(Context ctx) {
		if(ctx.sessionAttribute("access") != null //checking if session exists
				&& (Boolean) ctx.sessionAttribute("access") == true) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void setUpEndpoints(Javalin app) {
		
		PlanetController pc = new PlanetController();
		AuthenticateController ac = new AuthenticateController();
		
		final String PLANET = "/planet";
		final String LOGIN_PAGE = "/login";
		final String AUTHENTICATE = "/authenticate";
		final String LOGOUT = "/logout";
		final String PLANET_PAGE = "/home";
		final String FAILED_LOGIN = "/failedLogin";
		final String ROOT_URL = "http://ec2-52-14-64-228.us-east-2.compute.amazonaws.com:8000/Login.html";
		
		//REST operations API
		//RESTful API is a program designed for another program
		//An API exposes functionality via endpoints, we don't prepare views here. 
		
		//Create
		app.post(PLANET, ctx -> {
			if(checkAccess(ctx)) {
				pc.postPlanet(ctx);
			}else {
				ctx.res.setStatus(401);
			}
			
		});
		
		//Get 
		app.get("/planet/{id}", ctx -> {
			
			pc.getPlanet(ctx);
			
		});
		
		app.get(PLANET, ctx -> {
			
			pc.getAllPlanets(ctx);
		});
		
		//Update
		app.put(PLANET, ctx -> {
			
			if(checkAccess(ctx)) {
				pc.putPlanet(ctx);
			}else {
				ctx.res.setStatus(401);
			}
		
			
			
		});
		
		//Delete 
		app.delete("/planet/{id}", ctx -> {
		
			
			pc.deletePlanet(ctx);
			
			System.out.println(ctx.sessionAttributeMap());
			
			if(checkAccess(ctx)) {
				pc.deletePlanet(ctx);
			}else {
				ctx.res.setStatus(401);
			}
			
		});
		
		
		app.get(LOGIN_PAGE, ctx -> { ctx.req.getRequestDispatcher("Login.html").forward(ctx.req, ctx.res);});
		
		app.get(PLANET_PAGE, ctx -> { 
			if(checkAccess(ctx)) {
			ctx.req.getRequestDispatcher("PlanetsLandingPage.html").forward(ctx.req, ctx.res);
					}else {
						ctx.redirect(ROOT_URL);
					}
			});
		
		app.get(FAILED_LOGIN, ctx -> { ctx.req.getRequestDispatcher("failedLogin.html").forward(ctx.req, ctx.res);});
		app.get("/", ctx -> {ctx.redirect(ROOT_URL);});
		
		
		
		//AUTHENITCATION
		//Create statefulness within our project 
		
		app.post(AUTHENTICATE, ctx -> {
			ac.authenticate(ctx);
		});
		
		app.get(LOGOUT, ctx -> {
			ctx.consumeSessionAttribute("");
		});
		
		
	}

}
