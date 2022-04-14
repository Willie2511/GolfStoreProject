package com.golfstore.commontests;

import com.golfstore.payments.PaymentsWS;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Arquillian.class)
public class PaymentWSTest {

    @Inject
    PaymentsWS payments;

    @Test
    public void findAll() {
        Response response = payments.findAll();
        assertEquals(200, response.getStatus());
    }

    @Test
    public void findByCardNum() {
        Response response = payments.findPaymentByCardNum("1234567891234567");
        assertEquals(200, response.getStatus());

    }
}
