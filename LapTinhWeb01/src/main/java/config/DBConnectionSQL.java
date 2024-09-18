package config;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnectionSQL {
	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://localhost;databaseName=LapTrinhweb;user=sa;password=20102004;encrypt=true;trustServerCertificate=true;";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url);
	}

	public static void main(String[] args) {
		try {
			System.out.println(new DBConnectionSQL().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
