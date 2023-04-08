package controllersFXML;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import application.ApplicationStart;
import dataBaseController.BaseController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitPane;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import objects.Password;
import tools.Message;
import tools.TemplateGetter;

public class MainSceneController extends StackPane implements Initializable {

	@FXML
	private Button createButton;

	private BaseController baseController = BaseController.getBaseController();
	@FXML
	private VBox boxForPasswords;
	
	@FXML
	private Label userLabel;

	private List<Password> passwords;
	public void initialize(URL location, ResourceBundle resources) {
		createButton.addEventHandler(MouseEvent.MOUSE_CLICKED, createNewPasswordEventHandler);
		userLabel.setText(ApplicationStart.getUser());
		try {
			passwords = baseController.getCurrentUsersPasswords();
			for (Password pass: passwords) {
				Parent root = new TemplateGetter().getResource("templateFieldPassword");
				Pane p = (Pane)root;
				GridPane grid = (GridPane)((GridPane)p.getChildren().get(1)).getChildren().get(0);
				Label name = (Label)grid.getChildren().get(0);
				name.setText(pass.getName());
				Label login = (Label)grid.getChildren().get(1);
				login.setText(pass.getLogin());
				final PasswordField pF = (PasswordField)grid.getChildren().get(2);
				pF.setText(pass.getPassword());
				GridPane gr = (GridPane)grid.getChildren().get(3);
				Button copyB = (Button)gr.getChildren().get(0);
				final Label pSF = (Label)grid.getChildren().get(4);
				pSF.setText(pass.getPassword());
				copyB.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						Clipboard clipboard = Clipboard.getSystemClipboard();
					     final ClipboardContent content = new ClipboardContent();
					     content.putString(pF.getText());
					     clipboard.setContent(content);
					}
				});
				Button seeB = (Button)gr.getChildren().get(1);
				seeB.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						{
							if(pSF.isVisible()) {
								pSF.setVisible(false);
							}else {
								pSF.setVisible(true);
							}
							
						}
						
					}
				});
				
				
				GridPane grid2 = (GridPane)((GridPane)p.getChildren().get(1)).getChildren().get(1);
				final Hyperlink site = (Hyperlink)grid2.getChildren().get(0);
				site.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						try {
							java.awt.Desktop.getDesktop().browse(new URI(site.getText()));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (URISyntaxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				});
				site.setText(pass.getSiteLink());
				Label date =(Label) grid2.getChildren().get(1);
				date.setText(pass.getDateUpdate());
				boxForPasswords.getChildren().add(p);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private EventHandler<MouseEvent> createNewPasswordEventHandler = new EventHandler<MouseEvent>() {

		public void handle(MouseEvent event) {
			try {
				ApplicationStart.changeScene("createNewPasswordScene");
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
