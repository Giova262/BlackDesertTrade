package Model;

import java.io.Serializable;

public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**ATributos */
	private String productName;
	private String imageName;
	private String locationImageName;
	private String descriptionImageName;
	private String knowledgeLevel;
	private String region;
	
	
	public Producto(String productName, String imageName, String locationImageName, String descriptionImageName,
			String knowledgeLevel, String region) {
	
		this.productName = productName;
		this.imageName = imageName;
		this.locationImageName = locationImageName;
		this.descriptionImageName = descriptionImageName;
		this.knowledgeLevel = knowledgeLevel;
		this.region = region;
	}



	public String getProductName() {
		return productName;
	}

	public String getRegion() {
		return this.region;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getImageName() {
		return imageName;
	}


	public void setImageName(String imageName) {
		this.imageName = imageName;
	}


	public String getLocationImageName() {
		return locationImageName;
	}


	public void setLocationImageName(String locationImageName) {
		this.locationImageName = locationImageName;
	}


	public String getDescriptionImageName() {
		return descriptionImageName;
	}


	public void setDescriptionImageName(String descriptionImageName) {
		this.descriptionImageName = descriptionImageName;
	}


	public String getKnowledgeLevel() {
		return knowledgeLevel;
	}


	public void setKnowledgeLevel(String knowledgeLevel) {
		this.knowledgeLevel = knowledgeLevel;
	}	
	
}
