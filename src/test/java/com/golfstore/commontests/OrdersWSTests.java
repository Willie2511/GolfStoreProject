package com.golfstore.commontests;


import com.golfstore.orders.Orders;
import com.golfstore.orders.OrdersWS;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;


@RunWith(Arquillian.class)
public class OrdersWSTests {

    @Inject
    OrdersWS ordersWS;

    private Orders order = new Orders(12, 2, 299.00, "Order Complete");

    @Test
    public void testFindAll() {
        Response response = ordersWS.findAll();
        assertEquals(200, response.getStatus());
    }

    @Test
    public void findByOrderNum() {
        Response response = ordersWS.findPaymentByOrderNum(1);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void testCreateNewOrder() {
        order = new Orders(1, 2, 299.00, "In Progress");
        Response response = ordersWS.createNewOrder(order);
        assertEquals(201, response.getStatus());
        Orders newOrder = (Orders) response.getEntity();
        assertEquals(order.getOrderNumber(), newOrder.getOrderNumber());
        assertEquals(order.getProductId(), newOrder.getProductId());
        assertEquals(order.getStatus(), newOrder.getStatus());
        assertEquals(order.getTotalPrice(), newOrder.getTotalPrice(), 0.0f );
    }

//    @Test
//    public void updateOrderStatus() {
//        String status = "In Progress";
//        order.setStatus(status);
//        Response response = ordersWS.updateOrderStatus(order.getProductId(), order.getStatus());
//        Orders newOrder = (Orders) response.getEntity();
//        assertEquals(status, newOrder.getStatus());
//    }


}
