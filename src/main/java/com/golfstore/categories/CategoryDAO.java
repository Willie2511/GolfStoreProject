package com.golfstore.categories;

import com.golfstore.Repository;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.ws.Response;


@Stateless
@LocalBean
public class CategoryDAO extends Repository<Categories> {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Categories> getAll() {
		Query query = em.createQuery("Select c FROM Categories c");
		return query.getResultList();
	}
	
	public Categories getCategoryById(int id) {
		return em.find(Categories.class, id);
	}

	@Override
	protected Class<Categories> getEntityClass() {
		return null;
	}
}
