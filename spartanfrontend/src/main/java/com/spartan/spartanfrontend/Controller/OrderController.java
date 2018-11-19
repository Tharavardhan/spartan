package com.spartan.spartanfrontend.Controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spartan.spartanbackend.DALayer.AddressDAO;
import com.spartan.spartanbackend.DALayer.CartDAO;
import com.spartan.spartanbackend.DALayer.OrderDAO;
import com.spartan.spartanbackend.DALayer.ProductDAO;
import com.spartan.spartanbackend.model.Cart;
import com.spartan.spartanbackend.model.MyOrder;
import com.spartan.spartanbackend.model.Product;

@Controller
public class OrderController 
{
 @Autowired
 CartDAO cartdao;
 
 @Autowired
 OrderDAO orderdao;
 
 @Autowired
 AddressDAO addressdao;
 
 @Autowired
 ProductDAO productdao;
 
 @RequestMapping("/user/placeorder")
 String placeOrder(@RequestParam("addid")int id,HttpSession session)
 {
  ArrayList<Cart> cartlist = (ArrayList<Cart>) cartdao.ViewCart(Integer.parseInt(session.getAttribute("usercartid").toString()));
  Iterator<Cart> cartiterator = cartlist.listIterator();
  while (cartiterator.hasNext())
  {
   Cart cart2 = (Cart) cartiterator.next();
   Long uuid=UUID.randomUUID().getMostSignificantBits();
   String oid="OD"+uuid.toString().replace('-', '2');
   MyOrder order=new MyOrder();	
   Product p=productdao.SelectProduct(cart2.getPid());
   int qty=p.getQuantity()-cart2.getQuantity();
   System.out.println(qty);
   p.setQuantity(qty);
   productdao.UpdateProduct(p);
   order.setOrderid(oid);
   order.setCartid(Integer.parseInt(session.getAttribute("usercartid").toString()));
   order.setAddid(id);
   order.setOdate(new Date());
   order.setPid(cart2.getPid());
   order.setProduct_Name(cart2.getProduct_Name());
   order.setQuantity(cart2.getQuantity());
   order.setPrice(cart2.getTotal());
   orderdao.Placeorder(order);
   cartdao.DeleteCart(cart2.getItemid());
  }
  return "redirect:/user/viewOrders";
 }
 
 @RequestMapping("/user/viewOrders")
 String viewOrders(Model m,HttpSession session)
 {
  m.addAttribute("orderlist",orderdao.ViewOrder(Integer.parseInt(session.getAttribute("usercartid").toString())));
  m.addAttribute("orderpage",true);
  return"index";
  
 }
 
 @RequestMapping("/user/viewbill")
 String viewBills(Model m,HttpSession session,@RequestParam("orderid")String id)
 {
  MyOrder o=orderdao.Showorder(id);
  m.addAttribute("order",o);
  m.addAttribute("address",addressdao.SelectoneAddress(o.getAddid()));
  m.addAttribute("billpage",true);
  return"index";
  
 }
 
 
}



