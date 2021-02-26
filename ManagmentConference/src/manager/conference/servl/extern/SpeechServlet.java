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
import manegment.conference.classes.Conference;
import manegment.conference.classes.Speech;
import manegment.conference.classes.User;
/**
 * Servlet implementation class SpeachServlet
 */
@WebServlet("/speachservlet")
public class SpeechServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpeechServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	SpeechDaoImpl speachDaoImpl = new SpeechDaoImpl();
		ConferenceDaoImpl conferenceDaoImpl = new ConferenceDaoImpl();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String page = null;
		try {
			List<Speech> speaches = speachDaoImpl.getSpeachesByLogSpkr(user.getLogin());
			List<Conference> conferences = conferenceDaoImpl.getAllConferences();		
			RequestDispatcher rd = null;
			for (int i = speaches.size()-1; i >= 0 ; i--) {
				String code = speaches.get(i).getCode();
				if(request.getParameter("d" + code) != null) {
					page = "speaker.jsp";
					speachDaoImpl.changeLogin("freeSpeaker", code);
					speaches.remove(i);
					break;
				}
				if (request.getParameter("e" + code) != null) {
					page = "setSpeakerSpeaches.jsp";
					session.setAttribute("speach", speaches.get(i));
					break;
				}
			}
			rd = request.getRequestDispatcher(page);
			request.setAttribute("conferences", conferences);
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
