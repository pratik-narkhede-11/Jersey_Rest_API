package com.pratik.restdemo;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {
	
	AlienRepo repo = new AlienRepo();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Alien> getAliens()
	{	
		return repo.getAliens();
	}
	
	@GET
	@Path("alien/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Alien getAlien(@PathParam("id") int id)
	{
		return repo.getAlien(id);
	}
	
	@POST
	@Path("alien")
	@Consumes(MediaType.APPLICATION_JSON)
	public void createAlien(Alien a)
	{
		repo.create(a);
	}
	
	@PUT
	@Path("alien")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateAlien(Alien a)
	{
		if(repo.getAlien(a.getId())== null)
		{
			repo.create(a);
		}
		else {
			repo.update(a);
		}
	}
	
	@DELETE
	@Path("alien/{id}")
	public void killAlien(@PathParam("id") int id)
	{
		repo.delete(id);
	}
	
	
}
