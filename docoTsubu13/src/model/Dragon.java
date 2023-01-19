package model;

public class Dragon extends Monster {
	public Dragon() {
		this("ドラゴン");
	}

	public Dragon(String name) {
		super(name, 650000001, 30);
	}
}
