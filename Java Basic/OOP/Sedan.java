package oop;


public class Sedan extends Vehicle {
	private String transmission;

	public Sedan(int wheels, String type, String make, int price, String title, String transmission) {
		super(wheels, type, make, price, title);
		System.out.println("This is Sedan constructor");
		this.transmission = transmission;
	}

	Sedan(int wheels, String type, String make, int price, String title, String transmission, String color) {
		super(wheels, type, make, price, title);
		System.out.println("This is Sedan constructor");
		this.transmission = transmission;
	}
	
	public int getPrice() {
		System.out.println("This sedan price is:");
		return price;
	}
	
	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	
}
