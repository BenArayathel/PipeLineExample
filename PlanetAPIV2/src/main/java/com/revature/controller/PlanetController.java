package com.revature.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Planet;
import com.revature.service.PlanetService;

import io.javalin.http.Context;

public class PlanetController {
	
	private PlanetService ps = new PlanetService();

	public void getPlanet(Context ctx) {
		
		System.out.println(ctx.pathParam("id"));
		Planet p = ps.getPlanet(Integer.parseInt(ctx.pathParam("id")));
		
		System.out.println(ps.getAllPlanets());
		
		System.out.println(p);
		
		
		if(p == null) {
			ctx.res.setStatus(404);
			ctx.json("no object");
		}else {
			ctx.res.setStatus(200);
			ctx.json(p);
		}

	}

	public void getAllPlanets(Context ctx) {
		// TODO Auto-generated method stub
		
		ctx.res.setStatus(200);
		ctx.json(ps.getAllPlanets());
	}
	

	public void deletePlanet(Context ctx) {
		
		try {
			int id = Integer.parseInt(ctx.pathParam("id"));
			
			Planet p = ps.getPlanet(id);
			
			boolean success = ps.deletePlanet(p);
			
			
			
			if(success) {
				System.out.println(p.getName() + " is destroyed");
				ctx.res.setStatus(200);
			}else {
				ctx.res.setStatus(404);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
//			ctx.res.setStatus(401);
		}
		
		
		
	}

	public void putPlanet(Context ctx) {
		
		Planet p = null;
		
		ObjectMapper om = new ObjectMapper();
		
		String planetJSONText = ctx.body();
		
		try {
			p = om.readValue(planetJSONText, Planet.class);
			
			
			boolean success = ps.updatePlanet(p);
			
			if(success) {
				ctx.res.setStatus(200);
				
			}else {
				ctx.res.setStatus(402);
			}
			
		} catch (JsonProcessingException e) {
			
			ctx.res.setStatus(401);
			e.printStackTrace();
		} catch (Exception e) {
			ctx.res.setStatus(500);
			e.printStackTrace();
		}
		
		
		
	}

	public void postPlanet(Context ctx) {
		
		Planet p = null;
		
		ObjectMapper om = new ObjectMapper();
		
		String planetJSONText = ctx.body();
		
		try {
			p = om.readValue(planetJSONText, Planet.class);
			
			
			boolean success = ps.addPlanet(p);
			
			if(success) {
				ctx.res.setStatus(200);
				
			}else {
				ctx.res.setStatus(402);
			}
			
		} catch (JsonProcessingException e) {
			
			ctx.res.setStatus(401);
			e.printStackTrace();
		} catch (Exception e) {
			ctx.res.setStatus(500);
			e.printStackTrace();
		}
		
		
		
	}
	
}
