package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Animal;
import model.Dragon;
import model.Goblin;
import model.Hero;
import model.Human;
import model.Monster;
import model.Slime;

public class Main {

	public static void main(String[] args) {
		// ヒーローリストに入れる
		List<Human> hList = new ArrayList<>();
		hList.add(new Hero("桃太郎"));
		hList.add(new Animal("さる"));
		hList.add(new Animal("いぬ"));
		hList.add(new Animal("きじ"));
		
		// モンスターリストに入れる
		List<Monster> mList = new ArrayList<>();
		mList.add(new Goblin("赤鬼"));
		mList.add(new Dragon("やまたのおろち"));
		mList.add(new Slime("スライム"));
		
		// 逃亡用変数にfalse
		boolean getaway = false;
		
		// ホイール文
		while (true) {
			// モンスターの攻撃
			System.out.println("--- 鬼ヶ島軍団の攻撃 ---");
			// モンスターリストがヒューマンリストを攻撃
			for (Monster m : mList) {
				m.attack(hList);
			}
			// ヒューマンリストでHP０のやつがいたら策k所
			for(int i = 0; i < hList.size(); i++) {
				if(hList.get(i).getHp() <= 0) {
					hList.remove(i);
				}
			}
			// ヒューマンリストが空ならばブレイク（ホイール文から抜ける）
			if(hList.isEmpty()){
				break;
			}
			// ヒューマンの攻撃
			System.out.println("--- 桃太郎達の攻撃 ---");
			
			// ヒューマンリストがモンスターリストを攻撃
			for (Human h : hList) {
				h.attack(mList);
			}
			
			// モンスターリストでHP０のやつがいたら削除
			for(int i = 0; i < mList.size(); i++) {
				if(mList.get(i).getHp() <= 0) {
					mList.remove(i);
				}
			}
			
			// モンスターリストが空ならブレイク
			if(mList.isEmpty()){
				break;
			}
			
			// 現在の各リストを表示
			printStatus(hList, mList);
			
			//　nを選択したらブレイク（ホイール文から抜ける）
			if (sentaku().equals("n")) {
				getaway = true;
				break;
			}

		} //ホイール文の終わり
		
		// モンスターリストがゼロであれば…
		if (mList.isEmpty()) {
			System.out.println("鬼ヶ島軍団は全滅した");
		}
		
		// ヒューマンリストがゼロであれば…
		if (hList.isEmpty()) {
			System.out.println("桃太郎軍団は鬼ヶ島討伐に失敗した");
		}
		
		// getawayがtrueであれば…
		if (getaway) {
			System.out.println("桃太郎軍団は逃げ出した。");
		}
	} // メインメソッドの終わり
	
	// 今はつかってないが…桃太郎が攻撃する敵を選択するメソッド
//	public static Monster selectEnemy(List<Monster> mList) {
//		System.out.println("どれを攻撃しますか？ No >");
//		for (int i = 0; i < mList.size(); i++) {
//			System.out.println(i + ":" + mList.get(i).getName());
//		}
//		int no = new Scanner(System.in).nextInt();
//		return mList.get(no);
//	}
	
	// 逃げるかどうかの選択した文字をリターンするメソッド
	public static String sentaku() {
		System.out.println("どうする？ x:攻撃 n:逃げる >");
		String cmd = new Scanner(System.in).nextLine().toLowerCase();
		return cmd;
	}
	
	// 各リストのHP状態を表示
	public static void printStatus(List<Human> hList, List<Monster> mList) {
		System.out.println("------------------------------------------------");
		
		// ヒューマンリスト表示
		for (Human h : hList) {
			System.out.print(h + " ");
		}
		// 改行
		System.out.println();
		
		//　モンスターリスト表示
		for (Monster m : mList) {
			System.out.print(m + " ");
		}
		// 改行
		System.out.println();
	}
}
