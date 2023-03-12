package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tools.Message;
import tools.SceneGetter;

public class ApplicationStart extends Application {

	private Scene mainScene;
	private Scene passScene;

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Scene scene = new SceneGetter().getResource("mainScene");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		Message.print("Запуск");
		System.out.print("Launch");

	}

}
