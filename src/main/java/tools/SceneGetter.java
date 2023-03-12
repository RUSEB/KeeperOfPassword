package tools;

import java.io.IOException;
import java.net.MalformedURLException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

//Fast upload fxml files from scene
public class SceneGetter {

	protected String fxmlFileFromResources(String fileName) {
		return "/scenes/" + fileName + ".fxml";
	}

	public Scene getResource(String namePage) throws MalformedURLException, IOException {
		Parent root = FXMLLoader.load(getClass().getResource(fxmlFileFromResources(namePage)));
		Scene scene = new Scene(root, 800, 600);
		return scene;
	}
}
