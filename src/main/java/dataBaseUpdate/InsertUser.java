package dataBaseUpdate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import dataBaseController.BaseController;

public class InsertUser {

	private BaseController baseController = BaseController.getBaseController();
	
	private static InsertUser  insertUser = new InsertUser();
	
	private InsertUser() {
		
	}
	
	public static InsertUser getInsertUser() {
		return insertUser;
	}
	
	public void createUser(String user,String password) {
		try {
			Connection connection = baseController.getConnection(); 
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (user,userMainPassword) Values (?,?)");
			preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);
            preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
