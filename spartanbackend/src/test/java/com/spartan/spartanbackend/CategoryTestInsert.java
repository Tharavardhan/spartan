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
//import com.spartan.spartanbackend.DALayer.CategoryDAOImpl;
//import com.spartan.spartanbackend.model.Category;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringJUnitConfig(classes = DBConfig.class)
//public class CategoryTestInsert {
//
//
//	@Autowired
//	CategoryDAO categoryDAOImpl;
//
//	Category c;
//	@Before
//	public void setUp() throws Exception {
//		c = new Category();
//		c.setCategory_Name("MotherBoard");
//		c.setCategoryDesc("new");
//		
//		
//		
//	}
//
//	@After
//	public void tearDown() throws Exception {
//		
//	categoryDAOImpl.DeleteCategory("MotherBoard");
//	}
//
////	@Test
////	public void testInsert() {
////		assertEquals("success", true, categoryDAOImpl.CreateCategory(c));
////	}
////	
////	@Test
////	public void testDuplicates() {
////		
////		c.setCategory_Name("MotherBoard");
////		c.setCategoryDesc("new");
////		assertEquals("success", true, categoryDAOImpl.CreateCategory(c));
////		assertEquals("success", true, categoryDAOImpl.CreateCategory(c));
////	}
////	
//	@Test
//	public void testUpdate() {
//		assertEquals("success", true, categoryDAOImpl.CreateCategory(c));
//		Category c1 = categoryDAOImpl.ViewOneCategory("MotherBoard");
//		
//		c1.setCategoryDesc("new 1");
//		
//		assertEquals("success", true, categoryDAOImpl.UpdateCategory(c1));
//	}
//
//}
