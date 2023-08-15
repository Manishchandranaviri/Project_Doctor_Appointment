


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PatientDetails {
	
	
	public static void PDetails() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/Project_Doctor", "root","Manish@#2002");
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		//System.out.println("Enter Patient id:- ");
		//int u_id=sc.nextInt();
		
		ResultSet rs=st.executeQuery("select * from PatientDetails;");
		
		while(rs.next()) {
			System.out.println(rs.getInt("Patientid")+" "+rs.getString("PatientName")+" "+
		        rs.getInt("patientAge")+" "+rs.getString("patientGender"));
			
		}
		st.close();
		con.close();

	}
	
	public static void PSingleDetails() throws Exception {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/Project_Doctor", "root","Manish@#2002");
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Patient id:- ");
		int u_id=sc.nextInt();
		
		ResultSet rs=st.executeQuery("select * from PatientDetails where PatientId ="+u_id+";");
		
		
		while(rs.next()) {
			System.out.println(rs.getInt("Patientid")+" "+rs.getString("patientName")+" "+
					rs.getInt("patientAge")+" "+rs.getString("patientGender"));
			
		}
		System.out.println("\n");
		st.close();
		con.close();
		
	}

}
