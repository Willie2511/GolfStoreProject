package com.golfstore.orders;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;




@Path("/Orders")
@Stateless
@LocalBean
public class OrdersWS {


	@EJB
	OrdersDAO ordersDAO = new OrdersDAO() ;

	
	@GET
	@Produces({ MediaType.APPLICATION_JSON} )
	public Response findAll() {
		List<Orders> orders = ordersDAO.getAll();
		return Response.status(200).entity(orders).build();
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON})
	public Response createNewOrder(Orders order){
		order = ordersDAO.createOrders(null,order.getProductId(), order.getTotalPrice(), order.getStatus());
		ordersDAO.save(order);
		return Response.status(201).entity(order).build();
	}
	
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON})
	@Path("search/{orderNumber}")
	public Response findPaymentByOrderNum(@PathParam("orderNumber") int orderNumber) {
		List<Orders> orders = ordersDAO.getOrdersByOrderNumber(orderNumber);
		return Response.status(200).entity(orders).build();
	}


	@PUT
	@Consumes("application/json")
	@Produces({MediaType.APPLICATION_JSON})
	@Path("update/{orderNumber}/{status}")
	public Response updateOrderStatus(@PathParam("orderNumber") Integer orderNumber, @PathParam("status") String status) {
		List<Orders> updateOrder = ordersDAO.getOrdersByOrderNumber(orderNumber);
		ordersDAO.updateOrder(orderNumber, status);
		return Response.status(200).entity(updateOrder).build();
	}

	

}
