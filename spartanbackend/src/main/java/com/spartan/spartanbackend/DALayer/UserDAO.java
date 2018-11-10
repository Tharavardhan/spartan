package com.spartan.spartanbackend.DALayer;

import com.spartan.spartanbackend.model.UserDetails;

public interface UserDAO {
	
	boolean CreateUserDetails(UserDetails userdetails);
	boolean UpdateUserDetails(UserDetails userdetails);
	boolean DeleteUserDetails(UserDetails userdetails);
	UserDetails SelectUser(String emailid);
}
