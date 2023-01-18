package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dragon;
import model.Hero;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		
		// ヒーローとドラゴンを用意
		Hero hero = new Hero("社会人３年目");
		Dragon dragon = new Dragon("新ダークマター");
		
		// アプリケーションスコープを呼出す
		ServletContext application = this.getServletContext();
		
		// アプリケーションスコープにヒーローとドラゴンをセットする
		application.setAttribute("hero", hero);
		application.setAttribute("dragon", dragon);
		
		// フォワード先のURLを準備
		String url = "/WEB-INF/jsp/game.jsp";
		
		// フォワード
		request.getRequestDispatcher(url).forward(request, response);		
	}

	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action == null || action.length() == 0) {
			;
		// actionが攻撃なら
		} else if(action.equals("attack")) {
			// アプリケーションスコープを取得
			ServletContext application = this.getServletContext();
			// ヒーローとドラゴンをnew
			Hero hero = (Hero)application.getAttribute("hero");
			Dragon dragon = (Dragon)application.getAttribute("dragon");
			
			// ヒーロの攻撃（〇〇の攻撃…ダメージ与えたという文をメソッドで用意して保存）
			String heroAttack = hero.attack(dragon);
			// リクエストスコープにheroAttackという名前の上記攻撃文を保存
			request.setAttribute("heroAttack", heroAttack);
			
			// ヒーロ同様に、ドラゴンの攻撃文を用意してスコープに保存
			String dragonAttack = dragon.attack(hero);
			request.setAttribute("dragonAttack", dragonAttack);
			
		} else {
			; // 逃げる場合
		}
		// フォワード先のURLを準備
		String url = "/WEB-INF/jsp/game.jsp";
		// フォワード
		request.getRequestDispatcher(url).forward(request, response);	
	}
}
