package com.golfstore.repository;


import com.golfstore.customers.CustomerDAO;
import com.golfstore.customers.Customers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.Assert.assertEquals;



public class CustomersDAOTest {


    private EntityManagerFactory emf;

    @PersistenceContext
    private EntityManager em;

    Customers customers;
    CustomerDAO customerDAO;

    DBCommandTransactionalExecutor dbCommandTransactionalExecutor;

    @Before
    public void init() {
        emf = Persistence.createEntityManagerFactory("testPU");
        em = emf.createEntityManager();
        customerDAO = new CustomerDAO();
        customerDAO.setEntityManager(em);
        customers = new Customers();
        dbCommandTransactionalExecutor = new DBCommandTransactionalExecutor(em);
        customers.setCustomerId(1);
        customers.setFirstName("Joe");
        customers.setLastName("Bloggs");
        customers.setEmailAddress("JB@cgl.com");
        customers.setContactNumber("0871234567");
        customers.setPassword("1289382392389232");
    }

//    @After
//    public void closeEntityManager() {
//        em.close();
//        emf.close();
//    }


    @Test
    public void testGetAll() {
        dbCommandTransactionalExecutor.executeCommand(() -> customerDAO.save(customers));

        List<Customers> allCustomers = customerDAO.getAll();
        Customers customers2 = allCustomers.get(0);
        assertEquals(customers.getCustomerId(), customers2.getCustomerId());
        assertEquals(customers.getFirstName(), customers2.getFirstName());
        assertEquals(customers.getLastName(), customers2.getLastName());
        assertEquals(customers.getEmailAddress(), customers2.getEmailAddress());
        assertEquals(customers.getContactNumber(), customers2.getContactNumber());
        assertEquals(customers.getPassword(), customers2.getPassword());
    }

    @Test
    public void testGetById() {
        dbCommandTransactionalExecutor.executeCommand(() -> customerDAO.save(customers));

        Customers customer2 = customerDAO.getCustomerById(1);
        assertEquals(1, customer2.getCustomerId());
    }

    @Test
    public void testGetByEmail() {
        dbCommandTransactionalExecutor.executeCommand(() -> customerDAO.save(customers));

        Customers customer2 = customerDAO.getCustomerByEmailAddress("JB@cgl.com").get(0);
        assertEquals("JB@cgl.com", customer2.getEmailAddress());
    }

}
