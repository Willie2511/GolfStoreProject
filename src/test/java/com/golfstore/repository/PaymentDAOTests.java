package com.golfstore.repository;


import com.golfstore.payments.PaymentDetails;
import com.golfstore.payments.PaymentsDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class PaymentDAOTests {

    private EntityManagerFactory emf;

    @PersistenceContext
    private EntityManager em;

    PaymentDetails payments;
    PaymentsDAO paymentsDAO;

    DBCommandTransactionalExecutor dbCommandTransactionalExecutor;

    @Before
    public void init() {
        emf = Persistence.createEntityManagerFactory("testPU");
        em = emf.createEntityManager();
        paymentsDAO = new PaymentsDAO();
        paymentsDAO.setEntityManager(em);
        payments = new PaymentDetails();
        dbCommandTransactionalExecutor = new DBCommandTransactionalExecutor(em);
        payments.setPaymentId(1);
        payments.setCustomerId(1);
        payments.setNameOnCard("MaryTracey");
        payments.setCardNum("12345678987654321");
        payments.setExpiry("01/24");
        payments.setCvc(213);
    }

    @After
    public void closeEntityManager() {
        em.close();
        emf.close();
    }

    @Test
    public void testGetAll() {
        dbCommandTransactionalExecutor.executeCommand(() -> paymentsDAO.save(payments));

        List<PaymentDetails> allPayments = paymentsDAO.getAll();
        PaymentDetails newPayment = allPayments.get(0);
        assertEquals(payments.getPaymentId(), newPayment.getPaymentId());
        assertEquals(payments.getCustomerId(), newPayment.getCustomerId());
        assertEquals(payments.getCardNum(), newPayment.getCardNum());
        assertEquals(payments.getCvc(), newPayment.getCvc());
        assertEquals(payments.getExpiry(), newPayment.getExpiry());
        assertEquals(payments.getNameOnCard(), newPayment.getNameOnCard());
    }

    @Test
    public void testPaymentByCardNum() {
        dbCommandTransactionalExecutor.executeCommand(() -> paymentsDAO.save(payments));

        List<PaymentDetails> newPayment = paymentsDAO.getPaymentByCardNum("12345678987654321");
        assertEquals("12345678987654321", newPayment.get(0).getCardNum());
    }

}
