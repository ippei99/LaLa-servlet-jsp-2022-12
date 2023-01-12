package hq;

public class Dragon {
	private String name;
	private int hp;
	private int attackPoint;

	public Dragon() {
		this("ドラゴン");
	}

	public Dragon(String name) {
		this.name = name;
		this.hp = 200;
		this.attackPoint = 20;
	}

	public void attack(Hero h) {
		System.out.println(this.name + "は" + h.getName() + "を攻撃した");
		int damage = (int) (Math.random() * attackPoint);
		h.setHp(h.getHp() - damage);
		System.out.println(this.name + "は" + h.getName() + "に"
				+ damage + "ポイントのダメージを与えた");

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttackPoint() {
		return attackPoint;
	}

	public void setAttackPoint(int attackPoint) {
		this.attackPoint = attackPoint;
	}

}
