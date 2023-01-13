package model;

import java.time.Period;
import java.util.List;

public abstract class Student {
	private String name;
	private int mp;
	private int qp;

	public Student() {
		this("生徒");
	}

	public Student(String name) {
		this(name, 100, 10);
	}

	public Student(String name, int mp, int qp) {
		this.name = name;
		this.mp = mp;
		this.qp = qp;
	}

	public String toString() {
		return this.name + " qp(質問力):" + this.qp;
	}
	
	// 今は使ってないが…単体でモンスターを攻撃するメソッド（将来的にオーバーロード用）
	public String question(Period p) {
		String text1 = p.getName() + "の残り時間が減った";

		int damage = (int) (Math.random() * (this.attackHp + 1));
		m.setHp(m.getHp() - damage);
		String text2 = m.getName() + "に" + damage + "のダメージを与えた。";
		return text1 + text2;
	}
	
	// ヒューマンリストを引数とする	
	public void attack(List<Monster> mList) {
		// もしモンスターのHPが０以下ならばリターン
		if (this.getHp() <= 0) { return; }
		
		// 相手を選ぶ為の数字をランダムで作る
		int num = (int)(Math.random() * mList.size());
		
		// 与えるダメージを用意（0～1未満の数字 *（攻撃力+1)をint型にキャスト(整数化）する)
		int damage = (int) (Math.random() * (this.getAttackHp() + 1));
		
		// 攻撃後のHPを用意（相手のHP - ダメージ）
		int newHp = mList.get(num).getHp() - damage;
		
		// 相手のHPを更新（上記数字をセット）
		mList.get(num).setHp(newHp);
		
		// モンスターの名前 ==> ヒーロー名前 
		System.out.print(this.getName() + " ==> ");
		System.out.print(damage + "ダメージ与えた!" + " ");
		System.out.print(mList.get(num).getName() + "のHP");
		
		//　モンスターのHPが０以下ならばリターン 
		if(mList.get(num).getHp() <= 0) { return; }
		
		// HPの表示（残HPの十の位の数だけ*を表示。小数は切り捨て） 
		for(int i = 0; i < newHp / 10; i++) {
			System.out.print("*");
		}
		// 改行
		System.out.println();
	}


}