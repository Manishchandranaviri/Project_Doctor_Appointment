


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class PatientDelete {
	
	public static void PDelete() throws Exception {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Patient id to delete the record:- ");
		int u_id=sc.nextInt();
		
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/Project_Doctor", "root","Manish@#2002");
		Statement st=con.createStatement();
		String deleteQuery="delete from PatientDetails "
				+ "where PatientId = "+u_id+";";
		int res=st.executeUpdate(deleteQuery);
		
		if(res == 0) {
			System.out.println("Record not deleted!!!");
		}else {
			System.out.println("Record deleted succesfully");
		}
		st.close();
		con.close();
		//sc.close();
	}
}
