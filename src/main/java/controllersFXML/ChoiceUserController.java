package controllersFXML;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import application.ApplicationStart;
import dataBaseController.BaseController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import objects.User;
import tools.TemplateGetter;

public class ChoiceUserController extends GridPane implements Initializable{

	@FXML
	private VBox UsersFields;
	
	private int indexCurrentUser;
	 
	private BaseController baseController = BaseController.getBaseController();
	
	private List<User> users;
	
	
	public void initialize(URL location, ResourceBundle resources) {
		setUsers(baseController);
		putUsersInVBOX();
		initButton();
		
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
				Button b =(Button)g.getChildren().get(0);
				b.setText(user.getUser());
				UsersFields.getChildren().add(root);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void initButton() {
		for(int i = 0; i < UsersFields.getChildren().size();i++) {
			//usersButtons.put(((Button)(UsersFields.getChildren().get(i))).getText(),(Button)UsersFields.getChildren().get(i));
			final Button b = (Button)((GridPane) UsersFields.getChildren().get(i)).getChildren().get(0);
			b.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					ApplicationStart.setUser(b.getText());
					try {
						ApplicationStart.changeScene("mainScene");
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
		}
	}
	
	
}
