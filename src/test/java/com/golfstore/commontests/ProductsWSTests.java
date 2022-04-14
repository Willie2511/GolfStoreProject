package com.golfstore.commontests;

import com.golfstore.products.ProductsWS;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class ProductsWSTests {

    @Inject
    ProductsWS products;

    @Test
    public void findAll() {
        Response response = products.findAll();
        assertEquals(200, response.getStatus());
    }

    @Test
    public void findByModel() {
        Response response = products.findProductsByModel("Driver");
        assertEquals(200, response.getStatus());
    }

    @Test
    public void findByMake() {
        Response response = products.findProductsByMake("Titleist");
        assertEquals(200, response.getStatus());
    }

    @Test
    public void findByCategory() {
        Response response = products.findProductsByCategory("Irons");
        assertEquals(200, response.getStatus());
    }

    @Test
    public void findById() {
        Response response = products.findProductsById(1);
        assertEquals(200, response.getStatus());
    }

}
