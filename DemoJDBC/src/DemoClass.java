import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DemoClass {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/student";
		String user = "root";
		String password = "";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);

		//// Select--->DQL
//		String query = "select college from student where name='teena'";
		String query = "select * from student where rollno=11";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		rs.next();
//		while(rs.next()) {
			System.out.println(rs.getInt(1)+" : "+rs.getString(2));
//		}

		// Insert--->DML
//		String query = "insert into student values('reema','agnes')";

//		String name = "veena";
//		String college = "SIT";
//		String query = "insert into student values('" + name + "','" + college + "')";
//
//		Statement st = con.createStatement();
//		int count=st.executeUpdate(query);

//		String name = "maria";
//		String college = "canara";
//		String query = "insert into student values (?,?)";
//
//		PreparedStatement st = con.prepareStatement(query);
//		st.setString(1, name);
//		st.setString(2, college);
//
//		int count = st.executeUpdate();
//		System.out.println(count + " row/s effected.");

		st.close();
		con.close();
	}
}
