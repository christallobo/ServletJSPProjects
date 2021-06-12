import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		String name = "Reena";
//		req.setAttribute("label", name);

//		Student s = new Student(11, "Reena");
//		req.setAttribute("student", s);

		List<Student> studs = Arrays.asList(new Student(1, "Suman"), new Student(2, "Reema"),
				new Student(3, "Teena"));
		req.setAttribute("students", studs);
		
		RequestDispatcher rd = req.getRequestDispatcher("display.jsp");
		rd.forward(req, res);
	}
}
