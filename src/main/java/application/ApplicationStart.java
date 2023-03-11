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

		Scene scene = getScene("createAccScene");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	// Fast upload fxml files
	private String fxmlFileFromTemplates(String fileName) throws MalformedURLException {
		return "/scenes/" + fileName + ".fxml";
	}

	private Scene getScene(String namePage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource(fxmlFileFromTemplates(namePage)));
		Scene scene = new Scene(root, 800, 600);
		return scene;
	}
}
