package com.jdbcprac;

public class MainClassForJdbcStatement {
	public static void main(String[] args) {
		try {
			JdbcStatement.insertData();
			JdbcStatement.updateData();
			JdbcStatement.selectData();
			JdbcStatement.deleteData();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
