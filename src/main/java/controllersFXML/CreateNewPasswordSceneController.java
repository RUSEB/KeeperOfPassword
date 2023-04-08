package controllersFXML;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import application.ApplicationStart;
import dataBaseController.BaseController;
import dataBaseUpdate.InsertPassword;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class CreateNewPasswordSceneController extends GridPane implements Initializable{

	private InsertPassword insertPassword = InsertPassword.getInsertPassword();
	@FXML
	private Button viewPasswordButton;
	
	@FXML
	private TextField textPasswordField;
	
	@FXML
	private PasswordField passwordField;
	
	
	@FXML
	private Button backButton;
	
	@FXML 
	private Button createButton;
	
	@FXML
	private TextArea siteField;
	
	@FXML
	private TextField nameField;
	
	@FXML
	private TextField loginField;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		viewPasswordButton.setOnMouseClicked(viewPasswordEventHandler);
		createButton.addEventHandler(MouseEvent.MOUSE_CLICKED, createNewUserEventHandler);
		backButton.addEventHandler(MouseEvent.MOUSE_CLICKED,backEventHandler);
		
	}
	
	private EventHandler<MouseEvent> viewPasswordEventHandler = new EventHandler<MouseEvent>() {
		
		@Override
		public void handle(MouseEvent event) {
			if(textPasswordField.isVisible()) {
				passwordField.setText(textPasswordField.getText());
				textPasswordField.setVisible(false);
			}else {
				textPasswordField.setText(passwordField.getText());
				textPasswordField.setVisible(true);
			}
			
		}
	}; 
	
	private EventHandler<MouseEvent> createNewUserEventHandler =new EventHandler<MouseEvent>(){

		public void handle(MouseEvent event) {
			insertPassword.createPassword(ApplicationStart.getUserID(), siteField.getText(),nameField.getText(), passwordField.getText(),loginField.getText() );
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
	private EventHandler<MouseEvent> backEventHandler = new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
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
