package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisterUserLogic;
import model.User;

@WebServlet("/RegisterDone")
public class RegisterDone extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		// セッションスコープを取得
		HttpSession session = request.getSession();
		// インスタンスを取得
		User registerUser = (User) session.getAttribute("registerUser");

		// 登録処理を呼出し
		RegisterUserLogic logic = new RegisterUserLogic();
		logic.execute(registerUser);

		// セッションスコープのインスタンスを削除
		session.removeAttribute("registerUser");

		//登録後のフォワード先を設定
		String path = "/WEB-INF/jsp/registerDone.jsp";

		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);

	}

}
