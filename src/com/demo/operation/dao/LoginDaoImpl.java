package com.demo.operation.dao;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.operation.model.Login;

@Repository("employeeDao")
public class LoginDaoImpl implements LoginDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addUser(Login user) {
		sessionFactory.getCurrentSession().save(user);
		
		
	}

}
