package com.golfstore.repository;

import com.golfstore.orders.Orders;
import com.golfstore.products.Products;
import com.golfstore.products.ProductsDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductsDAOTests {

    private EntityManagerFactory emf;

    @PersistenceContext
    private EntityManager em;

    Products products;
    ProductsDAO productsDAO;

    DBCommandTransactionalExecutor dbCommandTransactionalExecutor;

    @Before
    public void init() {
        emf = Persistence.createEntityManagerFactory("testPU");
        em = emf.createEntityManager();
        productsDAO = new ProductsDAO();
        productsDAO.setEntityManager(em);
        products = new Products();
        dbCommandTransactionalExecutor = new DBCommandTransactionalExecutor(em);
        products.setProductId(1);
        products.setCategory("Irons");
        products.setImage("irons.jpeg");
        products.setPrice(1549.99);
        products.setMake("Titleist");
        products.setModel("t100s");
    }

    @After
    public void closeEntityManager() {
        em.close();
        emf.close();
    }


    @Test
    public void testGetAll() {
        dbCommandTransactionalExecutor.executeCommand(() -> productsDAO.save(products));

        List<Products> allProducts = productsDAO.getAll();
        Products product2 = allProducts.get(0);
        assertEquals(products.getProductId(), product2.getProductId());
        assertEquals(products.getCategory(), product2.getCategory());
        assertEquals(products.getImage(), product2.getImage());
        assertEquals(products.getMake(), product2.getMake());
        assertEquals(products.getPrice(), product2.getPrice());
        assertEquals(products.getModel(), product2.getModel());
    }

    @Test
    public void testGetProductById() {
        dbCommandTransactionalExecutor.executeCommand(() -> productsDAO.save(products));

        Products newProduct = productsDAO.getProductById(1).get(0);
        assertEquals(1, newProduct.getProductId());
    }

    @Test
    public void testGetProductByMake() {
        dbCommandTransactionalExecutor.executeCommand(() -> productsDAO.save(products));

        Products newProduct = productsDAO.getProductByMake("Titleist").get(0);
        assertEquals("Titleist", newProduct.getMake());
    }

    @Test
    public void testGetProductByModel() {
        dbCommandTransactionalExecutor.executeCommand(() -> productsDAO.save(products));

        Products newProduct = productsDAO.getProductByModel("t100s").get(0);
        assertEquals("t100s", newProduct.getModel());
    }

    @Test
    public void testGetByCategory() {
        dbCommandTransactionalExecutor.executeCommand(() -> productsDAO.save(products));

        Products newProduct = productsDAO.getProductByCategory("Driver").get(0);
        assertEquals("Driver", newProduct.getCategory());
    }

}
