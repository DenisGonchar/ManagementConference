package manager.conference.servl.extern;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import managment.conference.db.daoImpl.SpeachDaoImpl;
import managment.conference.db.daoImpl.UserDaoImpl;
import manegment.conference.classes.Speach;
import manegment.conference.classes.User;

/**
 * Servlet implementation class FromUserToSpeakerServlet
 */
@WebServlet("/fromusertospeakerservlet")
public class FromUserToSpeakerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FromUserToSpeakerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		SpeachDaoImpl speachDaoImpl = new SpeachDaoImpl();
		String page = null;
		HttpSession session = request.getSession();
		try {
			List<User> users = userDaoImpl.getAllUsers();
			List<User> speakers = userDaoImpl.getAllSpeakers();
			List<Speach> speaches = speachDaoImpl.getAllSpeaches();
			for (int i = users.size()-1; i >= 0; i--) {
				page = "usersSettings.jsp";
				session.setAttribute("users", users.get(i));
			}
			request.setAttribute("users", users);
			request.setAttribute("speakers", speakers);
			request.setAttribute("speaches", speaches);
			RequestDispatcher rd = request.getRequestDispatcher(page);
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
