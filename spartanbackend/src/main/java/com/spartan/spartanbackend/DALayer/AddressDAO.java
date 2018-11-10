package com.spartan.spartanbackend.DALayer;

import java.util.List;

import com.spartan.spartanbackend.model.Address;
import com.spartan.spartanbackend.model.Category;


public interface AddressDAO {
	

	boolean CreateAddress(Address address);
	boolean UpdateAddress(Address address);
	boolean DeleteAddress(Address address);
	List<Address> ViewAllAddress(int cartid);
	Address ViewOneAddress(int addressid);


}
