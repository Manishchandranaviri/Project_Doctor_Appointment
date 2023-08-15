


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class PatientModify {
	
	public static void PModify() throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("--------------MODIFY PATIENT DETAILS-------------- ");
		System.out.println("1. Change Name ");
		System.out.println("2. Change Age ");
		System.out.println("3. Change Gender");
		//System.out.println("4. Change Mobile Number");
		System.out.println("0. Exit\n");
		
		System.out.println("Enter your choice: ");
		int ch = sc.nextInt();
		int u_id;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/Project_Doctor", "root","Manish@#2002");
		Statement st=con.createStatement();
		
		switch(ch)
		{
		 	case 1:
		 		System.out.println("Enter Patient Id: ");
				u_id=sc.nextInt();
		 		System.out.println("Enter Patient name:- ");
				String u_name= sc.next();
		 		String ModNameQuery=" update PatientDetails set PatientName = '"+ u_name+"'where PatientId ="+u_id+";";
		 		int res1=st.executeUpdate(ModNameQuery);
				
				if(res1 == 0) {
					System.out.println("Record not updated\n");
				}else {
					System.out.println("Record updated succesfully\n");
				}
		 		break;
			
		 	case 2:
		 		System.out.println("Enter Patient Id: ");
				u_id=sc.nextInt();
		 		System.out.println("Enter Patient's Age:- ");
				int u_age= sc.nextInt();
		 		String ModAgeQuery=" update PatientDetails set PatientAge = "+ u_age+" where PatientId ="+u_id+";";
		 		int res2=st.executeUpdate(ModAgeQuery);
				
				if(res2 == 0) {
					System.out.println("Recored not updated\n");
				}else {
					System.out.println("Recored updated succesfully\n");
				}
		 		break;
		 		
		 	case 3:
		 		System.out.println("Enter Patient Id: ");
				u_id=sc.nextInt();
		 		System.out.println("Enter Patient's Gender (Male/Female):- ");
				String u_gen= sc.next();
		 		String ModGenQuery=" update PatientDetails set PatientGender = '"+ u_gen+"'where PatientId ="+u_id+";";
		 		int res3=st.executeUpdate(ModGenQuery);
				
				if(res3 == 0) {
					System.out.println("Record not updated\n");
				}else {
					System.out.println("Record updated succesfully\n");
				}
		 		break;
		 		

		 		
		 	case 0:
		 		break;
		 		
		 	default:
		 		System.out.println("Invalid Choice!!!\n");
		}
		 		
		st.close();
		con.close();
		//sc.close();
	}

}

