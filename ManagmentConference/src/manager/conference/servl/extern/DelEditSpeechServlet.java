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

import managment.conference.db.daoImpl.SpeechDaoImpl;
import managment.conference.db.daoImpl.SpeechesConferenceDaoImpl;
import manegment.conference.classes.Conference;
import manegment.conference.classes.Speech;

/**
 * Servlet implementation class ChangeSpeechServlet
 */
@WebServlet("/deleditspeechservlet")
public class DelEditSpeechServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelEditSpeechServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SpeechDaoImpl speachDaoImpl = new SpeechDaoImpl();
		SpeechesConferenceDaoImpl speechesConferenceDaoImpl = new SpeechesConferenceDaoImpl();
		HttpSession session = request.getSession();
		Conference conference = (Conference) session.getAttribute("conference");
		String language = (String) session.getAttribute("language");
		String page = null;
		try {
			List<Speech> speaches = speachDaoImpl.getSpeachbyConference(conference);	
			RequestDispatcher rd = null;
			for (int i = speaches.size()-1; i >= 0 ; i--) {
				String code = speaches.get(i).getCode();
				if(request.getParameter("d" + code) != null) {
					page = language.equals("en")?"setSpeaches.jsp":"setSpeachesRUS.jsp";
					speachDaoImpl.removeSpeech(code);
					speaches.remove(i);
					speechesConferenceDaoImpl.delSpeachConfByCodeSpeach(code);
					break;
				}
				if (request.getParameter("ch" + code) != null) {
					page = language.equals("en")?"setAllParametersSpeakerSpeaches.jsp":"setAllParametersSpeakerSpeachesRUS.jsp";
					session.setAttribute("speach", speaches.get(i));
					break;
				}
			}
			rd = request.getRequestDispatcher(page);
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
