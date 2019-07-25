package com.hsy.serverlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ManageDB {

	public static Connection conn;
	public static Statement stmt;
	public static ResultSet rs;
	/********
	 * @code 连接
	 * @param IP
	 * @param Port
	 * @param SID
	 * @param User
	 * @param Password
	 */
	public static void ConnDB(String IP,String User,String Password){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(IP, User, Password);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	/***
	 * @code 查询
	 * @param sql
	 */
	public static void QueryDB(String sql){
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);	
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	/*******
	 * @code 修改
	 * @param sql
	 * @return
	 */
	public static int UpdateDB(String sql){
		try{
			stmt =conn.createStatement();
			int effectrows=stmt.executeUpdate(sql);
			return effectrows;
		}catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
	}
	/**********
	 * @code 显示
	 * @param rs
	 */
	public static void ShowDB(ResultSet rs){
		try{
			int j=rs.getMetaData().getColumnCount();
			for(int i=1;i<=j;i++){
				System.out.print(rs.getMetaData().getColumnName(i)+"\t");
			}
			while(rs.next()){
				for(int i=1;i<=j;i++){
					System.out.print(rs.getString(i)+"\t");
				}
				System.out.println();
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	/****
	 * @code 关闭
	 */
	public static void CloseDB(){
		try{
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
}









