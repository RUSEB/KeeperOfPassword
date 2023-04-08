package dataBaseController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import application.ApplicationStart;
import objects.Password;
import objects.User;
import tools.Message;
import tools.PropertiesGetter;

public class BaseController {

	private static Properties properties = new Properties();
	private static final String DB_PROPERTIES = "DB";

	private static final String JDBC_DRIVER;
	private static final String DB_URL;
	private static final String DB_USER;
	private static final String DB_PASSWORD;

	private static final BaseController baseController = new BaseController();
	private Connection connection = null;
	private Statement st = null;
	
		static {
		try {
			properties.load(PropertiesGetter.getFilePropetrie(DB_PROPERTIES));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBC_DRIVER = properties.getProperty("db.driver");
		DB_URL = properties.getProperty("db.url");
		DB_USER = properties.getProperty("db.user");
		DB_PASSWORD = properties.getProperty("db.password");

	}

	private BaseController() {};
	
	public static BaseController getBaseController() {
		return baseController;
	}

	public void checkDB() {
		try {
			connection = getConnection();
			Statement st = connection.createStatement();
			try {
				ResultSet r = st.executeQuery("SELECT * FROM passwords");
				Message.println("База уже существует");
			} catch (Exception e) {
				st.execute(		
						"CREATE TABLE users(" 
						+"USER_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
						+"user VARCHAR(30),"
						+"userMainPassword VARCHAR(50));");
				st.execute(
						"CREATE TABLE passwords(" 
						+ "PASSWORD_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
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
	
	public int countUsers() {
		int count = 0;
		try {
			connection = getConnection();
			st = connection.createStatement();
				ResultSet r = st.executeQuery("SELECT * FROM users");
				while(r.next()) {
					count+=1;
				}
			connection.close();
			st.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return count;
	}
	
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}
	
	public List<User> getUsers() throws SQLException {
		List<User> users = new ArrayList();
		Connection c = getConnection();
		st = c.createStatement();
		ResultSet r = st.executeQuery("SELECT * FROM users");
		while(r.next()) {
			users.add(new User(r.getString(1),r.getString(2)));
		}
		c.close();
		st.close();
		
		return users;
	}

	public String getUserID(String user) {
		String userID = "";
		try {
			connection = getConnection();
			PreparedStatement st = connection.prepareStatement("SELECT USER_ID FROM users WHERE user = ?");
			st.setString(1, user);
			ResultSet r = st.executeQuery();
			userID = r.getString(1);
			connection.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userID;
		
	}
	public List<Password> getCurrentUsersPasswords() throws SQLException{
		List<Password> passwords = new ArrayList<>();
		connection = getConnection();
		PreparedStatement st = connection.prepareStatement("SELECT * FROM passwords WHERE USER_ID = ?");
		st.setString(1, getUserID(ApplicationStart.getUser()));
		ResultSet r = st.executeQuery();
		while(r.next()) {
			passwords.add(new Password(r.getString(3),r.getString(4),r.getString(5),r.getString(6),r.getString(2)));
		}
		return passwords;
	}
}
