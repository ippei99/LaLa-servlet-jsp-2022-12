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

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		// フォワード先
		String forwardPath = null;
		
		// サーブレットの動作を決定する為の値
		// リクエストパラメータから取得
		String action = request.getParameter("action");
		
		// 登録開始時の処理
		if(action == null) {
			// アクションがヌルなら登録画面表示のJSPのパスを入れる
			forwardPath = "/WEB-INF/jsp/registerForm.jsp";
		} 
		else if(action.equals("done")) {
			// アクションがdoneなら、登録処理へ
			
			// セッションスコープを取得
			HttpSession session = request.getSession();
			// インスタンスを取得
			User registerUser = (User)session.getAttribute("registerUser");
			
			// 登録処理を呼出し
			RegisterUserLogic logic = new RegisterUserLogic();
			logic.execute(registerUser);
			
			// セッションスコープのインスタンスを削除
			session.removeAttribute("registerUser");
			
			//登録後のフォワード先を設定
			forwardPath = "/WEB-INF/jsp/registerDone.jsp";
		}
		
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);

	}

	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		
		// 文字化け防止
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		User registerUser = new User(id, name, pass);
		
		// jspに渡す為セッションに保存（そのあとも考え）
		HttpSession session = request.getSession();
		session.setAttribute("registerUser", registerUser);
		
		String url = "/WEB-INF/jsp/registerConfirm.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
