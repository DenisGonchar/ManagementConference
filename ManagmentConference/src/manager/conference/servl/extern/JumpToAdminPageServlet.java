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

import managment.conference.db.daoImpl.ConferenceDaoImpl;
import managment.conference.db.daoImpl.SpeechDaoImpl;
import managment.conference.db.daoImpl.UserDaoImpl;
import manegment.conference.entity.Conference;
import manegment.conference.entity.Speech;
import manegment.conference.entity.User;

/**
 * Servlet implementation class StartPageServlet
 */
@WebServlet("/jumptoadminpageservlet")
public class JumpToAdminPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JumpToAdminPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		UserDaoImpl speakerDaoImpl = new UserDaoImpl();
		ConferenceDaoImpl conferenceDaoImpl = new ConferenceDaoImpl();
		SpeechDaoImpl speachDaoImpl = new SpeechDaoImpl();
		HttpSession session = request.getSession();
		String language = (String) session.getAttribute("language");
		RequestDispatcher rd = request.getRequestDispatcher(language.equals("en")?"admin.jsp":"adminRUS.jsp");
		List<User> users;
		try {
			users = userDaoImpl.getAllUsers();
			request.setAttribute("users", users);
			List<User> speakers = speakerDaoImpl.getAllSpeakers();
			request.setAttribute("speakers", speakers);
			List<Speech> speaches = speachDaoImpl.getAllSpeaches();
			request.setAttribute("speaches", speaches);
			List<Conference> conferences = conferenceDaoImpl.getAllConferences();
			request.setAttribute("conferences", conferences);
			rd.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
	}

}
