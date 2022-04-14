package com.golfstore.commontests;


import com.golfstore.customers.CustomerWS;
import com.golfstore.customers.Customers;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.naming.spi.ResolveResult;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class CustomerWSTests {

    @Inject
    CustomerWS customerWS;

    private Customers customer;

    @Test
    public void findAll() {
        Response response = customerWS.findAll();
        assertEquals(200, response.getStatus());
    }

    @Test
    public void findById() {
        Response response = customerWS.findCustomerById(2);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void findByEmailAddress() {
        Response response = customerWS.findCustomerByEmailAddress("JJ@cgl.com");
        assertEquals(200, response.getStatus());
    }

    @Test
    public void  testSaveUser() {
        customer = new Customers(18, "May", "June", "0876543213", "MJ@cgl.com", "1234567891234569");
        Response response = customerWS.saveUser(customer);
        assertEquals(201, response.getStatus());
        Customers entity = (Customers) response.getEntity();
        assertEquals(customer.getCustomerId(), entity.getCustomerId());
        assertEquals(customer.getFirstName(),entity.getFirstName());
        assertEquals(customer.getLastName(), entity.getLastName());
        assertEquals(customer.getContactNumber(), entity.getContactNumber());
        assertEquals(customer.getEmailAddress(), entity.getEmailAddress());
    }
}
