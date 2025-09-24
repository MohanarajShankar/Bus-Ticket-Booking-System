package org.busTicketBooking;
import java.util.Scanner;
import java.sql.*;
public class busController {

	


	
	
	    static Scanner sc = new Scanner(System.in);
	    static int loggedInUserId = -1;  //
	    public static void main(String[] args) throws Exception {
	        while (true) {
	            System.out.println("\n===== Bus Ticket Booking System =====");
	            System.out.println("1. Register");
	            System.out.println("2. Login");
	            System.out.println("3. View Buses");
	            System.out.println("4. Book Ticket");
	            System.out.println("5. Cancel Ticket");
	            System.out.println("6. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = sc.nextInt();
	            sc.nextLine();  // buffer clear

	            switch (choice) {
	                case 1:
	                    registerUser();
	                    break;
	                case 2:
	                    loginUser();
	                    break;
	                case 3:
	                    BookingService.viewBuses();
	                    break;
	                case 4:
	                    if (loggedInUserId != -1)
	                        BookingService.bookTicket(loggedInUserId);
	                    else
	                        System.out.println("❌ Login first to book ticket!");
	                    break;
	                case 5:
	                    if (loggedInUserId != -1)
	                        BookingService.cancelTicket(loggedInUserId);
	                    else
	                        System.out.println("❌ Login first to cancel ticket!");
	                    break;
	                case 6:
	                    System.out.println("🙏 Thank you for using the system!");
	                    System.exit(0);
	                default:
	                    System.out.println("⚠️ Invalid choice, try again!");
	            }
	        }
	    }

	    // Register user
	    static void registerUser() throws Exception {
	        System.out.print("Enter User ID: ");
	        int id = sc.nextInt();
	        sc.nextLine();
	        System.out.print("Enter Username: ");
	        String name = sc.nextLine();
	        System.out.print("Enter Password: ");
	        String pass = sc.nextLine();

	        Connection con = DBconnection.getConnection();
	        String sql = "INSERT INTO bususer(userid, username, password) VALUES(?,?,?)";
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setInt(1, id);
	        pst.setString(2, name);
	        pst.setString(3, pass);
	        pst.executeUpdate();
	        
	        
	        pst.close();
	        con.close();

	        System.out.println("✅ User registered successfully!");
	    }

	    // Login user
	    static void loginUser() throws Exception {
	        System.out.print("Enter Username: ");
	        String name = sc.nextLine();
	        System.out.print("Enter Password: ");
	        String pass = sc.nextLine();

	        Connection con = DBconnection.getConnection();
	        String sql = "SELECT userid FROM bususer WHERE username=? AND password=?";
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setString(1, name);
	        pst.setString(2, pass);
	        ResultSet rs = pst.executeQuery();

	        if (rs.next()) {
	            loggedInUserId = rs.getInt("userid");
	            System.out.println("✅ Login successful! Welcome " + name +" "+loggedInUserId  );
	        } else {
	            System.out.println("❌ Invalid credentials!");
	        }

	        rs.close();
	        pst.close();
	        con.close();
	    }
	}



