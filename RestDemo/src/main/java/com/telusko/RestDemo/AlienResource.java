package com.telusko.RestDemo;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jakarta.ws.rs.Consumes;

@Path("aliens")
public class AlienResource
{
	AlienRepository  repo = new AlienRepository();
	@GET
	@Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public List<Alien> getAlien()
	{
		System.out.println("Aliens get called");
		
		return repo.getAliens();
	}
	
	
	
	
	@GET
	@Path("alien/{id}")
	@Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Alien getAliens(@PathParam("id") int id)
	{
			
		return repo.getAlien(id);
	}
	
	
	@POST
	@Path("alien")
	@Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Alien createAlien(Alien a1)
	{
		System.out.println(a1);
		repo.Create(a1);
		return a1;
	}


	
	
	
	
    @PUT
	@Path("alien")
	@Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Alien updateAlien(Alien a1)
	{
		System.out.println(a1);
		
		if(repo.getAlien(a1.getId()).getId()==0)
				{
			          repo.Create(a1);
				}
		else
		{
			repo.update(a1);
		}
		
		return a1;
	}

	
	
	@DELETE
	@Path("alien/{id}")
	public Alien KillAlien(@PathParam("id") int id)
	{
		Alien a = repo.getAlien(id);
		
		if(a.getId()!=0)
		{
			repo.delete(id);
		}
		
		return a;
	}
	
	
	
}
