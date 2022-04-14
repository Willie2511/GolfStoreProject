package com.golfstore.payments;

import com.golfstore.Repository;

import java.util.Base64;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;





@Stateless
@LocalBean
public class PaymentsDAO extends Repository<PaymentDetails> {
	
	@PersistenceContext
	private EntityManager em;
	
//	@PostConstruct
//	public void createPaymentDetails() {
//		Payments juneTraceyPayment = createPayment(null, 1, "JuneTracey", "1234567891234567", "01/24", 213);
//		Payments rogerWolffPayment = createPayment(null, 2, "RogerWolff", "9876543211234567", "03/23", 781);
//		em.persist(juneTraceyPayment);
//		em.persist(rogerWolffPayment);
//	}
	
	public PaymentDetails createPayment(int customerId, int paymentId, String nameOnCard, String cardNum, String expiry, int cvc) {
		byte[] sBytes = cardNum.getBytes() ;
		String bcryptCardNum = Base64.getEncoder().encodeToString(sBytes);
		return new PaymentDetails(customerId, paymentId, nameOnCard, bcryptCardNum, expiry, cvc);
	}
	
	@SuppressWarnings("unchecked")
	public List<PaymentDetails> getAll() {
		Query query = em.createQuery("Select p FROM PaymentDetails p");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<PaymentDetails> getPaymentByCardNum(String cardNum) {
		Query query = em.createQuery("Select p FROM PaymentDetails p WHERE p.cardNum LIKE ?1");
		query.setParameter(1, cardNum);
		return query.getResultList();
	}

	@Override
	protected Class<PaymentDetails> getEntityClass() {
		return null;
	}
}
