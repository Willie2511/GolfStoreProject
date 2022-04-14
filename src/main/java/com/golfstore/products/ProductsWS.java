package com.golfstore.products;

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



@Path("/Products")
@Stateless
@LocalBean
public class ProductsWS  {
	
	@EJB
	ProductsDAO productsDAO = new ProductsDAO();
	

	@GET
	@Produces({ MediaType.APPLICATION_JSON} )
	public Response findAll() {
		List<Products> products = productsDAO.getAll();
		return Response.status(200).entity(products).build();
	}
	
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON})
	@Path("search/{category}")
	public Response findProductsByCategory(@PathParam("category") String category) {
		List<Products> products = productsDAO.getProductByCategory(category);
		return Response.status(200).entity(products).build();
		
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON})
	@Path("search/{make}")
	public Response findProductsByMake(@PathParam("make") String make) {
		List<Products> products = productsDAO.getProductByMake(make);
		return Response.status(200).entity(products).build();
		
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON})
	@Path("search/{model}")
	public Response findProductsByModel(@PathParam("model") String model) {
		List<Products> products = productsDAO.getProductByModel(model);
		return Response.status(200).entity(products).build();
		
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON})
	@Path("search/id/{productId}")
	public Response findProductsById(@PathParam("productId") int productId) {
		List<Products> products = productsDAO.getProductById(productId);
		return Response.status(200).entity(products).build();
		
	}
	

	
}
