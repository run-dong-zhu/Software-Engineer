package oop;

public class Purchase {
	public static void main(String[] args) {
		//Inheritance
		Sedan sedan = new Sedan(4, "sedan", "BMW", 10000, "clean", "auto");
		System.out.println(sedan.getType());
		System.out.println(sedan.getMake());
		sedan.setType("coupe");
		System.out.println(sedan.getType());
		
		//private attributes
		System.out.println(sedan.getColor());
		sedan.setColor("White");
		System.out.println(sedan.getColor());
		
		
		Vehicle vehicle = new Sedan(2, "motorbike", "Honda", 5000, "rebuilt", "mannual");
		System.out.println(vehicle.getMake());
		System.out.println(vehicle.getWheels());
		
		//override
		Vehicle vehicle2 = new Vehicle(4, "truck", "Ford", 15000, "clean");
		System.out.println(vehicle2.getPrice());
		System.out.println(sedan.getPrice());
		
		//abstract
		MySpeed mspeed = new MySpeed();
		mspeed.speed();
		Speed speed = new MaxSpeed();
		speed.speed();
		
		//interface
		Truck truck = new Truck(4, "truck", "Toyota", 12000, "salvage");
		truck.mpg();
	}	
}
