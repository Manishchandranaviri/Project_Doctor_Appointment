
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class PatientInsert {
	
	public static void PInsert() throws Exception {
		
		Scanner sc=new Scanner(System.in);
		
		
		System.out.println("Could U please Enter Patient name:- ");
		String u_name= sc.next();
		System.out.println("Could U please Enter age of the patient:- ");
		int u_age = sc.nextInt();
		System.out.println("Could U please Enter the gender of the Patient (Male/Female):- ");
		String u_gen = sc.next();

		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/Project_Doctor", "root","Manish@#2002");
		Statement st=con.createStatement();
		String insertQuery="insert into PatientDetails(PatientName,PatientAge,PatientGender) "
				+ "values('"+u_name+"',"+u_age+",'"+u_gen+"');";
		int res=st.executeUpdate(insertQuery);
		
		if(res == 0) {
			System.out.println("\nRecord not inserted\n");
		}else {
			System.out.println("\nRecord inserted succesfully\n");
			System.out.println("\nThanks for entering details \n");
		}
		st.close();
		con.close();
		//sc.close();
	}

}
