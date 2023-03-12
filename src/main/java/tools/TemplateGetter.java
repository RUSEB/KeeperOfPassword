package tools;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class TemplateGetter {

	protected String fxmlFileFromResources(String fileName) {
		return "/templates/" + fileName + ".fxml";
	}

	public Parent getResource(String namePage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource(fxmlFileFromResources(namePage)));
		return root;
	}

}
