package com.java.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.login.bean.LoginBean;

public class LoginDao {
	private String dbUrl = "jdbc:mysql://localhost:3306/newhotwaxdata";
	private String dbUname = "root";
	private String dbPassword = "root";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public boolean validate(LoginBean loginBean)
	{
		boolean status = false;
		
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		String sql = "select * from userloginnew where userid = ? and password =?";
		PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, loginBean.getUserLoginId());
		ps.setString(2, loginBean.getPassword());
		ResultSet rs = ps.executeQuery();
		status = rs.next();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	/*
	public String insert(LoginBean member)
	{
		loadDriver(dbDriver);
		Connection con = getConnection();
		String result = "Data entered successfully";
		String sql = "insert into newparty (firstname,lastname,address,city,zip,state,country,phone) values ('"+firstname +"','"+lastname +"','"+address+"','"+city+"',"+zip+",'"+ state+"','"+ country+"',"+phone +"') ";
		PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, member.getFirstname());
		ps.setString(2, member.getLastname());
		ps.setString(3, member.getAddress());
		ps.setString(4, member.getCity());
		ps.setInt(5, member.getZip());
		ps.setString(6, member.getState());
		ps.setString(7, member.getCountry());
		ps.setLong(8, member.getPhone());
		ps.setString(1, member.getUserLoginId());
		ps.setString(2, member.getPassword());
		ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "Data not entered";
		}
		
		
       /* String sql1 = "insert into logintable values(?,?)";
		
		//PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql1);
		ps.setString(1, member.getUserLoginId());
		ps.setString(2, member.getPassword());
		
		
		ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "Data not entered 2";
		}
		return result;*/
		
	}

	

