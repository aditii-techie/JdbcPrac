package com.jdbcprac;

public class MainClassForJdbcPS {
	public static void main(String[] args) {
		try {
			JdbcPreparedStatement.insertData();
			JdbcPreparedStatement.updateData();
			JdbcPreparedStatement.selectData();
			JdbcPreparedStatement.deleteData();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}


