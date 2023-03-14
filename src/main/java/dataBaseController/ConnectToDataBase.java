package dataBaseController;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import tools.PropertiesGetter;

public class ConnectToDataBase {

	private static Properties properties = new Properties();
	private static final String DB_PROPERTIES = "DB";

	private static final String JDBC_DRIVER;
	private static final String DB_URL;
	private static final String DB_USER;
	private static final String DB_PASSWORD;

	static {
		try {
			properties.load(PropertiesGetter.getFilePropetrie(DB_PROPERTIES));

		} catch (IOException e) {
			e.printStackTrace();
		}
		JDBC_DRIVER = properties.getProperty("db.driver");
		DB_URL = properties.getProperty("db.url");
		DB_USER = properties.getProperty("db.user");
		DB_PASSWORD = properties.getProperty("db.password");

	}

	public ConnectToDataBase() {
	};

	public static void main(String[] args) {
		ConnectToDataBase conn = new ConnectToDataBase();
		conn.createConnection();
	}

	public void createConnection() {
		try {
			Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
