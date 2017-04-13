package com.demo.operation.service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.operation.dao.LoginDAO;
import com.demo.operation.model.Login;
@Service("loginService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LoginServiceImpl  implements LoginService{
	
	@Autowired
	LoginDAO loginDao;
	 
	 @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	 public void addUser(Login user) {
	  loginDao.addUser(user);

}
}
