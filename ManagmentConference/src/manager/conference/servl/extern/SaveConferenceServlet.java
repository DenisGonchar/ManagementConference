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
 * Servlet implementation class SaveConferenceServlet
 */
@WebServlet("/saveconferenceservlet")
public class SaveConferenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveConferenceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConferenceDaoImpl conferenceDaoImpl = new ConferenceDaoImpl();
		SpeechDaoImpl speachDaoImpl = new SpeechDaoImpl();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		HttpSession session = request.getSession();
		Conference conference = (Conference) session.getAttribute("conference");
		conference.setNameConf(request.getParameter("nameConf"));
		conference.setPlace(request.getParameter("place"));
		conference.setDate(request.getParameter("date"));
		conference.setTime(request.getParameter("time"));
		String language = (String) session.getAttribute("language");
		try {
			conferenceDaoImpl.updateConference(conference);
			RequestDispatcher rd = request.getRequestDispatcher(language.equals("en")?"admin.jsp":"adminRUS.jsp");
			List<User> users = userDaoImpl.getAllUsers();
			List<User> speakers = userDaoImpl.getAllSpeakers();
			List<Conference> conferences = conferenceDaoImpl.getAllConferences();
			List<Speech> speaches = speachDaoImpl.getAllSpeaches();
			request.setAttribute("conferences", conferences);
			request.setAttribute("users", users);
			request.setAttribute("speakers", speakers);
			request.setAttribute("speaches", speaches);
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
