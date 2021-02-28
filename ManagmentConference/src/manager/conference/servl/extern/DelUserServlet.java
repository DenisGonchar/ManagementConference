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
import managment.conference.db.daoImpl.UserConferenceDaoImpl;
import managment.conference.db.daoImpl.UserDaoImpl;
import manegment.conference.entity.Conference;
import manegment.conference.entity.Speech;
import manegment.conference.entity.User;

/**
 * Servlet implementation class DelUserServlet
 */
@WebServlet("/deluserservlet")
public class DelUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		UserDaoImpl speakerDaoImpl = new UserDaoImpl();
		SpeechDaoImpl speachDaoImpl = new SpeechDaoImpl();
		ConferenceDaoImpl conferenceDaoImpl = new ConferenceDaoImpl();
		UserConferenceDaoImpl userConferenceDaoImpl = new UserConferenceDaoImpl();
		HttpSession session = request.getSession();
		String language = (String) session.getAttribute("language");
		try {
			List<User> users = userDaoImpl.getAllUsers();
			List<User> speakers = speakerDaoImpl.getAllSpeakers();
			List<Conference> conferences = conferenceDaoImpl.getAllConferences();
			List<Speech> speaches = speachDaoImpl.getAllSpeaches();
			for (int i = users.size()-1; i >= 0; i--) {
				String login = users.get(i).getLogin();
				if (request.getParameter(login) != null) {
					userDaoImpl.removeUser(users.get(i));
					userConferenceDaoImpl.delUser(users.get(i));
					users.remove(i);
				}
				if (request.getParameter("gts" + login) != null) {
					userDaoImpl.setRolle(userDaoImpl.getUserByLogin(users.get(i).getLogin()), "speaker");
				}
			}
			for (int i = speakers.size()-1; i >= 0; i--) {
				String login = speakers.get(i).getLogin();
				if (request.getParameter(login) != null) {
					speaches = speachDaoImpl.getSpeachesByLogSpkr(speakers.get(i).getLogin());
					speachDaoImpl.changeAllLogin("freeSpeaker", login);
					userConferenceDaoImpl.delUser(speakers.get(i));
					speakerDaoImpl.removeUser(speakers.get(i));
					speakers.remove(i);
				}
				if (request.getParameter("gtu" + login) != null) {
					speakerDaoImpl.setRolle(speakerDaoImpl.getUserByLogin(speakers.get(i).getLogin()), "user");
				}
			}
			users = userDaoImpl.getAllUsers();
			speakers = speakerDaoImpl.getAllSpeakers();
			request.setAttribute("users", users);
			request.setAttribute("speakers", speakers);
			request.setAttribute("conferences", conferences);
			request.setAttribute("speaches", speaches);
			RequestDispatcher rd = request.getRequestDispatcher(language.equals("en")?"admin.jsp":"adminRUS.jsp");
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
