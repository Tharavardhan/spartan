//package com.spartan.spartanbackend;
//
//import static org.junit.Assert.*;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.spartan.spartanbackend.DALayer.CategoryDAO;
//import com.spartan.spartanbackend.DALayer.ProductDAO;
//import com.spartan.spartanbackend.model.Product;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringJUnitConfig(classes = DBConfig.class)
//
//public class ProductTestUpdate {
//	
//	@Autowired
//	ProductDAO  productDAOImpl;
//	
//	Product p;
//	@Autowired
//	CategoryDAO categoryDAOImpl;
//
//	@Before
//	public void setUp() throws Exception {
//		
//		 p=new Product();
//		 p.setProduct_Name("Resistor");
//		 p.setProductDesc("Resists the flow of current");
//		 p.setQuantity("1");
//		 p.setPrice("2");
//		 p.setCategory(categoryDAOImpl.ViewOneCategory("Electronic"));
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}
//
//	@Test
//	public void testUpdate() {
//		
//		productDAOImpl.CreateProduct(p);
//		Product c1 = productDAOImpl.SelectProduct("98");
//		c1.setProductDesc("NEW1");
//		assertEquals("success", true, productDAOImpl.UpdateProduct(c1));
//	}
//}
