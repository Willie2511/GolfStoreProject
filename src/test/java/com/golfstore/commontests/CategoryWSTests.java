package com.golfstore.commontests;

import com.golfstore.categories.CategoriesWS;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class CategoryWSTests {

    @Inject
    CategoriesWS categoriesWS;




    @Test
    public void findAllCategories(){
        Response response = categoriesWS.findAll();
        System.out.println(response.getEntity());
        assertEquals(200, response.getStatus());
    }

    @Test
    public void findCategoryById() {
        Response response = categoriesWS.findCategoryById(1);
        assertEquals(200, response.getStatus());
    }
}
