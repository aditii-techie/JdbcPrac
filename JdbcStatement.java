package com.jdbcprac;

import java.sql.*;
import java.util.Scanner;
public class JdbcStatement  {
	//method to insert data
	public static void insertData()  {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name:");
		String name = sc.nextLine();
		System.out.println("Enter age:");
		int age=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter city:");
		String city =sc.nextLine();
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp","root","Student@321");
		Statement st = con.createStatement();
		st.executeUpdate("insert into student(name,age,city) values('" +name+ "','" +age+ "','" +city+ "')");
		System.out.println("inserted");
		st.close();
		con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}
	//method to update data
	public static void updateData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student ID to update:");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter new name:");
		String newName = sc.nextLine();
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp","root","Student@321");
		Statement st = con.createStatement();
		st.executeUpdate("update student set name='" +newName+ "' where id=" +id);
		System.out.println("update done successfully");
		st.close();
		con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}
	//method to fetch all records
	public static void selectData(){
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp","root","Student@321");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select *from student");
		while(rs.next()) {
		System.out.println("Id: "+rs.getInt(1)+", Name: "+rs.getString(2)+", Age: "+rs.getInt(3)+", City: "+rs.getString(4));
		}
		rs.close();
		st.close();
		con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//method to delete data 
	public static void deleteData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student ID to delete:");
		int id=sc.nextInt();
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp","root","Student@321");
		Statement st = con.createStatement();
		st.executeUpdate("delete from student where id=" +id );
		System.out.println(" data deleted successfully");
		st.close();
		con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}
}

