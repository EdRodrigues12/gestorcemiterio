package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDResourceManagerLG {

	 private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	 private static String JDBC_URL = "jdbc:mysql://localhost/Users";
	 private static String USER = "root";
	 private static String PASSWORD = "root";

	private static BDResourceManagerLG instancia;
	private Connection con;

	private BDResourceManagerLG() throws ClassNotFoundException, SQLException {
		Class.forName(JDBC_DRIVER);
		con = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
	}

	public static BDResourceManagerLG getInstance() throws ClassNotFoundException, SQLException {
		if (instancia == null) {
			instancia = new BDResourceManagerLG();
		}
		return instancia;
	}

	public Connection getCon() {
		return con;
	}

}