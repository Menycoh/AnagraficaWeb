import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * Servlet implementation class ServletForm
 */
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

/**

@see HttpServlet#HttpServlet() */ public FormServlet() { super(); // TODO Auto-generated constructor stub }
}	
	/**
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//response.getWriter().append("Served at: ").append(request.getContextPath());
		String nome = request.getParameter("name");
		String email = request.getParameter("email");
		String messaggio = request.getParameter("message");

// Recupera il valore della checkbox  
		String termsAccepted = request.getParameter("terms");

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><title>Ciao!</title></head>");
		out.println("<body>");
		out.println("<h1>Ciao " + nome + "</h1>");
		out.println("<h1>La mia e-mail e' : " + email + "</h1>");
		out.println("<p>message : " + messaggio + "</p>");
		out.println("<div>accepted terms : " + termsAccepted + "</div>");
		out.println("</body>");
		out.println("</html>");

	}

	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//response.getWriter().append("Served at: ").append(request.getContextPath());
		String nome = request.getParameter("name");
		String email = request.getParameter("email");
		String messaggio = request.getParameter("message");

		// Recupera il valore della checkbox
		String termsAccepted = request.getParameter("terms");

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><title>Ciao!</title></head>");
		out.println("<body>");
		out.println("<h1>Ciao " + nome + "</h1>");
		out.println("<h1>La mia e-mail e' : " + email + "</h1>");
		out.println("<p>message : " + messaggio + "</p>");
		out.println("<div>accepted terms : " + termsAccepted + "</div>");
		out.println("<p>...sono nel doPost</p>");
		out.println("</body>");
		out.println("</html>");

	}

}