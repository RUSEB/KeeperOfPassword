package dataBaseController;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import tools.Message;
import tools.PropertiesGetter;

public class BaseController {

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

	public BaseController() {
	};

	public static void main(String[] args) {
		BaseController conn = new BaseController();
		conn.checkDB();
	}

	public void checkDB() {
		try {
			Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement st = connection.createStatement();

			try {
				ResultSet r = st.executeQuery("SELECT * FROM passwords");
				Message.println("База уже существует");
			} catch (Exception e) {
				st.execute(		
						"CREATE TABLE users(" 
						+"USER_ID INTEGER AUTO_INCREMENT PRIMARY KEY,"
						+"user VARCHAR(30)," + "name VARCHAR(50)," 
						+"userMainPassword VARCHAR(50));");
				st.execute(
						"CREATE TABLE passwords(" 
						+ "PASSWORD_ID INTEGER AUTO_INCREMENT PRIMARY KEY,"
						+ "description VARCHAR(100),"
						+ "name VARCHAR(50)," + "login VARCHAR(50),"
						+ "password VARCHAR(50),"
						+ "dateUpdate DATETIME," 
						+ "USER_ID INTEGER references users(USER_ID))");
				
				
				Message.print("База данных не была найдена, создана новая");
			}

			connection.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
