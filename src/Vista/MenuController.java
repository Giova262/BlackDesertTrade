package Vista;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import Model.Producto;
import Model.TradingBDO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MenuController {
	
	private Stage stage; 
	private TradingBDO program = new TradingBDO();
	private ArrayList<Producto> prodList ;
	
	@FXML private ListView<String> prodListView;
	@FXML private ImageView fotoImageView,mapImageView,descripImageView;
	@FXML private Label conocimientoText;

	 @FXML
	 public void initialize() throws ClassNotFoundException, IOException {	
		this.recuperar();
		
		ObservableList<String> items = FXCollections.observableArrayList ();
		this.prodList = this.program.getProducList();
		prodListView.setItems(items);
		
		prodListView.setOnMouseClicked(new EventHandler<Event>() {

				@Override
				public void handle(Event arg0) {		
					ver();
				}
					
		});
		
		for(Producto i:prodList) items.add(i.getProductName() + " - " + i.getRegion() );
							
	 }
	 
	 public void setStage(Stage stage) {
		 this.stage = stage ;
	 }
	 
	 public void salir() {
		 this.stage.close();
	 }
	 
	 public void agregarScene() throws IOException {		 
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/AgregarView.fxml"));
	    Parent root = loader.load();
	    AgregarController controller = loader.getController();
	    controller.setStage(stage);
	    controller.setProgram(program);
	    controller.update();	
	    stage.setScene(new Scene(root,1200,800));
	 }

	 public void ver() {
		 Producto temp = this.prodList.get(   prodListView.getSelectionModel().getSelectedIndex()  );
		
		 fotoImageView.setImage(new Image(temp.getImageName()));
		 mapImageView.setImage(new Image(temp.getLocationImageName()));
		 descripImageView.setImage(new Image(temp.getDescriptionImageName()));
		 conocimientoText.setText(" Nivel de Conocimiento requerido : "+ temp.getKnowledgeLevel());
	 }
	 
	 private void recuperar() {
		 
		try {
			
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("BDOTrading.obj"));	
			this.program  =  (TradingBDO) entrada.readObject();
			entrada.close();
				
		}catch (Exception e) {
			
			System.out.println("No se pudo abrir el archivo de canales");
		}
		
	 }
}
