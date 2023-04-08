package application;

import java.io.IOException;
import java.net.MalformedURLException;

import dataBaseController.BaseController;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tools.Message;
import tools.SceneGetter;

public class ApplicationStart extends Application {

	private static Stage stage;
	private Scene mainScene;
	private Scene passScene;
	
	
	private static String currentUserID;
	private static String currentUser;
	
	private static BaseController baseController = BaseController.getBaseController();
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//baseController.checkDB();
		this.stage = primaryStage;
		primaryStage.setScene(getStartScene());
		primaryStage.setResizable(false);
		primaryStage.show();
		Message.print("Запуск");
		

	}
	private Scene getStartScene() throws MalformedURLException, IOException {
		if(baseController.countUsers()==0) {
			return new SceneGetter().getResource("createAccSceneWithoutBackButton");
		}else 
			{	
			return new SceneGetter().getResource("choiceUser");
			}
	}
	
	public static void changeScene(String nameScene) throws MalformedURLException, IOException {
		stage.setScene(new SceneGetter().getResource(nameScene));
	}

	public static void setUser(String user) {
		currentUser = user;
	}
	public static String getUser() {
		return currentUser;
	}
	
	public static String getUserID() {
		return baseController.getUserID(currentUser);
	}
}
