package com.spartan.spartanbackend.DALayer;

import java.util.List;

import com.spartan.spartanbackend.model.MyOrder;

public interface OrderDAO {
	 boolean Placeorder(MyOrder order);
	 List<MyOrder> ViewOrder(int cartid); 
	 MyOrder Showorder(String orderid);
	}

