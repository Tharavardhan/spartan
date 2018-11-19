package com.spartan.spartanbackend.DALayer;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.spartan.spartanbackend.model.MyOrder;

public class OrderDAOImpl implements OrderDAO 
{
 @Autowired
 SessionFactory sessionfactory;
 public boolean Placeorder(MyOrder order) {
  try 
  {
   sessionfactory.getCurrentSession().save(order);
         return true;
  }
   catch (Exception e) {
    return false;
   }
 }
 public List<MyOrder> ViewOrder(int id) {
  try {
   return sessionfactory.getCurrentSession().createQuery("from MyOrder where cartid="+id).list();
  }
  catch (Exception e) {
   return new ArrayList<MyOrder>();
  } 
 }
 public MyOrder Showorder(int orderid) {
  try
  {
   MyOrder order=(MyOrder)sessionfactory.getCurrentSession().createQuery("from MyOrder where orderid="+orderid).uniqueResult();
  return order;
  }
  catch (Exception e) {
   return null;   }
 }
}

