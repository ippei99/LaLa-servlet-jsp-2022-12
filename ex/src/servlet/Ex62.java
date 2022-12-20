package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex62")
public class Ex62 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		
		// int r = new Random().nextInt(10);
		int r =  (int) (Math.random() * 10);
		
		Integer number = r;
		request.setAttribute("number", number);
		
		if(r % 2 == 1) {
			response.sendRedirect("/ex/redirected.jsp");
		} else {
			String url = "/forwarded.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
}
