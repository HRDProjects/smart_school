package controller.update;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.ClassEnroll;

/**
 * Servlet implementation class InsertSubject
 */
@WebServlet("/admin/updateStudentEnroll.hrd")
public class UpdateStudentEnroll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateStudentEnroll() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		try {
			doProcess(request, response);
		} catch (IOException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			doProcess(request, response);
		} catch (IOException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ClassNotFoundException, SQLException {

		// create dto
		model.dto.StudentEnroll dto = new model.dto.StudentEnroll();
		dto.setStu_enroll(Integer.parseInt(request.getParameter("stu_enroll")));
		dto.setStu_id(Integer.parseInt(request.getParameter("stu_id")));
		dto.setClass_id(Integer.parseInt(request.getParameter("class_id")));
		dto.setDescription(request.getParameter("description"));
		if (new model.update.UpdateEnroll().updateStudentEnroll(dto)) {
			response.getWriter().write("Success");
			return;
		}

		response.getWriter().write("Fail");
	}

}
