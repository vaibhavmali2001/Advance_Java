package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.MyUser;
import com.demo.beans.RegisterUser;

public class LoginDaoImpl implements LoginDao {
	
	private static Connection conn;
	private static PreparedStatement psget,psreg,psmyuser;
	static {
		conn=Dbutil.getMyConnection();
		try {
			psget=conn.prepareStatement("select * from Myuser where uname=? and pass=?");
			psreg=conn.prepareStatement("insert into Regs values(?,?,?,?,?,?,?) ");
			psmyuser=conn.prepareStatement("insert into MyUser values(?,?,?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public MyUser LAuth(String uname, String pass) {
		try {
			psget.setString(1, uname);
			psget.setString(2, pass);
			ResultSet rs = psget.executeQuery();
			if(rs.next())
			{
				return new MyUser(uname,pass,rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public int registeradd(RegisterUser ru, MyUser mu) {
		System.out.println(ru);
		try {
			psreg.setInt(1, ru.getUid());
			psreg.setString(2,ru.getName() );
			psreg.setString(3, ru.getAddr());
			psreg.setString(4, ru.getGender());
			psreg.setString(5, ru.getSkills()[0]);
			psreg.setString(6, ru.getCity());
			psreg.setString(7, ru.getUname());
			
			    psreg.executeUpdate();
			    
			 psmyuser.setString(1, mu.getUname());
			 psmyuser.setString(2, mu.getPass());
			 psmyuser.setString(3, "user");
			 
			 return psmyuser.executeUpdate();
			    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}return 0;
		
	}
}
