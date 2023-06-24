package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao {
	
	private static Connection con;
	private static PreparedStatement psget;
	static
	{
		con=Dbutil.getMyConnection();
		try {
			psget=con.prepareStatement("select * from product1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<Product> getAll() {
		
		List<Product>plist=new ArrayList<>();
	try {
		ResultSet rs=psget.executeQuery();
		while(rs.next())
		{
	
				plist.add (new Product (rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getFloat(4)));
			
		}
		return plist;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
	}

}
