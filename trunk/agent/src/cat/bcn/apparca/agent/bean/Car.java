package cat.bcn.apparca.agent.bean;

import android.graphics.drawable.Drawable;

public class Car {
	
	private int id;
	private String color;
	private String plate;
	private String brand;
	private String model;
	private Drawable photo;
	
	public Car() {
		
	}
	
	public Car(int id, String color, String plate, String brand, String model, Drawable photo) {
		this.id=id;
		this.color=color;
		this.plate=plate;
		this.brand=brand;
		this.model=model;
		this.photo=photo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Drawable getPhoto() {
		return photo;
	}
	public void setPhoto(Drawable photo) {
		this.photo = photo;
	}

}
