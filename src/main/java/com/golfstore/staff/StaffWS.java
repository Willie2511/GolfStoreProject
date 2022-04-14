package com.golfstore.staff;

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



@Path("/Staff")
@Stateless
@LocalBean
public class StaffWS {
	
	@EJB
	StaffDAO staffDAO = new StaffDAO();
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON} )
	public Response findAll() {
		List<Staff> staff = staffDAO.getAll();
		return Response.status(200).entity(staff).build();
	}
	
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON})
	@Path("/{staffId}")
	public Response findStaffById(@PathParam("staffId") int staffId) {
		Staff staff = staffDAO.getStaffById(staffId);
		return Response.status(200).entity(staff).build();
	}

	
	@GET
	@Produces({ MediaType.APPLICATION_JSON})
	@Path("/search/{emailAddress}")
	public Response findStaffByEmailAddress(@PathParam("emailAddress") String emailAddress) {
		List<Staff> staff = staffDAO.getStaffByEmailAddress(emailAddress);
		return Response.status(200).entity(staff).build();
	}

	

}
