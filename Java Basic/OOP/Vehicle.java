package oop;

public class Vehicle {
	public int wheels;
	public String type;
	public String make;
	public int price;
	public String title;
	
	private String color;

	Vehicle(int wheels, String type, String make, int price, String title) {
		System.out.println("This is Vehicle constructor");
		
		this.wheels = wheels;
		this.type = type;
		this.make = make;
		this.price = price;
		this.title = title;
	}

	public int getWheels() {
		return wheels;
	}
	
	public void setWheels(int wheels) {
		this.wheels = wheels;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
