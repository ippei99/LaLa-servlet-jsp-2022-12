package model;

import java.util.List;

/**
 * モンスタークラス（抽象クラス）
 * このクラスをもとに、Dragonクラス、Goblinクラス、Slimeクラスを作成する。
 * 
 * https://xxxx.com/dddd.html
 * 
 * @author ユーザー名
 *
 */
public abstract class Monster {
	private String name;
	private int hp;
	private int attackHp;

	public Monster() {
		this("モンスター");
	}

	public Monster(String name) {
		this(name, 100, 20);
	}

	public Monster(String name, int hp, int attackHp) {
		this.name = name;
		this.hp = hp;
		this.attackHp = attackHp;
	}

	public String toString() {
		return this.name + " hp:" + this.hp;
	}
	
	// 今は使ってないが…単体でヒーローを攻撃するメソッド（将来的にオーバーロード用）
	public String attack(Hero h) {
		String text1 = this.name + "が" + h.getName() + "を攻撃！";
		//		int damage = new Random().nextInt(this.attackHp + 1);
		int damage = (int) (Math.random() * (this.attackHp + 1));
		h.setHp(h.getHp() - damage);
		String text2 = h.getName() + "に" + damage + "のダメージを与えた。";
		return text1 + text2;
	}
	
	/**
	 * 桃太郎軍団の1人を乱数によって決め、
	 * その一人を攻撃するメソッド。
	 * 
	 * @param hList -- 桃太郎軍団（桃太郎、さる、きじ）
	 */
	// ヒューマンリストを引数とする	
	public void attack(List<Human> hList) {		
		// 鬼ヶ島軍団の各モンスター(this)のHPが０以下ならばリターン(戻る)
		if (this.getHp() <= 0) { return; }
		
		// 相手を選ぶ為の数字をランダムで作る
		int num = (int)(Math.random() * hList.size());
		
		// 与えるダメージを用意（0～1未満の数字 *（攻撃力+1)をint型にキャスト(整数化）する)
		int damage = (int) (Math.random() * (this.getAttackHp() + 1));
		
		// 攻撃後のHPを用意（相手のHP - ダメージ）
		int newHp = hList.get(num).getHp() - damage;
		
		// 相手のHPを更新（上記数字をセット）
		hList.get(num).setHp(newHp);
		
		// モンスターの名前 ==> ヒーロー名前 
		System.out.print(this.getName() + " ==> ");
		System.out.print(damage + "ダメージ与えた!" + " ");
		System.out.print(hList.get(num).getName() + "のHP");
		
		//　ヒーローのHPが０以下ならばリターン 
		if(hList.get(num).getHp() <= 0) { return; }
		
		// HPの表示（残HPの十の位の数だけ*を表示。小数は切り捨て）
		for(int i = 0; i < newHp / 10; i++) {
			System.out.print("*");
		}
		// 改行
		System.out.println();
	}

	public void run() {

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
		if (hp <= 0) {
			hp = 0;
			System.out.println(this.getName() + "は倒れた");
		}
		this.hp = hp;
	}

	public int getAttackHp() {
		return attackHp;
	}

	public void setAttackHp(int attackHp) {
		this.attackHp = attackHp;
	}
}
