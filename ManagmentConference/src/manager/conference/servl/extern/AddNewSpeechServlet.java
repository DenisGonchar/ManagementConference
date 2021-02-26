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
    
    public String getNewCode(List<Speech> speeches) {
		int code = Integer.parseInt(speeches.get(0).getCode().substring(1));
		for (int i = 1; i < speeches.size(); i++) {
			int newcode =  Integer.parseInt(speeches.get(i).getCode().substring(1));
			if(newcode > code) {
				code = newcode;
			}
		}
    	return "H" + (code + 1);
    	
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
		String language = (String) session.getAttribute("language");
		try {
			List<Speech> speaches = speachDaoImpl.getAllSpeaches();
			String code = getNewCode(speaches);
			speachDaoImpl.addSpeach(new Speech(nameSpeach, time, interval, "freeSpeaker", code));
			Conference conference = (Conference) session.getAttribute("conference");
			speachesConferenceDaoImpl.addSpeachConf(conference.getCode(), code);
			speaches = speachDaoImpl.getSpeachbyConference(conference);
			request.setAttribute("speaches", speaches);
			RequestDispatcher rd = request.getRequestDispatcher(language.equals("en")?"setSpeaches.jsp":"setSpeachesRUS.jsp");
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
