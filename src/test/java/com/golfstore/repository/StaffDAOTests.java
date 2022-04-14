package com.golfstore.repository;

import com.golfstore.staff.Staff;
import com.golfstore.staff.StaffDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class StaffDAOTests {

    private EntityManagerFactory emf;

    @PersistenceContext
    private EntityManager em;

    StaffDAO staffDAO;
    Staff staff;
    DBCommandTransactionalExecutor dbCommandTransactionalExecutor;

    @Before
    public void init() {
        emf = Persistence.createEntityManagerFactory("testPU");
        em = emf.createEntityManager();
        staffDAO = new StaffDAO();
        staffDAO.setEntityManager(em);
        staff = new Staff();
        dbCommandTransactionalExecutor = new DBCommandTransactionalExecutor(em);

        staff.setStaffId(1);
        staff.setFirstName("Joe");
        staff.setLastName("Bloggs");
        staff.setEmailAddress("JB@cgl.com");
        staff.setPosition("Manager");
        staff.setPassword("1263781829383892");

    }

    @After
    public void closeEntityManager() {
        em.close();
        emf.close();
    }


    @Test
    public void testGetAllStaff() {
        dbCommandTransactionalExecutor.executeCommand(() -> {
            return staffDAO.save(staff);
        });

        List<Staff> allStaff = staffDAO.getAll();
        Staff staff2 = allStaff.get(0);
        assertEquals(staff.getStaffId(), staff2.getStaffId());
        assertEquals(staff.getFirstName(), staff2.getFirstName());
        assertEquals(staff.getLastName(), staff2.getLastName());
        assertEquals(staff.getEmailAddress(), staff2.getEmailAddress());
        assertEquals(staff.getPosition(), staff2.getPosition());
        assertEquals(staff.getPassword(), staff2.getPassword());
    }

    @Test
    public void testGetStaffById() {
        dbCommandTransactionalExecutor.executeCommand(() -> {
            return staffDAO.save(staff);
        });
        staff = staffDAO.getStaffById(1);
        assertEquals(1, staff.getStaffId());
    }

    @Test
    public void testGetStaffByPosition() {
        dbCommandTransactionalExecutor.executeCommand(() -> {
            return staffDAO.save(staff);
        });
        staff = staffDAO.getStaffByPosition("Manager").get(0);
        assertEquals("Manager", staff.getPosition());
    }

    @Test
    public void testGetStaffByEmailAddress() {
        dbCommandTransactionalExecutor.executeCommand(() -> {
            return staffDAO.save(staff);
        });

        staff = staffDAO.getStaffByEmailAddress("JB@cgl.com").get(0);
        assertEquals("JB@cgl.com", staff.getEmailAddress());
    }









}
