//package org.busTicketBooking;
//import java.sql.*;
//import java.util.Scanner;
//
//public class UserServices {
//	Scanner sc = new Scanner (System.in);
//	
//	public int login() throws Exception {
//		Connection connection = DBconnection.getConnection();
//		System.out.println("Enter the UserName / UserID");
//		String uname = sc.nextLine();
//		System.out.println("Enter the Password");
//		String pwd = sc.nextLine();
//		
//		String check = "select * from bususer where Username = ? and Password = ?";
//		
//		PreparedStatement st = connection.prepareStatement(check);
//		
//		st.setString(1,uname);
//		st.setString(2,pwd);
//		ResultSet rst = st.executeQuery();
//		
//		if(rst.next())
//		{
//			System.out.println("✅ Login success! Welcome" + uname);
//			return rst.getInt("userid");
//		}
//		else
//		{
//			System.out.println("Incorrect Username or Password");
//		}
//		return -1;
//		
//
//	}
//	
//	public void register() throws Exception {
//		Connection connection = DBconnection.getConnection();
//		
//		 System.out.print("Choose Username: ");
//         String uname = sc.nextLine();
//         System.out.print("Choose Password: ");
//         String pwd = sc.nextLine();
//         System.out.print("Choose UserID: ");
//         int uid = sc.nextInt();
//         
//         PreparedStatement st = connection.prepareStatement("insert into bususer (uid, Username , Password) values (?,?,?)");
//		st.setLong(1,uid);
//		st.setString(2,uname);
//		st.setString(3, pwd);
//		
//		int rst = st.executeUpdate();
//		
//		if(rst>0)
//		{
//			System.out.println("✅ Registered & Logged in as " + uname);
//		}
//	}
//	
//
//}
