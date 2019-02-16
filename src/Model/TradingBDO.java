package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class TradingBDO implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private ArrayList<Producto> productos;
	private ArrayList<String> canales;
	
	public TradingBDO(){
		
		this.productos = new ArrayList<Producto>();
		this.canales = new  ArrayList<String>();
	}
	
	
	
	public void agregarProducto(String productName,String imageName,String locationImageName,String descriptionImageName,String knowledgeLevel,String region ) {
		Producto temp = new Producto(productName,imageName,locationImageName,descriptionImageName,knowledgeLevel,region);
		this.productos.add(temp);
		System.out.println("Se agrego el Producto exitosamente");
	}
		
	public Producto getProducto(String nombre){
		
		for(Producto i: productos) 	if ( i.getProductName().equals(nombre)  ) return i;	
		
		return null;
	}
	
	public ArrayList<Producto> getProducList(){
		return this.productos;
	}
	
	public void agregarCanal(String name) {
		this.canales.add(name);
	}
	
	public void showChannels() {		
		for(Producto i: productos)  System.out.println(i.getProductName());
	}

}
