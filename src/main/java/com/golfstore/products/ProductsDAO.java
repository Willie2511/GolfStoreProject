package com.golfstore.products;

import com.golfstore.Repository;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
@LocalBean
public class ProductsDAO extends Repository<Products> {
	
	
	@PersistenceContext
	private EntityManager em;
	
	
	@SuppressWarnings("unchecked")
	public List<Products> getAll() {
		Query query = em.createQuery("Select p FROM Products p");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Products> getProductByMake(String make) {
		Query query = em.createQuery("Select p FROM Products p WHERE p.make LIKE ?1");
		query.setParameter(1, make);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Products> getProductByModel(String model) {
		Query query = em.createQuery("Select p FROM Products p WHERE p.model LIKE ?1");
		query.setParameter(1, model);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Products> getProductByCategory(String category) {
		Query query = em.createQuery("Select p FROM Products p WHERE p.category LIKE ?1");
		query.setParameter(1, category);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Products> getProductById(int productId) {
		Query query = em.createQuery("Select p FROM Products p WHERE p.productId = ?1");
		query.setParameter(1, productId);
		return query.getResultList();
	}


	@Override
	protected Class<Products> getEntityClass() {
		return null;
	}
}
