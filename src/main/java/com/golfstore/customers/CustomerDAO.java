package com.golfstore.customers;

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
public class CustomerDAO extends Repository<Customers> {
	
	@PersistenceContext
	private EntityManager em;
	
	
//	@PostConstruct
//	public void createCustomer() {
//		Customers juneTracey = createCustomer(
//				1, "June", "Tracey", "0874563568", "juneTracey@cgl.com", "jt36363737");
//		Customers rogerWolff = createCustomer(
//				2, "Roger", "Wolff", "0874455432", "rogerWolff@cgl.com", "rw12344321");
//		Customers reginaDully = createCustomer(
//				3, "Regina", "Dully", "087468439", "reginaDully@cgl.com", "rd43241781");
//		em.persist(juneTracey);
//		em.persist(rogerWolff);
//		em.persist(reginaDully);
//	}
	
	public Customers createCustomer(int customerId, String firstName, String lastName, String contactNum, String emailAddress, String password) {
		byte[] sBytes = password.getBytes() ;
		String bcryptPassword = Base64.getEncoder().encodeToString(sBytes);
		return new Customers(customerId, firstName, lastName, contactNum, emailAddress, bcryptPassword);
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Customers> getAll() {
		Query query = em.createQuery("Select c FROM Customers c");
		return query.getResultList();
	}
	
	public Customers save(Customers customer) {
		em.persist(customer);
		return customer;
	}

	@Override
	protected Class<Customers> getEntityClass() {
		return null;
	}

	public Customers getCustomerById(int customerId) {
		return em.find(Customers.class, customerId);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Customers> getCustomerByEmailAddress(String emailAddress) {
		Query query = em.createQuery("Select c FROM Customers c WHERE c.emailAddress LIKE ?1");
		query.setParameter(1, emailAddress);
		return query.getResultList();
	}
	

	

}
