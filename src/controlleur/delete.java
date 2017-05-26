package controlleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import DAO.ContactDAO;

      /*Servlet for adding new project in our dataBase and redirect to ShowProject*/

public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
        int idContact= Integer.parseInt(request.getParameter("idContact"));
		ContactDAO p = new ContactDAO();
		p.deleteProject(idContact);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListContact.jsp");
		rd.forward(request, response);

}

}
