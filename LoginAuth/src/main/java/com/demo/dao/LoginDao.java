package com.demo.dao;

import com.demo.beans.MyUser;
import com.demo.beans.RegisterUser;

public interface LoginDao {

	MyUser LAuth(String uname, String pass);

	int registeradd(RegisterUser ru, MyUser mu);

}
