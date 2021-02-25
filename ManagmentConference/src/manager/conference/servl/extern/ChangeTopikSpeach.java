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
import manegment.conference.classes.Conference;
import manegment.conference.classes.Speach;
import manegment.conference.classes.User;

/**
 * Servlet implementation class ChangeTopikSpeach
 */
@WebServlet("/changetopikspeach")
public class ChangeTopikSpeach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeTopikSpeach() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SpeachDaoImpl speachDaoImpl = new SpeachDaoImpl();
		ConferenceDaoImpl conferenceDaoImpl = new ConferenceDaoImpl();
		String topic = request.getParameter("topic");
		HttpSession session = request.getSession();
		Speach speach = (Speach) session.getAttribute("speach");
		User user = (User) session.getAttribute("user");
		try {
			List<Conference> conferences = conferenceDaoImpl.getAllConferences();		
			speachDaoImpl.changeTopic(topic, speach.getCode());
			System.out.println(topic);
			List<Speach> speaches = speachDaoImpl.getSpeachesByLogSpkr(user.getLogin());
			RequestDispatcher rd = request.getRequestDispatcher("speaker.jsp");
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
