package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Planet;

public class PlanetService {
	
	public PlanetService() {
		this.initalize();
	}

	
	private  List<Planet> planetList = new ArrayList<>();
	
	 public void initalize() {
		planetList.add(new Planet(0,"Mercury","small",false));
		planetList.add(new Planet(1,"Venus","hot",false));
		planetList.add(new Planet(2,"Earth","blue",false));
		planetList.add(new Planet(3,"Mars","red",false));
		planetList.add(new Planet(4,"Jupiter","BIG",true));
	}
	 
	 
	 public boolean addPlanet(Planet p) {
		 return planetList.add(p);
	 }
	 
	 public boolean deletePlanet(Planet p) {
		 
		 int index = -1;
		for(int i = 0; i< this.planetList.size(); i++) {
			
			if(p!= null && p.getId() == planetList.get(i).getId()) {
				index = i;
				
				
			}if(p == null) {
				return true;
			}
		}
		
		if(index > -1) {
			planetList.remove(index);
			return  true;
		}else {
			return false;
		}
		 
		 
		 
	 }
	 
	 public Planet getPlanet(int id) {
		 
		 
		 Planet p = null;
		 
		 try {
			 
		 
		 
			for(int i = 0; i< this.planetList.size(); i++) {
				if(id == planetList.get(i).getId()) {
					p = planetList.get(i);
				}
			}
		 }catch(Exception e) {
			 return null;
		 }
		 
		 return p;
		 
	 }
	 
	 public boolean updatePlanet(Planet updateDetails) {
		 
		 Planet p = this.getPlanet(updateDetails.getId());
		 
		 p.setDescription(updateDetails.getDescription());
		 p.setRings(updateDetails.isRings());
		 p.setName(updateDetails.getName());
		 
		 return true;
		 
		 
	 }
	 
	 public Planet getPlanet(String name) {
		 
		 Planet planet = null;
		 for(Planet p: planetList) {
			 if(p.equals(name)) {
				 planet = p;
			 }
		 }
		 
		 return planet;
		 
	 }
	 
	 public List<Planet> getAllPlanets(){
		 
		 return planetList;
	 }
	
	
	
}
