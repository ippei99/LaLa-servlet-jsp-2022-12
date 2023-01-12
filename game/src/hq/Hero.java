package hq;

public class Hero {
	private String name;
	private int hp;
	private int attackPoint;

	public Hero() {
		this("太郎");
	}

	public Hero(String name) {
		this.name = name;
		this.hp = 100;
		this.attackPoint = 10;
	}

	public void attack(Dragon m) {
		System.out.println(this.name + "は" + m.getName() + "を攻撃した");
		int damage = (int) (Math.random() * attackPoint);
		m.setHp(m.getHp() - damage);
		System.out.println(m.getName() + "に" + damage + "ポイントのダメージを与えた");
	}

	public void run() {
		System.out.println(this.name + "は逃げた");
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
