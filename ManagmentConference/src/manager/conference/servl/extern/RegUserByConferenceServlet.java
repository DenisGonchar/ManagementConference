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
import managment.conference.db.daoImpl.UserConferenceDaoImpl;
import manegment.conference.entity.Conference;
import manegment.conference.entity.PropConference;
import manegment.conference.entity.User;

/**
 * Servlet implementation class RegUserByConference
 */
@WebServlet("/reguserbyconference")
public class RegUserByConferenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegUserByConferenceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		ConferenceDaoImpl conferenceDaoImpl = new ConferenceDaoImpl();
		UserConferenceDaoImpl userConferenceDaoImpl = new UserConferenceDaoImpl();
		List<PropConference> propConferences = new ArrayList<>();
		String language = (String) session.getAttribute("language");
		try {
			List<Conference> conferences = conferenceDaoImpl.getAllConferences();
			RequestDispatcher rd = null;
			for (int i = 0; i < conferences.size(); i++) {
				if(request.getParameter("r" + conferences.get(i).getCode()) != null) {
					if(!userConferenceDaoImpl.checkUser(user, conferences.get(i).getCode())) {
						userConferenceDaoImpl.regUser(user, conferences.get(i).getCode());
					}
				}
				if(request.getParameter("u" + conferences.get(i).getCode()) != null) {
						userConferenceDaoImpl.unRegUser(user, conferences.get(i).getCode());
				}
				if(userConferenceDaoImpl.checkUser(user, conferences.get(i).getCode())) {
					propConferences.add(new PropConference(conferences.get(i), true));
				} else {
					propConferences.add(new PropConference(conferences.get(i), false));
				}
			}
			request.setAttribute("propConferences", propConferences);
			request.setAttribute("conferences", conferences);
			rd = request.getRequestDispatcher(language.equals("en")?"user.jsp":"userRUS.jsp");
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
