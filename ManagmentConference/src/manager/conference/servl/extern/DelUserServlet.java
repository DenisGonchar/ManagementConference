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
import managment.conference.db.daoImpl.SpeachDaoImpl;
import managment.conference.db.daoImpl.UserDaoImpl;
import manegment.conference.classes.Conference;
import manegment.conference.classes.Speach;
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
		SpeachDaoImpl speachDaoImpl = new SpeachDaoImpl();
		ConferenceDaoImpl conferenceDaoImpl = new ConferenceDaoImpl();
		try {
			List<User> users = userDaoImpl.getAllUsers();
			List<User> speakers = speakerDaoImpl.getAllSpeakers();
			List<Conference> conferences = conferenceDaoImpl.getAllConferences();
			List<Speach> speaches = speachDaoImpl.getAllSpeaches();
			for (int i = users.size()-1; i >= 0; i--) {
				String login = users.get(i).getLogin();
				if (request.getParameter(login) != null) {
					userDaoImpl.removeUser(users.get(i));
					users.remove(i);
				}
			}
			for (int i = speakers.size()-1; i >= 0; i--) {
				String login = speakers.get(i).getLogin();
				if (request.getParameter(login) != null) {
					speakerDaoImpl.removeUser(speakers.get(i));
					speakers.remove(i);
					System.out.println("Error here");
				}
			}
			
			
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
