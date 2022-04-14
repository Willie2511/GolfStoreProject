package com.golfstore.payments;

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




@Path("/PaymentDetails")
@Stateless
@LocalBean
public class PaymentsWS {

	@EJB
	PaymentsDAO paymentsDAO = new PaymentsDAO();
	
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON} )
	public Response findAll() {
		List<PaymentDetails> payments = paymentsDAO.getAll();
		return Response.status(200).entity(payments).build();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON})
	@Path("search/{cardNum}")
	public Response findPaymentByCardNum(@PathParam("cardNum") String cardNum) {
		List<PaymentDetails> products = paymentsDAO.getPaymentByCardNum(cardNum);
		return Response.status(200).entity(products).build();
		
	}
}
