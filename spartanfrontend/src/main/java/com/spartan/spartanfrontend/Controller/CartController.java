package com.spartan.spartanfrontend.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spartan.spartanbackend.DALayer.CartDAO;
import com.spartan.spartanbackend.DALayer.CartDAOImpl;
import com.spartan.spartanbackend.DALayer.ProductDAO;
import com.spartan.spartanbackend.model.Cart;
import com.spartan.spartanbackend.model.Product;

@Controller
public class CartController {

	@Autowired
	CartDAO cartdao;

	@Autowired
	ProductDAO productdao;
	
	

	@RequestMapping("/addToCart")
	String addToCart(@RequestParam("pid") int pid, HttpSession session) {
		if (session.getAttribute("usercartid") != null) {
			Product p = productdao.SelectProduct(pid);
			ArrayList<Cart> cartlist = (ArrayList<Cart>) cartdao
					.SelectCart(Integer.parseInt(session.getAttribute("usercartid").toString()));
			Iterator<Cart> cartiterator = cartlist.listIterator();
			while (cartiterator.hasNext()) {
				Cart cart2 = (Cart) cartiterator.next();
				if (cart2.getPid() == pid) {
					cart2.setQuantity(cart2.getQuantity() + 1);
					int qty = cart2.getQuantity()+1;
					if(qty>3)
					{
						return "redirect:/allproducts";
					}
					cart2.setTotal(cart2.getQuantity() * p.getPrice());
					cartdao.UpdateCart(cart2);
					return "redirect:/allproducts";

				}
			}
			Cart c = new Cart();
			c.setCartid(Integer.parseInt(session.getAttribute("usercartid").toString()));
			c.setPid(pid);
			c.setQuantity(1);
			c.setProduct_Name(p.getProduct_Name());
			c.setPrice(p.getPrice());
			c.setTotal(p.getPrice());
			cartdao.CreateCart(c);
			return "redirect:/allproducts";
		} else {
			session.setAttribute("proid", pid);
			return "redirect:/Login";
		}
	}
		
	@RequestMapping("/user/viewCart")
	 String viewCart(Model m,HttpSession session) 
	 {
	  int cartid=Integer.parseInt(session.getAttribute("usercartid").toString());
	  m.addAttribute("cartpage", true);
	  m.addAttribute("title", "Spartan-MyCart");
	  m.addAttribute("cartlist", cartdao.SelectCart(cartid));
	  return "index";  
	 }

	@RequestMapping("/user/deleteitem")
	public String deletecart(@RequestParam("itemid") int id)
	{
		System.out.println("deletecart");
		
		cartdao.DeleteCart(id);

			
		return "redirect:/user/viewCart";
	}

	
	@RequestMapping("/user/incqty")
	public String incqty(@RequestParam("itemid") int id)
	{
		
		System.out.println("increase qty");
		Cart c=cartdao.Showitem(id);
		int qty=c.getQuantity()+1;
		if(qty>5)
		{
			return "redirect:/user/viewCart";
		}
		else
		{
		c.setQuantity(c.getQuantity()+1);
		c.setTotal(c.getPrice()*c.getQuantity());
		cartdao.UpdateCart(c);
		return "redirect:/user/viewCart";
		}
	}
	@RequestMapping("/user/decqty")
	public String decqty(@RequestParam("itemid") int id)
	{
		
		System.out.println("decrease qty");
		Cart c=cartdao.Showitem(id);
		int qty=c.getQuantity()-1;
		if(qty<=0)		{
			return "redirect:/user/viewCart";
		}
		else
		{
			c.setQuantity(qty);
			c.setTotal(c.getPrice()*qty);
			cartdao.UpdateCart(c);
		
		return "redirect:/user/viewCart";
		}
	}

	



	}
