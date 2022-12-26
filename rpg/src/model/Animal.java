package model;

public class Animal extends Human {

	public Animal() {
		this("家来");
	}

	public Animal(String name) {
		super(name, 80, 5);
	}
}