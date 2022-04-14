package com.golfstore.repository;

import com.golfstore.orders.Orders;
import com.golfstore.orders.OrdersDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class OrdersDAOTests {

    private EntityManagerFactory emf;

    @PersistenceContext
    private EntityManager em;

    Orders orders;
    OrdersDAO ordersDAO;

    DBCommandTransactionalExecutor dbCommandTransactionalExecutor;

    @Before
    public void init() {
        emf = Persistence.createEntityManagerFactory("testPU");
        em = emf.createEntityManager();
        ordersDAO = new OrdersDAO();
        ordersDAO.setEntityManager(em);
        orders = new Orders();
        dbCommandTransactionalExecutor = new DBCommandTransactionalExecutor(em);
        orders.setOrderNumber(1);
        orders.setProductId(1);
        orders.setTotalPrice(299.00);
        orders.setStatus("In Progress");
    }

//    @After
//    public void closeEntityManager() {
//        em.close();
//        emf.close();
//    }

    @Test
    public void testGetAll() {
        dbCommandTransactionalExecutor.executeCommand(() -> ordersDAO.save(orders));

        List<Orders> allOrders = ordersDAO.getAll();
        Orders order2 = allOrders.get(0);
        assertEquals(orders.getOrderNumber(), order2.getOrderNumber());
        assertEquals(orders.getProductId(), order2.getProductId());
        assertEquals(orders.getTotalPrice(), order2.getTotalPrice(), 0.0f);
        assertEquals(orders.getStatus(), order2.getStatus());
    }

    @Test
    public void getOrdersByOrderNumber() {
        dbCommandTransactionalExecutor.executeCommand(() -> ordersDAO.save(orders));

        Orders newOrder = ordersDAO.getOrdersByOrderNumber(1).get(0);
        assertEquals(Optional.of(1), newOrder.getOrderNumber());
    }

    @Test
    public void testUpdateOrder() {
        dbCommandTransactionalExecutor.executeCommand(() -> ordersDAO.save(orders));
        ordersDAO.updateOrder(1, "Complete");
        assertEquals("Complete", orders.getStatus());
    }






}
