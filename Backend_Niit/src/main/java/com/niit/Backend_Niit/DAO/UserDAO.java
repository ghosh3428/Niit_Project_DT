package com.niit.Backend_Niit.DAO;

import java.util.List;

import com.niit.Backend_Niit.model.User;

public interface UserDAO 
{
	boolean addUser(User user);
	User getByEmail(String email) ;
	List<User> getSupplierList() ;

}
