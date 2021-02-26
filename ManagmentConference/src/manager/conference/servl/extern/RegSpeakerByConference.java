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
import manegment.conference.classes.Conference;
import manegment.conference.classes.PropConference;
import manegment.conference.classes.Speech;
import manegment.conference.classes.User;

/**
 * Servlet implementation class RegSpeakerByConference
 */
@WebServlet("/regspeakerbyconference")
public class RegSpeakerByConference extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegSpeakerByConference() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
		ConferenceDaoImpl conferenceDaoImpl = new ConferenceDaoImpl();
		UserConferenceDaoImpl userConferenceDaoImpl = new UserConferenceDaoImpl();
		SpeechDaoImpl speachDaoImpl = new SpeechDaoImpl();
		List<PropConference> propConferences = new ArrayList<>();
		try {
			List<Speech> speaches = speachDaoImpl.getSpeachesByLogSpkr(user.getLogin());
			List<Conference> conferences = conferenceDaoImpl.getAllConferences();
			RequestDispatcher rd = null;
			for (int i = 0; i < conferences.size(); i++) {
				if(request.getParameter(conferences.get(i).getCode()) != null) {
						userConferenceDaoImpl.regUser(user, conferences.get(i).getCode());
					
				}
				if(userConferenceDaoImpl.checkUser(user, conferences.get(i).getCode())) {
					propConferences.add(new PropConference(conferences.get(i), true));
				} else {
					propConferences.add(new PropConference(conferences.get(i), false));
				}
			}
			request.setAttribute("speaches", speaches);
			request.setAttribute("propConferences", propConferences);
			request.setAttribute("conferences", conferences);
			rd = request.getRequestDispatcher("speaker.jsp");
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
