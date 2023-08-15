

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Appointment {
	
	
	public static void AppInsert() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/Project_Doctor", "root","Manish@#2002");
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Patient id:- ");
		int p_id=sc.nextInt();
		
		System.out.println("Enter Doctor id:- ");
		int d_id=sc.nextInt();
		
		System.out.println("Enter Date of Appointment (DD/MM/YY) :- ");
		String a_date=sc.next();
		
		System.out.println("Enter Time of Appointment (Eg: 10am or 10:30am) :- ");
		String a_time = sc.next();
		
		String insertQuery="insert into Appointment (PatientId,DoctorId,AppointmentDate,AppointmentTime)"
				+ "values("+p_id+","+d_id+",'"+a_date+"','"+a_time+"');";
		int res=st.executeUpdate(insertQuery);
		
		if(res == 0) {
			System.out.println("Record not inserted\n");
		}else {
			System.out.println("Record inserted succesfully\n");
		}
		st.close();
		con.close();
		//sc.close();
	}
	
	public static void AppDelete() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/Project_Doctor", "root","Manish@#2002");
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Appointment Number:- ");
		int a_id=sc.nextInt();
		
		String deleteQuery="delete from Appointment"
				+ " where AppointmentNumber = "+a_id+";";
		int res=st.executeUpdate(deleteQuery);
		
		if(res == 0) {
			System.out.println("Record not deleted\n");
		}else {
			System.out.println("Record deleted succesfully\n");
		}
		st.close();
		con.close();
		///sc.close();
		
	}
	
	public static void AppModify() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/Project_Doctor", "root","Manish@#2002");
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("-------------MODIFY APPOINTMENT DETAILS-------------- ");
		System.out.println("1. Change Patient Id ");
		System.out.println("2. Change Doctor Id ");
		System.out.println("3. Change Date of Appointment");
		System.out.println("4. Change Time of Appointment");
		System.out.println("0. Exit\n");
		
		System.out.println("Enter your choice: ");
		int ch = sc.nextInt();
		
		int app_no;
		
		switch(ch)
		
		{
		 	case 1:
		 		System.out.println("Enter Appointment Number:- ");
				app_no = sc.nextInt();
		 		System.out.println("Enter Patient Id:- ");
				int p_id= sc.nextInt();
		 		String ModPIdQuery=" update Appointment set PatientId = "+ p_id+" where AppointmentNumber ="+app_no+";";
		 		int res1=st.executeUpdate(ModPIdQuery);
				
				if(res1 == 0) {
					System.out.println("Record not updated\n");
				}else {
					System.out.println("Record updated succesfully\n");
				}
		 		break;
			
		 	case 2:
		 		System.out.println("Enter Appointment Number:- ");
				app_no = sc.nextInt();
		 		System.out.println("\nEnter Doctor Id:- ");
				int d_id= sc.nextInt();
		 		String ModDIdQuery=" update Appointment set DoctorId = "+ d_id+" where AppointmentNumber ="+app_no+";";
		 		int res2=st.executeUpdate(ModDIdQuery);
				
				if(res2 == 0) {
					System.out.println("Record not updated\n");
				}else {
					System.out.println("Record updated succesfully\n");
				}
		 		break;
		 		
		 	case 3:
		 		System.out.println("Enter Appointment Number:- ");
				app_no = sc.nextInt();
		 		System.out.println("Enter Date of Appointment (DD/MM/YY):- ");
				String app_date= sc.next();
		 		String ModDateQuery=" update Appointment set AppointmentDate = '"+ app_date +"' where AppointmentNumber ="+app_no+";";
		 		int res3=st.executeUpdate(ModDateQuery);
				
				if(res3 == 0) {
					System.out.println("Record not updated\n");
				}else {
					System.out.println("Record updated succesfully\n");
				}
		 		break;
		 		
		 		
		 	case 4:
		 		System.out.println("Enter Appointment Number:- ");
				app_no = sc.nextInt();
		 		System.out.println("Enter Date of Appointment (Eg: 10am-10:30am) :- ");
				String app_time = sc.next();
		 		String ModTimeQuery =" update Appointment set AppointmentTime = '"+ app_time +"' where AppointmentNumber ="+app_no+";";
		 		int res4=st.executeUpdate(ModTimeQuery);
				
				if(res4 == 0) {
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
	
	public static void AppShowAll() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/Project_Doctor", "root","Manish@#2002");
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		
		ResultSet rs=st.executeQuery("select * from Appointment;");
		
		while(rs.next()) {
			System.out.println(rs.getInt("AppointmentNumber")+" "+rs.getInt("PatientId")+" "+ rs.getInt("DoctorId")+" "+rs.getString("AppointmentDate")+" "
					+" "+rs.getString("AppointmentTime"));
			
		}
		System.out.println("\n");
		st.close();
		con.close();
		
	}
	
	public static void AppShowOne() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/Project_Doctor", "root","Manish@#2002");
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Appointment Number:- ");
		int u_id=sc.nextInt();
		
		ResultSet rs=st.executeQuery("select * from Appointment where AppointmentNumber ="+ u_id+";");
		
		while(rs.next()) {
			System.out.println(rs.getInt("AppointmentNumber")+" "+rs.getInt("PatientId")+" "+ rs.getInt("DoctorId")+" "+rs.getString("AppointmentDate")+" "
		+" "+rs.getString("AppointmentTime"));
			
		}
		System.out.println("\n");
		st.close();
		con.close();
		
	}

}
