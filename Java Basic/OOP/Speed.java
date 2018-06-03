package oop;

public abstract class Speed {
	abstract void speed();
}

class MySpeed extends Speed {
	void speed() {
		System.out.println("implemented abstract class speed");
	}
}