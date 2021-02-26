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
import managment.conference.db.daoImpl.UserDaoImpl;
import manegment.conference.classes.Conference;
import manegment.conference.classes.Speech;
import manegment.conference.classes.User;

/**
 * Servlet implementation class RegistrationConfServlet
 */
@WebServlet("/registrationconfservlet")
public class RegistrationConfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationConfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConferenceDaoImpl conferenceDaoImpl = new ConferenceDaoImpl();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		SpeechDaoImpl speachDaoImpl = new SpeechDaoImpl();
		String nameConf = request.getParameter("nameConf");
		String place = request.getParameter("place");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		Conference conference = new Conference(nameConf, place, date, time, "");
		try {
			List<Conference> conferences = conferenceDaoImpl.getAllConferences();
			List<User> users = userDaoImpl.getAllUsers();
			List<User> speakers = userDaoImpl.getAllSpeakers();
			List<Speech> speaches = speachDaoImpl.getAllSpeaches();
			Conference lastConference = conferences.get(conferences.size()-1);
			conference.setCode("C" + (Integer.parseInt(lastConference.getCode().substring(1))+1));
			RequestDispatcher rd = null;
			conferenceDaoImpl.addConference(conference);
			conferences = conferenceDaoImpl.getAllConferences();
			rd = request.getRequestDispatcher("admin.jsp");
			request.setAttribute("conferences", conferences);
			request.setAttribute("users", users);
			request.setAttribute("speakers", speakers);
			request.setAttribute("speaches", speaches);
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
