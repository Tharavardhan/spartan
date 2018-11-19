package com.spartan.spartanbackend.DALayer;

import java.util.List;

import com.spartan.spartanbackend.model.Address;
import com.spartan.spartanbackend.model.Category;



import java.util.List;


public interface AddressDAO {
	 boolean CreateAddress(Address address);
	 boolean UpdateAddress(Address address);
	 boolean DeleteAddress(int id);
	 Address SelectoneAddress(int addressid);
	 List<Address> SelectallAddress(int cartid);

	}

