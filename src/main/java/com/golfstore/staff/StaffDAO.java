package com.golfstore.staff;

import com.golfstore.Repository;
import com.golfstore.customers.Customers;

import java.util.Base64;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;




@Stateless
@LocalBean
public class StaffDAO extends Repository<Staff> {
	
	@PersistenceContext
	private EntityManager em;
//	
//	@PostConstruct
//	public void addStaffMembers() {
//		Staff markClancey = createStaffMember(1, "Mark", "Clancey", "Manager", "markclancey@cgl.staff.com", "manager3281!");
//		Staff sarahPuth = createStaffMember(2, "Sarah", "Puth", "Customer Service", "sarahputh@cgl.staff.com", "sarahputh99");
//		em.persist(markClancey);
//		em.persist(sarahPuth);
//	}
	
	public Staff createStaffMember(int staffId, String firstName, String lastName, String position, String emailAddress, String password) {
		byte[] sBytes = password.getBytes() ;
		String bcryptPassword = Base64.getEncoder().encodeToString(sBytes);
		return new Staff(staffId, firstName, lastName, position, emailAddress, bcryptPassword);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Staff> getAll() {
		Query query = em.createQuery("Select s FROM Staff s");
		return query.getResultList();
	}
	

	public Staff getStaffById(int staffId) {
		return em.find(Staff.class, staffId); 
	}
	
	@SuppressWarnings("unchecked")
	public List<Staff> getStaffByPosition(String position) {
		Query query = em.createQuery("Select s FROM Staff s WHERE s.position LIKE ?1");
		query.setParameter(1, position);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Staff> getStaffByEmailAddress(String emailAddress) {
		Query query = em.createQuery("Select s FROM Staff s WHERE s.emailAddress LIKE ?1");
		query.setParameter(1, emailAddress);
		return query.getResultList();
	}

	@Override
	protected Class<Staff> getEntityClass() {
		return null;
	}


}
