package com.niit.Backend_Niit.DAOIMPL;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Backend_Niit.DAO.UserDAO;
import com.niit.Backend_Niit.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOIMPL implements UserDAO 
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) 
	{
		try 
		{			
			sessionFactory.getCurrentSession().persist(user);			
			return true;
		}
		catch(Exception ex) 
		{
			return false;
		}
	}

	@Override
	public User getByEmail(String email) 
	{
		String selectQuery = "FROM User WHERE email = :email";
		try 
		{
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectQuery,User.class)
						.setParameter("email",email)
							.getSingleResult();
		}
		
		catch(Exception ex) 
		{
			return null;
		}
	}

	@Override
	public List<User> getSupplierList() {
		try
		{
			String selectuser = "FROM User WHERE role = :role and enabled = :enabled";
			
			Query query = sessionFactory.getCurrentSession().createQuery(selectuser);
					
			query.setParameter("role", "SUPPLIER");
			query.setParameter("enabled", true);
							
			return query.getResultList();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
