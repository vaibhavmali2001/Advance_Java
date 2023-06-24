package com.demo.service;

import com.demo.beans.MyUser;
import com.demo.beans.RegisterUser;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {
	
	private LoginDao ldao;

	public LoginServiceImpl() {
		super();
		this.ldao =new LoginDaoImpl();
	}

	@Override
	public MyUser loginAuth(String uname, String pass) {
		
		return ldao.LAuth(uname,pass);
	}

	@Override
	public int registerUser(RegisterUser ru, MyUser mu) {
	 return ldao.registeradd(ru,mu);
		
	}
	
	
}
