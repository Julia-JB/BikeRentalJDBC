package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLConnection {
		private static final String url = Keys.SQL_URL.getKey();
		private static final String USERNAME = Keys.SQL_USERNAME.getKey();
		private static final String PASSWORD = Keys.SQL_PASSWORD.getKey();

		public static Connection getConnection() {
			Connection connection = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url, USERNAME, PASSWORD);

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}
	}



