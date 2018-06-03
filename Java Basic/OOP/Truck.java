package oop;

public class Truck extends Vehicle implements Metro{

	Truck(int wheels, String type, String make, int price, String title) {
		super(wheels, type, make, price, title);
		// TODO Auto-generated constructor stub
	}
	
	public void mpg() {
		System.out.println("Truck MPG is roughly 25 to 30");
	}

}
