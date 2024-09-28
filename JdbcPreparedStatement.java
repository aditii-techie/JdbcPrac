package com.jdbcprac;

import java.util.Scanner;
import java.sql.*;

public class JdbcPreparedStatement {
	//method to insert data
	public static void insertData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name:");
		String name =sc.nextLine();
		System.out.println("Enter age:");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter city:");
		String city =sc.nextLine();
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp","root","Student@321");
		String q = "insert into student(name,age,city) values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(q);
		ps.setString(1,name );
		ps.setInt(2, age);
		ps.setString(3, city);
		ps.executeUpdate();
		System.out.println("Data inserted successfully");
		ps.close();
		con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}
	//method to update data
	public static void updateData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student ID to update:");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter name :");
		String name =sc.nextLine();
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp","root","Student@321");
		String q = "update student set name=? where id=?";
		PreparedStatement ps = con.prepareStatement(q);
		ps.setString(1, name);
		ps.setInt(2, id);
		ps.executeUpdate();
		System.out.println("Data updated successfully");
		ps.close();
		con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}
	//method to fetch all records
	public static void selectData() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp","root","Student@321");
		String q = "select *from student";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println("Id: "+rs.getInt(1)+", Name: "+rs.getString(2)+", Age: "+rs.getInt(3)+", City: "+rs.getString(4));
		}
		rs.close();
		ps.close();
		con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	//method to delete data 
	public static void deleteData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student ID to delete:");
		int id = sc.nextInt();
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp","root","Student@321");
		String q = "delete from student where id=?";
		PreparedStatement ps = con.prepareStatement(q);
		ps.setInt(1, id);
		ps.executeUpdate();
		System.out.println("Data deleted successfully");
		ps.close();
		con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}
}
