package manager.conference.servl.extern;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managment.conference.db.daoImpl.UserDaoImpl;
import manegment.conference.classes.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registrationservlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		String login = request.getParameter("login");
		String password = request.getParameter("pass");
		String email = request.getParameter("email");
		try {
			RequestDispatcher rd = null;
			if(userDaoImpl.checkLoginEmail(login, email)){
				rd = request.getRequestDispatcher("registry.jsp");
				request.setAttribute("Error", "Such login or email is already exist");
			}else {
				userDaoImpl.addUser(new User(login, password, email, "user"));
				rd = request.getRequestDispatcher("login.jsp");
			}
			rd.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
