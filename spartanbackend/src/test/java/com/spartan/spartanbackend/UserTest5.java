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
//import com.spartan.spartanbackend.DALayer.UserDAO;
//import com.spartan.spartanbackend.model.UserDetails;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringJUnitConfig(classes = DBConfig.class)
//public class UserTest5 {
//	@Autowired
//	UserDAO  userDAOImpl;
//	
//	UserDetails u;
//
//	@Before
//	public void setUp() throws Exception {
//		
//		u=new UserDetails();
//		 u.setUser_Name("Vivek");
//		 u.setEmailid("thara@gmail.com");
//		 u.setPhno("1112256");
//		 u.setUser_Password("Brave@9heart");
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}
//
//	@Test
//	public void test() {
//		assertEquals("success", true, userDAOImpl.CreateUserDetails(u));
//	}
//
//}