package controllersFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import tools.Message;
import tools.TemplateGetter;

public class mainSceneController extends SplitPane implements Initializable {

	@FXML
	private Button createButton;

	@FXML
	private VBox BoxForPasswords;

	public void initialize(URL location, ResourceBundle resources) {
		createButton.addEventHandler(MouseEvent.MOUSE_CLICKED, createNewField);

	}

	private EventHandler<MouseEvent> createNewField = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			try {
				Parent newField = new TemplateGetter().getResource("templateFieldPassword");
				BoxForPasswords.getChildren().add(newField);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Message.print(Integer.toString(BoxForPasswords.getChildren().size()));
		}
	};

}
