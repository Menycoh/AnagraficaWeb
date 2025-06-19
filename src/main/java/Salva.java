import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

/**
 * 
 * Servlet implementation class Salva
 */
@WebServlet("/salva")
public class Salva extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public Salva() {
		super(); // TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
// request.getMethod()
		response.getWriter().append(" - Method : " + request.getMethod());
// request.getContexPath()
		response.getWriter().append(" - ContextPath : " + request.getContextPath() + "\n");
// request.getHeader()
		response.getWriter().append(" - getHeader : " + request.getHeader("user-agent") + "\n");
		response.getWriter().append(" - getHeader : " + request.getHeader("sec-ch-ua-platform") + "\n");
// request.getHeaderName()
		Enumeration<String> en = request.getHeaderNames();
// request.getParameter() - restituisce il valore del parametro o inviati in
// query string
// nel caso di chiamate get o inviati dal body nel caso di chiamate post
		response.getWriter().append(" - getParameter : " + request.getParameter("pagina"));

		while (en.hasMoreElements()) {
			String element = en.nextElement();
			response.getWriter().append(" - " + element + ": " + request.getHeader(element) + "\n");
		}
		// request.getParameter() - restituisce il valore del parametro o inviati in
		// query string
		// nel caso di chiamate get o inviati dal body nel caso di chiamate post
		response.getWriter().append(" - getParameter : " + request.getParameter("pagina"));

		Map<String, String[]> parameterMap = request.getParameterMap();

		// Itera attraverso i parametri e aggiungi ogni coppia chiave-valore alla
		// risposta
		for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
			String key = entry.getKey();
			String[] values = entry.getValue();

			for (String value : values) {
				response.getWriter().append(" - getParameterMap : " + key + "=" + value + "\n");
			}

		} // stampa tutti i valori della variabile params
		String[] params = request.getParameterValues("pagina");
		if (params != null) {
			for (String s : params) {
				response.getWriter().append(" - getParameter : " + s + "\n");

			}
		} else {
			response.getWriter().append("Attributo non trovato");
		}
	}

	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// TODO Auto-generated method stub
		doGet(request, response);
	}

}