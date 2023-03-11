package application;

import java.io.IOException;
import java.net.MalformedURLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ApplicationStart extends Application {

	private Scene mainScene;
	private Scene passScene;

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Scene scene = getScene("fxml_example");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	// Fast upload fxml files
	private String fxmlFileFromTemplates(String fileName) throws MalformedURLException {
		return "/templates/" + fileName + ".fxml";
	}

	private Scene getScene(String namePage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource(fxmlFileFromTemplates(namePage)));
		Scene scene = new Scene(root);
		return scene;
	}
}
