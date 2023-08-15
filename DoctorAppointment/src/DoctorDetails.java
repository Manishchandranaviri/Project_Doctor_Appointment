

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DoctorDetails {
	
	
	public static void RetrieveDetails() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/Project_Doctor", "root","Manish@#2002");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from DoctorDetails;");
		
		while(rs.next()) {
			System.out.println(rs.getInt("DoctorID")+" "+rs.getString("DoctorName")+" "+
		        rs.getString("DoctorQualification")+" "+rs.getString("DoctorDepartment")+" "+
					rs.getInt("DoctorRoomNumber")+" "+ rs.getString("PhoneNumber")+" "+rs.getString("WorkingHours"));
			
		}
		
		System.out.println("\n");
		st.close();
		con.close();

	}

}
