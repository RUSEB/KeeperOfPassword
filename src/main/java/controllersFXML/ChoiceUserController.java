package controllersFXML;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import dataBaseController.BaseController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import objects.User;
import tools.TemplateGetter;

public class ChoiceUserController extends GridPane implements Initializable{

	@FXML
	private VBox UsersFields;
	private BaseController baseController = BaseController.getBaseController();
	private List<User> users;
	public void initialize(URL location, ResourceBundle resources) {
		setUsers(baseController);
		putUsersInVBOX();
	}

	private void setUsers(BaseController baseController) {
		try {
			users = baseController.getUsers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void putUsersInVBOX() {
		for(User user:users) {
			try {
				Parent root = new TemplateGetter().getResource("templateFieldUser");
				GridPane g = (GridPane)root;
				Label l =(Label)g.getChildren().get(0);
				l.setText(user.getUser());
				UsersFields.getChildren().add(root);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
