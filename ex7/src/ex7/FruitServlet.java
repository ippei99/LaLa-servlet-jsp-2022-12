package ex7;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FruitServlet")
public class FruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		
		Fruit fruit = new Fruit("いちご", 700);
		
		// リクエストスコープの場合
//		request.setAttribute("fruit", fruit);
		
		// セッションスコープの場合
//		HttpSession session = request.getSession();
//		session.setAttribute("fruit", fruit);
		
		// ID表示
//		String sessionId = session.getId();
//		session.setAttribute("sessionId", sessionId);
		
		//　アプリケーションスコープの場合
		ServletContext application = this.getServletContext();
		application.setAttribute("fruit", fruit);
		
		String url = "/WEB-INF/ex/fruit.jsp";
		RequestDispatcher d = request.getRequestDispatcher(url);
		d.forward(request, response);
		

	}

	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
	}

}
