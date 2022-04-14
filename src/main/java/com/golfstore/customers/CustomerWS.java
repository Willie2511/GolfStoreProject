package com.golfstore.customers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/Customers")
@Stateless
@LocalBean
public class CustomerWS {
	
	@EJB
	CustomerDAO customerDAO = new CustomerDAO();
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON} )
	public Response findAll() {
		List<Customers> customer = customerDAO.getAll();
		return Response.status(200).entity(customer).build();
	}
	
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public Response saveUser(Customers customer) {
		customer = customerDAO.createCustomer(customer.getCustomerId(), customer.getFirstName(), customer.getLastName(), customer.getContactNumber(), customer.getEmailAddress(), customer.getPassword());
		customerDAO.save(customer);
		return Response.status(201).entity(customer).build();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON})
	@Path("/{customerId}")
	public Response findCustomerById(@PathParam("customerId") int customerId) {
		Customers customer = customerDAO.getCustomerById(customerId);
		return Response.status(200).entity(customer).build();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON})
	@Path("search/{emailAddress}")
	public Response findCustomerByEmailAddress(@PathParam("emailAddress") String emailAddress) {
		List<Customers> customer = customerDAO.getCustomerByEmailAddress(emailAddress);
		return Response.status(200).entity(customer).build();
		
	}

}
