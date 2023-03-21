package controllersFXML;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import application.ApplicationStart;
import dataBaseUpdate.InsertUser;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;


public class CreateAccSceneController extends GridPane implements Initializable {
	
	private InsertUser insertUser = InsertUser.getInsertUser();
	
	@FXML
	private Button createButton;
	
	@FXML
	private TextField loginField;
	
	@FXML
	private PasswordField passwordField;
	
	
	public void initialize(URL location, ResourceBundle resources) {

		createButton.addEventHandler(MouseEvent.MOUSE_CLICKED, createNewUserEventHandler);
	}
	
	
	private EventHandler<MouseEvent> createNewUserEventHandler =new EventHandler<MouseEvent>(){

		public void handle(MouseEvent event) {
			insertUser.createUser(loginField.getText(), passwordField.getText());
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
		
	};
	
	

}
