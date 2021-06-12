import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDaoDemo {
	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();
//		Student s = dao.getStudent(11);
//		System.out.println(s.sname);

		Student s2 = new Student();
		s2.rollno = 14;
		s2.sname = "Teena";
		dao.connect();
		dao.addStudent(s2);
	}
}

class StudentDAO {

	Connection con = null;

	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Student getStudent(int rollno) {
		try {
			String query = "select sname from student where rollno=" + rollno;

			Student s = new Student();
			s.rollno = rollno;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			String name = rs.getString(1);
			s.sname = name;
			return s;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public void addStudent(Student s) {
		try {
			String query = "insert into student values (?,?)";

			PreparedStatement st=con.prepareStatement(query);
			st.setInt(1, s.rollno);
			st.setString(2, s.sname);
			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class Student {
	int rollno;
	String sname;
}