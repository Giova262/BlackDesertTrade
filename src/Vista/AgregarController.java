package Vista;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import Model.TradingBDO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AgregarController {

	 private TradingBDO program ; 
	 private Stage stage; 
	 
	 @FXML private TextField text0,text1,text2,text3,text4,text5,text6,text7,text8,text9,text10;	
	 @FXML private ImageView fotoImageView;
	 @FXML private Button imagenBoton,localizacionBoton,descripcionBoton; 

	 
	 
	 @FXML
	 public void initialize() throws ClassNotFoundException, IOException {
		 imagenBoton.setOnAction(e -> {       this.elegirImagen(0); });
		 localizacionBoton.setOnAction(e -> { this.elegirImagen(1); });
		 descripcionBoton.setOnAction(e -> {  this.elegirImagen(2); });
		
	 }
	 
	 public void update() {
		 
	 }
	 
	 public void setStage(Stage stage) {
		 this.stage = stage ;
	 }
	 
	 public void setProgram(TradingBDO prog) {
		 this.program = prog ;
	 }
	 
	 public void elegirImagen(int idButton) {	 	
		 
		    FileChooser chooser = new FileChooser();
		    chooser.setTitle("Open File");
		    chooser.getExtensionFilters().addAll( new FileChooser.ExtensionFilter("Image Files",
	                        "*.bmp", "*.png", "*.jpg", "*.gif"));
		    
		   chooser.setInitialDirectory(new File("."));
			   
		    File file = chooser.showOpenDialog(new Stage());
		    
		    if(file != null) {
		    	
		        String imagepath;
		        
				try {
					
					imagepath = file.toURI().toURL().toString();
					
					switch (idButton) {
					case 0:
						text5.setText(imagepath);
						break;
					case 1:
						text6.setText(imagepath);
						break;
					case 2:
						text7.setText(imagepath);
						break;
					}
					
					fotoImageView.setImage(new Image(imagepath	));
			        
				} catch (MalformedURLException e) {
					
					e.printStackTrace();
					System.out.println("Error");
				} 
		     
		    }
		    else
		    {
		        Alert alert = new Alert(Alert.AlertType.INFORMATION);
		        alert.setTitle("Information Dialog");
		        alert.setHeaderText("Please Select a File");
		        alert.showAndWait();
		    }
	 }
	 
	 public void crearChannel() throws FileNotFoundException, IOException{		 
		program.agregarCanal( text1.getText() );
		this.guardar();		 
	 }
	 
	 public void crearProducto() throws FileNotFoundException, IOException {	 
		String productName = text4.getText();
	    String imageName = text5.getText();
	    String locationImageName = text6.getText();
		String descriptionImageName = text7.getText();
		String knowledgeLevel = text8.getText();
		String region = text3.getText();
	 
		program.agregarProducto(productName,imageName,locationImageName,descriptionImageName,knowledgeLevel,region);
		this.guardar();
		
		text3.setText(" ");
		text4.setText(" ");
		text5.setText(" ");
		text6.setText(" ");
		text7.setText(" ");
		text8.setText(" ");
		
		fotoImageView.setImage(new Image(""));
	 
	 }
	 
	 public void volver() throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/MenuView.fxml"));
		 Parent root = loader.load();
		 MenuController controller = loader.getController();
		 controller.setStage(stage);
		 stage.setScene(new Scene(root,1200,800));
	 }
	 
	 private void guardar() throws FileNotFoundException, IOException {
		 ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("BDOTrading.obj"));
		 salida.writeObject(program);
		 salida.close();
	 }
	 
	 
}
