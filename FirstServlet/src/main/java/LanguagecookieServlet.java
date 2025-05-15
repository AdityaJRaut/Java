
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LanguagecookieServlet
 */
@WebServlet("/LanguagecookieServlet")
public class LanguagecookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LanguagecookieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Cookie cookies[] = request.getCookies();
		String value = request.getParameter("selectvalue").toLowerCase();
		if (cookies == null) {
			Cookie cookie = new Cookie("language", value);
			response.addCookie(cookie);
		} else {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase("language")) {
					if (cookie.getValue().equalsIgnoreCase(value)) {
						out.print("Cookie already present for language " + value);

					} else {
						cookie.setValue(value);
						response.addCookie(cookie);
						out.print("Cookie updated to " + value);

					}
				}
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
