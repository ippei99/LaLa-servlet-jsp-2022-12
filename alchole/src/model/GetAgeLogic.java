package model;

public class GetAgeLogic {
	public void execute(User user) {
		String name = user.getName();
		int age = user.getAge();
		String ans = null;
		
		if (age < 20) {
			ans = name + "さんはお酒を飲めません";
		} else {
			ans = name + "さん、飲み過ぎに注意しましょう";
		}
		user.setAns(ans);

	}

}
