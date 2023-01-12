package hq;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Hero hero = new Hero();
		Dragon dragon = new Dragon();
		boolean isRun = false;

		while (hero.getHp() > 0 && dragon.getHp() > 0) {
			System.out.println("ドラゴンを攻撃しますか？");
			System.out.println("y:攻撃 n:逃げる");
			String cmd = new Scanner(System.in).nextLine();
			if (cmd.equals("n")) {
				isRun = true;
				break;
			}
			hero.attack(dragon);
			dragon.attack(hero);
		}

		if (hero.getHp() <= 0) {
			System.out.println("ヒーローは倒れた");
		}
		if (dragon.getHp() <= 0) {
			System.out.println("ドラゴンは倒れた");
		}
		if (isRun) {
			System.out.println("ヒーローは逃げた");

		}
	}

}
