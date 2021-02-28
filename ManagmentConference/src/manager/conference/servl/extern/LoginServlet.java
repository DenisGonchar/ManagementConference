package manager.conference.servl.extern;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
import manegment.conference.entity.PropConference;
import manegment.conference.entity.Speech;
import manegment.conference.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		UserConferenceDaoImpl userConferenceDaoImpl = new UserConferenceDaoImpl();
		SpeechDaoImpl speachDaoImpl = new SpeechDaoImpl();
		List<PropConference> propConferences = new ArrayList<>();
		String login = request.getParameter("login");
		String password = request.getParameter("pass");
		HttpSession session = request.getSession();
		String language = (String) session.getAttribute("language");
		try {
			User user = userDaoImpl.checkUser(new User(login, password, "", ""));
			RequestDispatcher rd = null;
			if(user != null) {
				switch (user.getRolle()){
				case "moderator":
					rd = request.getRequestDispatcher(language.equals("en")?"admin.jsp":"adminRUS.jsp");
					List<User> users = userDaoImpl.getAllUsers();
					request.setAttribute("users", users);
					List<User> speakers = speakerDaoImpl.getAllSpeakers();
					request.setAttribute("speakers", speakers);
					List<Speech> speaches = speachDaoImpl.getAllSpeaches();
					request.setAttribute("speaches", speaches);
					List<Conference> conferences = conferenceDaoImpl.getAllConferences();
					request.setAttribute("conferences", conferences);
					break;
				case "speaker":
					rd = request.getRequestDispatcher(language.equals("en")?"speaker.jsp":"speakerRUS.jsp");
					speaches = speachDaoImpl.getSpeachesByLogSpkr(login);
					conferences = conferenceDaoImpl.getAllConferences();
					for (int i = 0; i < conferences.size(); i++) {
						if (userConferenceDaoImpl.checkUser(user, conferences.get(i).getCode())) {
							propConferences.add(new PropConference(conferences.get(i), true));
						} else {
							propConferences.add(new PropConference(conferences.get(i), false));
						}
					}
					request.setAttribute("speaches", speaches);
					request.setAttribute("propConferences", propConferences);
					request.setAttribute("conferences", conferences);
					break;
				case "user":
					rd = request.getRequestDispatcher(language.equals("en")?"user.jsp":"userRUS.jsp");
					conferences = conferenceDaoImpl.getAllConferences();
					for (int i = 0; i < conferences.size(); i++) {
						if (userConferenceDaoImpl.checkUser(user, conferences.get(i).getCode())) {
							propConferences.add(new PropConference(conferences.get(i), true));
						} else {
							propConferences.add(new PropConference(conferences.get(i), false));
						}
					}
					request.setAttribute("propConferences", propConferences);
					request.setAttribute("conferences", conferences);
					break;
				}
				session.setAttribute("user", user);
			}else {
				rd = request.getRequestDispatcher(language.equals("en")?"login.jsp":"loginRUS.jsp");
				request.setAttribute("Error", "Incorrect login or password");
			}
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
