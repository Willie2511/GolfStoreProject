package com.golfstore.repository;

import com.golfstore.categories.Categories;
import com.golfstore.categories.CategoryDAO;
import com.golfstore.staff.Staff;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CategoriesDAOTests {


    private EntityManagerFactory emf;

    @PersistenceContext
    private EntityManager em;

    Categories category;
    CategoryDAO categoryDAO;

    DBCommandTransactionalExecutor dbCommandTransactionalExecutor;

    @Before
    public void init() {
        emf = Persistence.createEntityManagerFactory("testPU");
        em = emf.createEntityManager();
        categoryDAO = new CategoryDAO();
        categoryDAO.setEntityManager(em);
        category = new Categories();
        dbCommandTransactionalExecutor = new DBCommandTransactionalExecutor(em);
        category.setId(1);
        category.setName("Drivers");
        category.setImage("drivers.jpeg");

    }

    @After
    public void closeEntityManager() {
        em.close();
        emf.close();
    }

    @Test
    public void testGetAllCategories() {
        dbCommandTransactionalExecutor.executeCommand(() -> categoryDAO.save(category));

        List<Categories> allCategories = categoryDAO.getAll();
        Categories categories2 = allCategories.get(0);
        assertEquals(category.getId(), categories2.getId());
        assertEquals(category.getImage(), categories2.getImage());
        assertEquals(category.getName(), categories2.getName());
    }

    @Test
    public void testGetById() {
        dbCommandTransactionalExecutor.executeCommand(() -> categoryDAO.save(category));

        Categories categories2 = categoryDAO.getCategoryById(1);
        assertEquals(1, categories2.getId());
    }
}
