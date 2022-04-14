package com.golfstore.commontests;

import com.golfstore.staff.StaffWS;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;


@RunWith(Arquillian.class)
public class StaffWSTests {

    @Inject
    StaffWS staff;

    @Test
    public void findAll() {
        Response response = staff.findAll();
        assertEquals(200, response.getStatus());
    }

    @Test
    public void getById(){
        Response response = staff.findStaffById(2);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void getByEmailAddress() {
        Response response = staff.findStaffByEmailAddress("sarahputh@cgl.staff.com");
        assertEquals(200, response.getStatus());
    }
}
