package com.golfstore.categories;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;




@Path("/categories")
@Stateless
@LocalBean
public class CategoriesWS {

	@EJB
	CategoryDAO categoryDAO = new CategoryDAO();
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON} )
	public Response findAll() {
		List<Categories> category = categoryDAO.getAll();
		return Response.status(200).entity(category).build();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON})
	@Path("/{id}")
	public Response findCategoryById(@PathParam("id") int id) {
		Categories book = categoryDAO.getCategoryById(id);
		return Response.status(200).entity(book).build();
	}
	
}
