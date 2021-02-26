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
 * Servlet implementation class AddNewSpeachServlet
 */
@WebServlet("/addnewspeachservlet")
public class AddNewSpeechServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewSpeechServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SpeechDaoImpl speachDaoImpl = new SpeechDaoImpl();
		SpeechesConferenceDaoImpl speachesConferenceDaoImpl = new SpeechesConferenceDaoImpl();
		HttpSession session = request.getSession();
		String nameSpeach = request.getParameter("nameSpeach");
		String time = request.getParameter("time");
		String interval = request.getParameter("interval");
		try {
			List<Speech> speaches = speachDaoImpl.getAllSpeaches();
			String code = "H" + (Integer.parseInt(speaches.get(speaches.size()-1).getCode().substring(1))+1);
			speachDaoImpl.addSpeach(new Speech(nameSpeach, time, interval, "freeSpeaker", code));
			Conference conference = (Conference) session.getAttribute("conference");
			speachesConferenceDaoImpl.addSpeachConf(conference.getCode(), code);
			speaches = speachDaoImpl.getSpeachbyConference(conference);
			request.setAttribute("speaches", speaches);
			RequestDispatcher rd = request.getRequestDispatcher("setSpeaches.jsp");
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
