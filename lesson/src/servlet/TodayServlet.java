package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Today")
public class TodayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		// 今日の日付を取得
//		Date date = new Date();
//		// 日付表示のフォーマットを準備
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
//      // 取得した日付をフォーマットにセットしてtodayに代入
//		String today = sdf.format(date);
		
        // 今日の日付を取得
		LocalDate now = LocalDate.now();
		// 日付表示のパターンを準備
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        // 今日の日付をパターンにセットしてtodayに代入
		String today = dtf.format(now);
	
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>今日は何日</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>今日は" + today + "です。</p>");
		out.println("</body>");
		out.println("</html>");


	}

}
