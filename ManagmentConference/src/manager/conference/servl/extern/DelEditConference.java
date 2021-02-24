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
import managment.conference.db.daoImpl.SpeachDaoImpl;
import managment.conference.db.daoImpl.UserConferenceDaoImpl;
import managment.conference.db.daoImpl.UserDaoImpl;
import manegment.conference.classes.Conference;
import manegment.conference.classes.Speach;
import manegment.conference.classes.User;

/**
 * Servlet implementation class DelEditConference
 */
@WebServlet("/deleditconference")
public class DelEditConference extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelEditConference() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConferenceDaoImpl conferenceDaoImpl = new ConferenceDaoImpl();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		UserConferenceDaoImpl userConferenceDaoImpl = new UserConferenceDaoImpl();
		SpeachDaoImpl speachDaoImpl = new SpeachDaoImpl();
		String page = null;
		HttpSession session = request.getSession();
		try {
			List<Conference> conferences = conferenceDaoImpl.getAllConferences();
			List<User> users = userDaoImpl.getAllUsers();
			List<User> speakers = userDaoImpl.getAllSpeakers();
			List<Speach> speaches = speachDaoImpl.getAllSpeaches();
			for (int i = conferences.size()-1; i >= 0; i--) {
				String code = conferences.get(i).getCode();
				if(request.getParameter("d" + code) != null) {
					conferenceDaoImpl.removeConference(conferences.get(i));
					conferences.remove(i);
					page = "admin.jsp";
					break;
				}
				if (request.getParameter("e" + code) != null) {
					page = "regConferences.jsp";
					session.setAttribute("conference", conferences.get(i));
					break;
				}
				if (request.getParameter("s" + code) != null) {
					page = "showUser.jsp";
					users.clear();
					users = userConferenceDaoImpl.getUsersByCode(conferences.get(i).getCode());
					break;
				}	
				if (request.getParameter("set" + code) != null) {
					page = "setSpeaches.jsp";
					session.setAttribute("conference", conferences.get(i));
					speaches = speachDaoImpl.getSpeachbyConference(conferences.get(i));
					break;
				}
			}
			request.setAttribute("conferences", conferences);
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
