package application;
	
import java.io.IOException;

import Vista.MenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class MainTradingBDO extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		primaryStage.setTitle("Trading Info. Black Desert Online");
    	//primaryStage.getIcons().add(new Image("file:vista/imagenes/icono.png"));*/
    	
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/MenuView.fxml"));  
         Parent root = loader.load();     

          MenuController controller = loader.getController();     
          controller.setStage(primaryStage);
         	
          
          Scene scene = new Scene(root,1200,800);    
         /* scene.getStylesheets().add("Estilos.css");*/
          
          primaryStage.setTitle("Linea De Tiempo");
          primaryStage.setScene(scene);
          primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
