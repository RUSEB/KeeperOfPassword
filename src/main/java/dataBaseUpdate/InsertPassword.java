package dataBaseUpdate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import dataBaseController.BaseController;

public class InsertPassword {
	private BaseController baseController = BaseController.getBaseController();
	
	private static InsertPassword  insertPassword = new InsertPassword();
	
	private InsertPassword() {
		
	}
	
	public static InsertPassword getInsertPassword() {
		return insertPassword;
	}
	
	public void createPassword(String userID,String description,String name,String password,String login) {
		try {
			Connection connection = baseController.getConnection(); 
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO passwords (description,name,login,password,dateUpdate,USER_ID) Values (?,?,?,?,?,?)");
			DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");
	        String date = dateFormat.format(Calendar.getInstance().getTime());
	 
			preparedStatement.setString(1, description);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, login);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, date);
            preparedStatement.setString(6, userID);
            preparedStatement.execute();
            connection.close();
            preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
}
