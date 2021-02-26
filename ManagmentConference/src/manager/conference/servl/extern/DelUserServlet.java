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

import managment.conference.db.daoImpl.ConferenceDaoImpl;
import managment.conference.db.daoImpl.SpeechDaoImpl;
import managment.conference.db.daoImpl.SpeechesConferenceDaoImpl;
import managment.conference.db.daoImpl.UserConferenceDaoImpl;
import managment.conference.db.daoImpl.UserDaoImpl;
import manegment.conference.classes.Conference;
import manegment.conference.classes.Speech;
import manegment.conference.classes.User;

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
		SpeechesConferenceDaoImpl speachesConferenceDaoImpl = new SpeechesConferenceDaoImpl();
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
					for (int j = 0; j < speaches.size(); j++) {
						//speachesConferenceDaoImpl.delSpeachConfByCodeSpeach(speaches.get(j).getCode());
						
					}
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
			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
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
