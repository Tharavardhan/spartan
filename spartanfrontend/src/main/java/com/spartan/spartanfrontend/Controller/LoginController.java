package com.spartan.spartanfrontend.Controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spartan.spartanbackend.DALayer.CartDAO;
import com.spartan.spartanbackend.DALayer.ProductDAO;
import com.spartan.spartanbackend.DALayer.UserDAO;
import com.spartan.spartanbackend.model.UserDetails;

@Controller

public class LoginController {
	
	@Autowired
	UserDAO userdao;
	
	@Autowired
	CartDAO cartdao;
	
	@Autowired
	 ProductDAO productdao;
	
	@RequestMapping("/Login")
	public String loginpage(Model m)
	{
		m.addAttribute("loginpage",true);
		m.addAttribute("error",false);
		return "index";
	}
	
	@RequestMapping("/flogin")
	public String errorloginpage(Model m)
	{
		m.addAttribute("loginpage",true);
		m.addAttribute("error",true);
		return "index";
	}
	
	
	@RequestMapping("/loginsucess")
	 public String isLoggedin(HttpSession session) 
	 {
	  String email = SecurityContextHolder.getContext().getAuthentication().getName();
	  @SuppressWarnings("unchecked")
	  Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext()
	    .getAuthentication().getAuthorities();
	  for (GrantedAuthority authority : authorities) 
	  {
	   if (authority.getAuthority().equals("ROLE_USER")) 
	   {
	    UserDetails customer = userdao.SelectUser(email);
	    session.setAttribute("useremail", customer.getEmailid());
	    session.setAttribute("usercartid", customer.getCart_id());
	    session.setAttribute("username",customer.getUser_Name());
	    session.setAttribute("userlogin", true);
	    if(session.getAttribute("proid")!=null)
	    {
	     return "redirect:/addToCart?pid="+Integer.parseInt(session.getAttribute("proid").toString());
	    }
	    else
	    {
	     return "redirect:/";
	    }

	    //session.setAttribute("cartsize", cartdao.ViewCart(customer.getCart_id()).size());
	   } 
	   else 
	   {
	    session.setAttribute("username","Administrator");
	    session.setAttribute("userlogin", false);
	   }
	  }
	  return "redirect:/";
	 }

}
