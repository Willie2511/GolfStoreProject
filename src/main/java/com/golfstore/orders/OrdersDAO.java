package com.golfstore.orders;

import com.golfstore.Repository;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;




@Stateless
@LocalBean
public class OrdersDAO extends Repository<Orders> {
	
	@PersistenceContext
	private EntityManager em;
	
//	@PostConstruct
//	public void addOrder() {
//		Orders newOrder = new Orders(1, 5, 499.99, "In Progress");
//		Orders newOrder2 = new Orders(2, 2, 129.99, "In Progress");
//		em.persist(newOrder2);
//		em.persist(newOrder);
//	}

	public Orders createOrders(Integer orderNumber, int productId, double totalPrice, String status) {
		return new Orders(orderNumber,productId, totalPrice, status);
	}
	
	@SuppressWarnings("unchecked")
	public List<Orders> getAll() {
		Query query = em.createQuery("Select o FROM Orders o");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Orders> getOrdersByOrderNumber(Integer orderNumber) {
		Query query = em.createQuery("Select o FROM Orders o WHERE o.orderNumber = ?1");
		query.setParameter(1, orderNumber);
		return query.getResultList();
	}
	
    public Orders save(Orders order) {
        em.persist(order);
        return order;
    }

	@Override
	protected Class<Orders> getEntityClass() {
		return null;
	}


	public void updateOrder(Integer orderNumber, String status) {
		Query query = em.createQuery("UPDATE Orders O SET o.status = ?1 WHERE o.orderNumber = ?2");
		query.setParameter(1, status);
		query.setParameter(2, orderNumber);
		query.executeUpdate();
	}

}
