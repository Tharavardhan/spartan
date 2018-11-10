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
//import com.spartan.spartanbackend.model.Category;
//import com.spartan.spartanbackend.model.UserCred;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringJUnitConfig(classes = DBConfig.class)
//public class CategoryTestInsDuplicate {
//	@Autowired
//	CategoryDAO categoryDAOImpl;
//
//	Category c;
//
//	@Before
//	public void setUp() throws Exception {
//		c = new Category();	
//	}
//
//	@After
//	public void tearDown() throws Exception {
//		categoryDAOImpl.DeleteCategory("MotherBoard");
//		categoryDAOImpl.DeleteCategory("MotherBoard2");
//
//	}
//	@Test
//	public void test()
//	{
//		c.setCategory_Name("MotherBoard");
//		c.setCategoryDesc("new");
//		assertEquals("success", true, categoryDAOImpl.CreateCategory(c));
//		assertEquals("success", true, categoryDAOImpl.CreateCategory(c));
//	
//	}
//}