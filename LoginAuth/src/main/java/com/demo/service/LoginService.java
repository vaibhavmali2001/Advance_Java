package com.demo.service;

import com.demo.beans.MyUser;
import com.demo.beans.RegisterUser;

public interface LoginService {

	MyUser loginAuth(String uname, String pass);

	int registerUser(RegisterUser ru, MyUser mu);



}
