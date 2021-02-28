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
import manegment.conference.entity.Conference;
import manegment.conference.entity.PropConference;
import manegment.conference.entity.Speech;
import manegment.conference.entity.User;

/**
 * Servlet implementation class ChangeTopikSpeach
 */
@WebServlet("/changetopikspeach")
public class ChangeTopikSpeechServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeTopikSpeechServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SpeechDaoImpl speachDaoImpl = new SpeechDaoImpl();
		ConferenceDaoImpl conferenceDaoImpl = new ConferenceDaoImpl();
		UserConferenceDaoImpl userConferenceDaoImpl = new UserConferenceDaoImpl();
		String topic = request.getParameter("topic");
		HttpSession session = request.getSession();
		Speech speach = (Speech) session.getAttribute("speach");
		User user = (User) session.getAttribute("user");
		String language = (String) session.getAttribute("language");
		try {
			List<Conference> conferences = conferenceDaoImpl.getAllConferences();
			List<PropConference> propConferences = new ArrayList<>();
			speachDaoImpl.changeTopic(topic, speach.getCode());
			List<Speech> speaches = speachDaoImpl.getSpeachesByLogSpkr(user.getLogin());
			RequestDispatcher rd = request.getRequestDispatcher(language.equals("en")?"speaker.jsp":"speakerRUS.jsp");
			for (int i = 0; i < conferences.size(); i++) {
				if (userConferenceDaoImpl.checkUser(user, conferences.get(i).getCode())) {
					propConferences.add(new PropConference(conferences.get(i), true));
				} else {
					propConferences.add(new PropConference(conferences.get(i), false));
				}
			}
			request.setAttribute("propConferences", propConferences);
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
