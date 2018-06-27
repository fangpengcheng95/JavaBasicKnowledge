package com.fpc.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class MySqlJdbcTest {
	private String driverClass = "com.mysql.jdbc.Driver";
	private Connection connection;
	
	//connection
	public void init(FileInputStream fs) throws IOException, ClassNotFoundException, SQLException {
		Properties properties = new Properties();
		properties.load(fs);
		String url = properties.getProperty("url");
		String username = properties.getProperty("name");
		String password = properties.getProperty("password");
		Class.forName(driverClass);
		connection = DriverManager.getConnection(url,username,password);
	}
	
	//fetch
	public void fetch () throws SQLException {
		String sql = "select * from student";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while ( rs.next() ) {
			System.out.println(rs.getString("s_name"));
		}
		rs.close();
		ps.close();
	}
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		MySqlJdbcTest test = new MySqlJdbcTest();
		File file = new File("C:\\Users\\Administrator\\Desktop\\db.properties");
		FileInputStream fs = new FileInputStream(file);
		test.init(fs);
		test.fetch();
	}
}
