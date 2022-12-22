package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GetAgeLogic;
import model.User;

@WebServlet("/ask")
public class GetAgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		// フォワード
		String url = "/WEB-INF/jsp/question.jsp";
		request.getRequestDispatcher(url).forward(request, response);

	}

	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		
		// 文字化け防止
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータを取得
		String name = request.getParameter("name");
		String age = request.getParameter("age");

		// 入力値をプロパティに設定
		User user = new User();
		user.setName(name);
		user.setAge(Integer.parseInt(age));

		// 酒判定を実行し結果を設定
		GetAgeLogic getAgeLogic = new GetAgeLogic();
		// getAgeLogicインスタンスに結果をセット
		getAgeLogic.execute(user);

		// リクエストスコープに保存
		request.setAttribute("user", user);

		// フォワード
		String url = "/WEB-INF/jsp/result.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
