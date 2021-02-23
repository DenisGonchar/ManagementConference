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

import managment.conference.db.daoImpl.SpeachDaoImpl;
import managment.conference.db.daoImpl.UserDaoImpl;
import manegment.conference.classes.Speach;
/**
 * Servlet implementation class SpeachServlet
 */
@WebServlet("/speachservlet")
public class SpeachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpeachServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SpeachDaoImpl speachDaoImpl = new SpeachDaoImpl();
		String nameSpeach = request.getParameter("nameSpeach");
		String time = request.getParameter("time");
		try {
			List<Speach> speaches = speachDaoImpl.getAllSpeaches();
			Speach speach = speachDaoImpl.checkSpeach(new Speach(nameSpeach, time, "", "", ""));
			RequestDispatcher rd = null;
			for (int i = 0; i < speaches.size(); i++) {
			if(speach != null) {
					speaches = speachDaoImpl.getSpeachesByLogSpkr(speaches.get(i).getLogin());
					rd = request.getRequestDispatcher("speaker.jsp");
					speaches = speachDaoImpl.getAllSpeaches();
					request.setAttribute("speaches", speaches);
				}else {
					rd = request.getRequestDispatcher("login.jsp");
					request.setAttribute("Error", "Incorrect login or password");
				}
			}
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
